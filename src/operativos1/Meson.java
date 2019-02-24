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
        private int tam;
        

    public Meson(int tam) {
       
        this.tam= tam;
        this.meson=new int[this.tam];
    }

    public int[] getMeson() {
        return meson;
    }

    public void setMeson(int[] meson) {
        this.meson = meson;
    }

    public int getTamaño() {
        return tam;
    }

    public void setTamaño(int tamaño) {
        this.tam = tamaño;
    }
        public int getVec(int i,int val) {
        return meson[i]=val;
    }

    public void setVec(int i, int val) {
        this.meson[i] = val;
    }
    
    public void imprimir(){
        for(int i=0; i<tam; i++){
            System.out.print(meson[i]+" ");
        }
        System.out.println("");
    }
    
   
        

}
