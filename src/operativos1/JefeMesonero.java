/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import operativos1.CocinaVista;

/**
 *
 * @author artur
 */

public class JefeMesonero extends Thread {

    private int contador;
    private final int horas;
    private volatile boolean corriendo;
    Gerente gerente;
    private final CocinaVista CocinaVista;

    public int getContador() {
        return contador;
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public JefeMesonero(int dias, CocinaVista CocinaVista, Gerente gerente) {
        this.horas = dias;
        this.CocinaVista = CocinaVista;
        this.gerente = gerente;
    }

    @Override
    public void run() {

        synchronized (this) {
            do {

                if (contador == 1) {
                    CocinaVista.getjTextField8().setText("Reiniciando contador");
                    try {
                        Thread.sleep((long) (horas * 0.25 * 1000));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JefeMesonero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    contador = horas;
                    CocinaVista.getjTextField6().setText(Integer.toString(contador));
                } else {
                    CocinaVista.getjTextField8().setText("Cambiando contador");
                    try {
                        Thread.sleep((long) (horas * 0.25 * 1000));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JefeMesonero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    contador--;
                    CocinaVista.getjTextField6().setText(Integer.toString(contador));
                }
                CocinaVista.getjTextField8().setText("Nada");
                try {
                    Thread.sleep(horas * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JefeMesonero.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (corriendo == false) {

                    try {
                        this.wait();

                    } catch (InterruptedException ex) {
                        Logger.getLogger(JefeMesonero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } while (corriendo);
        }

    }

}
