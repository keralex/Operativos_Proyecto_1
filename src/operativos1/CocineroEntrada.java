/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos1;

/**
 *
 * @author kagua
 */
public class CocineroEntrada extends Cocinero {

    //constructor
    public CocineroEntrada() {
                this.mesones=new Meson[this.capacidadMeson];

    }
    
    
    //Funcionews
    
    
    public void cocinar(){
        System.out.println("cocinero de entrada cocina");
    }
    
    public void esperarSegundos(int segundos) throws InterruptedException{
        try{
            Thread.sleep(segundos * 1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
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
