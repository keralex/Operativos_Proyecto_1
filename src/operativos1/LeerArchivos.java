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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerArchivos {
    
        int segundos_hora;
        int cant_Meson_CocineroPostre;
        int cant_Meson_CocineroFuerte;
        int cant_Meson_CocineroEntrada;
        int cant_CocinerosPostre;
        int cant_CocinerosFuerte;
        int cant_CocinerosEntradas;
        int cant_max_CocinerosPostre;
        int cant_max_CocinerosFuerte;
        int cant_max_CocinerosEntradas;
        int cant_mesoneros;
        int cant_max_mesoneros;
        float cant_Horas_CocineroPostre;
        float cant_Horas_CocineroFuerte;
        float cant_Horas_CocineroEntrada;
        float cant_Horas_Mesonero;


    public LeerArchivos(String namefile) throws IOException{
        int linenumber=1;
        
        try{
              BufferedReader in= new BufferedReader(new FileReader(namefile));
              String line=null;
               while(((line=in.readLine())!=null)||linenumber==16){
                 switch (linenumber) {
            case 1:  this.segundos_hora= Integer.parseInt(line);
                     break;
            case 2:  this.cant_Meson_CocineroPostre = Integer.parseInt(line);
                     break;
            case 3:  this.cant_Meson_CocineroFuerte = Integer.parseInt(line);
                     break;
            case 4:  this.cant_Meson_CocineroEntrada = Integer.parseInt(line);
                     break;
            case 5:  this.cant_CocinerosPostre= Integer.parseInt(line);
                     break;
            case 6:  this.cant_CocinerosFuerte= Integer.parseInt(line);
                     break;
            case 7:  this.cant_CocinerosEntradas= Integer.parseInt(line);
                     break;
            case 8:  this.cant_max_CocinerosPostre= Integer.parseInt(line);
                     break;
            case 9:  this.cant_max_CocinerosFuerte= Integer.parseInt(line);
                     break;
            case 10:  this.cant_max_CocinerosEntradas= Integer.parseInt(line);
                     break;
            case 11:  this.cant_mesoneros= Integer.parseInt(line);
                     break;
            case 12:  this.cant_max_mesoneros= Integer.parseInt(line);
                     break;
            case 13:  this.cant_Horas_CocineroPostre = Float.valueOf(line);
                     break;
            case 14:  this.cant_Horas_CocineroFuerte = Float.valueOf(line);
                     break;
            case 15:  this.cant_Horas_CocineroEntrada = Float.valueOf(line);
                     break;
            case 16:  this.cant_Horas_Mesonero= Float.valueOf(line);
                     break;


        }
                 linenumber++;
            }

            
        }catch (FileNotFoundException ex) {
            Logger.getLogger(LeerArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
    }

    public int getSegundos_hora() {
        return segundos_hora;
    }

    public void setSegundos_hora(int segundos_hora) {
        this.segundos_hora = segundos_hora;
    }

    public int getCant_Meson_CocineroPostre() {
        return cant_Meson_CocineroPostre;
    }

    public void setCant_Meson_CocineroPostre(int cant_Meson_CocineroPostre) {
        this.cant_Meson_CocineroPostre = cant_Meson_CocineroPostre;
    }

    public int getCant_Meson_CocineroFuerte() {
        return cant_Meson_CocineroFuerte;
    }

    public void setCant_Meson_CocineroFuerte(int cant_Meson_CocineroFuerte) {
        this.cant_Meson_CocineroFuerte = cant_Meson_CocineroFuerte;
    }

    public int getCant_Meson_CocineroEntrada() {
        return cant_Meson_CocineroEntrada;
    }

    public void setCant_Meson_CocineroEntrada(int cant_Meson_CocineroEntrada) {
        this.cant_Meson_CocineroEntrada = cant_Meson_CocineroEntrada;
    }

    public int getCant_CocinerosPostre() {
        return cant_CocinerosPostre;
    }

    public void setCant_CocinerosPostre(int cant_CocinerosPostre) {
        this.cant_CocinerosPostre = cant_CocinerosPostre;
    }

    public int getCant_CocinerosFuerte() {
        return cant_CocinerosFuerte;
    }

    public void setCant_CocinerosFuerte(int cant_CocinerosFuerte) {
        this.cant_CocinerosFuerte = cant_CocinerosFuerte;
    }

    public int getCant_CocinerosEntradas() {
        return cant_CocinerosEntradas;
    }

    public void setCant_CocinerosEntradas(int cant_CocinerosEntradas) {
        this.cant_CocinerosEntradas = cant_CocinerosEntradas;
    }

    public int getCant_max_CocinerosPostre() {
        return cant_max_CocinerosPostre;
    }

    public void setCant_max_CocinerosPostre(int cant_max_CocinerosPostre) {
        this.cant_max_CocinerosPostre = cant_max_CocinerosPostre;
    }

    public int getCant_max_CocinerosFuerte() {
        return cant_max_CocinerosFuerte;
    }

    public void setCant_max_CocinerosFuerte(int cant_max_CocinerosFuerte) {
        this.cant_max_CocinerosFuerte = cant_max_CocinerosFuerte;
    }

    public int getCant_max_CocinerosEntradas() {
        return cant_max_CocinerosEntradas;
    }

    public void setCant_max_CocinerosEntradas(int cant_max_CocinerosEntradas) {
        this.cant_max_CocinerosEntradas = cant_max_CocinerosEntradas;
    }

    public int getCant_mesoneros() {
        return cant_mesoneros;
    }

    public void setCant_mesoneros(int cant_mesoneros) {
        this.cant_mesoneros = cant_mesoneros;
    }

    public int getCant_max_mesoneros() {
        return cant_max_mesoneros;
    }

    public void setCant_max_mesoneros(int cant_max_mesoneros) {
        this.cant_max_mesoneros = cant_max_mesoneros;
    }

    public float getCant_Horas_CocineroPostre() {
        return cant_Horas_CocineroPostre;
    }

    public void setCant_Horas_CocineroPostre(float cant_Horas_CocineroPostre) {
        this.cant_Horas_CocineroPostre = cant_Horas_CocineroPostre;
    }

    public float getCant_Horas_CocineroFuerte() {
        return cant_Horas_CocineroFuerte;
    }

    public void setCant_Horas_CocineroFuerte(float cant_Horas_CocineroFuerte) {
        this.cant_Horas_CocineroFuerte = cant_Horas_CocineroFuerte;
    }

    public float getCant_Horas_CocineroEntrada() {
        return cant_Horas_CocineroEntrada;
    }

    public void setCant_Horas_CocineroEntrada(float cant_Horas_CocineroEntrada) {
        this.cant_Horas_CocineroEntrada = cant_Horas_CocineroEntrada;
    }
        
    
    
    
}
