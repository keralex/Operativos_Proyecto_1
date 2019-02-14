/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kagua
 */
public class Cocinero extends Thread {
    int capacidadMeson;
    Meson[] mesones;
    int horaProducion;
    
    
    //constructor
    public Cocinero(float horas, int meson) {
               
                this.capacidadMeson=meson;
                this.horaProducion=(int)(horas*100);
                this.mesones=new Meson[this.capacidadMeson];

    }
    
    
    //Funcionews
    
    
    public void cocinar(){
        System.out.println("cocinero cocina");
    }
    
    public void esperarSegundos(int segundos) throws InterruptedException{
        try{
            System.out.println("Cocinando");
            Thread.sleep(segundos*1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
    
    //Public Void run y star 
    
    public void run(){
        this.cocinar();
        try {
            this.esperarSegundos(this.horaProducion);
           
        } catch (InterruptedException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Termino de cocinar");
    }
    
  
    //Getters y Setters
    public int getCapacidadMeson() {
        return capacidadMeson;
    }

    public void setCapacidadMeson(int capacidadMeson) {
        this.capacidadMeson = capacidadMeson;
    }

    public Meson[] getMesones() {
        return mesones;
    }

    public void setMesones(Meson[] mesones) {
        this.mesones = mesones;
    }
    
    
}
