/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kagua
 */
public class Cocinero extends Thread {
    
    //semaforos
    private Semaphore SExclusividad;
    private Semaphore SProductor;
    private Semaphore SConsumidor;
      private Semaphore SImpresion;
    //atributos

    private Meson mesones;
    private int horaProducion;
    private String tipo;
    private boolean ejecutar=true;
    private int apuntador;
    private int val;

    
    
    //constructor
    public Cocinero(Semaphore SP, Semaphore SE, Semaphore SC, float horas, String tipo, Meson meson, int apuntador, int val,Semaphore sI) {
               
                this.SConsumidor=SC;
                this.SExclusividad=SE;
                this.SProductor=SP;
                this.tipo=tipo;
                this.horaProducion=(int)(horas*100);
                this.mesones=meson;
                this.apuntador=apuntador;
                this.val=val;
                this.SImpresion=sI;
                  

    }
    
    
    //Funciones*****************
    
    //Cocina
    public void cocinar(){
        System.out.println("cocinero de " + this.tipo);
        
        try {
            this.esperarSegundos(this.horaProducion);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Termino de cocinar");
    }
    
    
    
    //Deja en el meson la comida
    public void DejarComida(){
        System.out.println("entro a dejar comida");
        mesones.setVec(this.apuntador, val);
        
        this.apuntador=(this.apuntador+1)%mesones.getTamaño();
              
        System.out.println("Se dejo en el meson");
    }
    
    
    
    public void esperarSegundos(int segundos) throws InterruptedException{
        try{
            System.out.println("Cocinando");
            Thread.sleep(segundos);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
            
        }
    }
    
    //Public Void run y start   *************************************************************
    
    public void run(){
        
        while(ejecutar){
           try {
                SProductor.acquire();
                SExclusividad.acquire(); 
                this.cocinar();
                this.DejarComida();
                SExclusividad.release();
                SConsumidor.release();
                        
                } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
           try{
               SImpresion.acquire();
           }catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
           this.mesones.imprimir();
           SImpresion.release();
                         

         
    }   

        }
        
        
      
    


    public Meson getMesones() {
        return mesones;
    }

    public void setMesones(Meson mesones) {
        this.mesones = mesones;
    }

    public int getHoraProducion() {
        return horaProducion;
    }

    public void setHoraProducion(int horaProducion) {
        this.horaProducion = horaProducion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Semaphore getSExclusividad() {
        return SExclusividad;
    }

    public void setSExclusividad(Semaphore SExclusividad) {
        this.SExclusividad = SExclusividad;
    }

    public Semaphore getSProductor() {
        return SProductor;
    }

    public void setSProductor(Semaphore SProductor) {
        this.SProductor = SProductor;
    }

    public Semaphore getSConsumidor() {
        return SConsumidor;
    }

    public void setSConsumidor(Semaphore SConsumidor) {
        this.SConsumidor = SConsumidor;
    }

    public boolean isEjecutar() {
        return ejecutar;
    }

    public void setEjecutar(boolean ejecutar) {
        this.ejecutar = ejecutar;
    }

    
    
    
}
