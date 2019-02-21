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
public class Meson {
        private int[] meson;
        private int tamaño;
        

    public Meson(int tamaño) {
       
        this.tamaño = tamaño;
        this.meson=new int[this.tamaño];
    }

    public int[] getMeson() {
        return meson;
    }

    public void setMeson(int[] meson) {
        this.meson = meson;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
        public int getVec(int i,int val) {
        return meson[i]=val;
    }

    public void setVec(int i, int val) {
        this.meson[i] = val;
    }
    

   
        

}
