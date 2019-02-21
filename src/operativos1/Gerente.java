/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos1;


import operativos1.CocinaVista;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kagua
 */
public class Gerente extends Thread {

    private final int horas;
    private volatile boolean corriendo;
    JefeMesonero jefemesonero;
    CocinaVista CocinaVista;

    public Gerente(int hora, CocinaVista CocinaVista, JefeMesonero jefemesonero) {
        this.corriendo = false;
        this.horas = hora;
        this.CocinaVista = CocinaVista;
        this.jefemesonero = jefemesonero;
    }

    @Override
    public void run() {
        synchronized (this) {
            do {

                CocinaVista.getjTextField9().setText("Gerente Duerme");
                Random r = new Random();
                int rand = r.nextInt(( 27 * horas / 120) - (horas / 120) + 1) + (horas / 120);
                CocinaVista.getjTextField9().setText("Gerente Despierto"); //Durmiendo, despierta 
                //int numero = (int)(Math.random()*(200-45+1)+45);
                //float numero = (float)(Math.random()*(2-0.45+0.1)+0.45);  //verificar calculos de descanso 27 min equivalen a 0.45 horas y 120 min a 2 horas
                try {
                    Thread.sleep(rand * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (corriendo == false) {

                    try {
                        this.wait();

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } while (corriendo);
        }

    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }
}

