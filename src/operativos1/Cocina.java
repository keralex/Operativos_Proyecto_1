/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos1;

import java.io.IOException;

/**
 *
 * @author kagua
 */
public class Cocina  {
//Atributos
    
    Cocinero[] cocinerosEntrada;
    Cocinero[] cocinerosFuerte;
    Cocinero[] cocinerosPostre;
    Mesonero[] mesoneros;
    JefeMesonero jefeMesonero;
    Gerente gerente;
    int cantCocinerosEntrada;
    int cantCocinerosPostre;
    int cantCocinerosFuerte;
    int cantMaxCocinerosEntrada;
    int cantMaxCocinerosPostre;
    int cantMaxCocinerosFuerte;
    int cantMesoneros;
    float horaMesonero;
    float horaCocinerosEntrada;
    float horaCocinerosFuerte;
    float horaCocinerosPostre;

    int horasRestaurant;
    String filename="C:\\Users\\kagua\\Documents\\NetBeansProjects\\Operativos_Proyecto_1\\src\\operativos1\\text.txt";
    LeerArchivos archivos;
 
    
    
    
    
    
    public Cocina() throws IOException {
        this.archivos = new LeerArchivos(this.filename);
        this.cantCocinerosEntrada=this.archivos.cant_CocinerosEntradas;
        this.cantCocinerosFuerte=this.archivos.cant_CocinerosFuerte;
        this.cantCocinerosPostre=this.archivos.cant_CocinerosPostre;
        this.cantMaxCocinerosEntrada=this.archivos.cant_max_CocinerosEntradas;
        this.cantMaxCocinerosFuerte=this.archivos.cant_max_CocinerosFuerte;
        this.cantMaxCocinerosPostre=this.archivos.cant_max_CocinerosPostre;
        this.cantMesoneros=this.archivos.cant_mesoneros;
        this.horaMesonero=this.archivos.cant_Horas_Mesonero;
        this.horaCocinerosEntrada=this.archivos.cant_Horas_CocineroEntrada;
        this.horaCocinerosFuerte=this.archivos.cant_Horas_CocineroFuerte;
        this.horaCocinerosPostre=this.archivos.cant_Horas_CocineroPostre;
        
        
        this.cocinar();
        
        
    }
    
    public void cocinar(){
        this.cocinerosEntrada=new Cocinero[this.cantCocinerosEntrada];
        //inicializar cocineros 
        for(int i=0;i<this.cocinerosEntrada.length;i++){
            this.cocinerosEntrada[i]=new Cocinero(this.horaCocinerosEntrada,20);
            
        }
        Cocinero cocinero=new Cocinero(this.horaCocinerosFuerte,20);
        cocinero.start();
        cocinero.run();
    }


    
    
}
