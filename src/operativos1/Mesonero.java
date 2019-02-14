/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos1;

import operativos1.CocinaVista;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kagua
 */
public class Mesonero extends Thread {

    private final int horas = 2;
    private volatile boolean corriendo;
    CocinaVista CocinaVista;

    public Mesonero(CocinaVista CocinaVista) {
        this.corriendo = false;
        this.CocinaVista = CocinaVista;
    }

    @Override
    public void run() {
        synchronized (this) {
            do {
                
                if (corriendo == false) {

                    try {
                        this.wait();

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesonero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                try {
                    Thread.sleep(horas * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mesonero.class.getName()).log(Level.SEVERE, null, ex);
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

