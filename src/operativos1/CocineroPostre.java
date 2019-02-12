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
public class CocineroPostre extends Cocinero{

    public CocineroPostre() {
       
        this.mesones=new Meson[this.capacidadMeson];
    }

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
