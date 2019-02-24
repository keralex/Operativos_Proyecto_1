/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos1;

import java.io.IOException;
import java.util.concurrent.Semaphore;

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
    int horaMesonero;
    int horaCocinerosEntrada;
    int horaCocinerosFuerte;
    int horaCocinerosPostre;
    int cantMesonesEntradas;
    int cantMesonesFuertes;
    int cantMesonesPostres;
    Meson mesonEntrada;
    Meson mesonFuerte;
    Meson mesonPostre;
    int apuntador;
    int val;
    
    Cocinero cocineroPrueba;
    //semaforos     
    private Semaphore semaProductores;
    private Semaphore semaConsumidores;
    private Semaphore semaExclusividad;
    private Semaphore semaImpresion;

    int horasRestaurant;
    String filename="C:\\Users\\kagua\\Desktop\\Operativos1\\src\\operativos1\\text.txt";
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
        this.cantMesonesEntradas=this.archivos.cant_Meson_CocineroEntrada;
        this.cantMesonesFuertes=this.archivos.cant_Meson_CocineroFuerte;
        this.cantMesonesPostres=this.archivos.cant_Meson_CocineroPostre;
        this.mesonEntrada=new Meson(this.cantMesonesEntradas);
        this.mesonFuerte=new Meson(this.cantMesonesFuertes);
        this.mesonPostre=new Meson(this.cantMesonesPostres);
        this.apuntador=0;
       
         //semaforos de cocinero entrada
         semaProductores=new Semaphore(this.cantMesonesEntradas);
         semaConsumidores=new Semaphore(0);
         semaExclusividad=new Semaphore(1);
         semaImpresion=new Semaphore(1);
         
         
    
        
        this.cocinarEntrada();
        
        
    }
    
    public void cocinarEntrada(){
        this.cocinerosEntrada=new Cocinero[this.cantCocinerosEntrada];
        //inicializar cocineros 
        for(int i=0;i<this.cocinerosEntrada.length;i++){
            
           this.cocinerosEntrada[i]=new Cocinero(this.semaProductores,this.semaExclusividad,this.semaConsumidores,this.horaCocinerosEntrada,"Entrada",this.mesonEntrada,this.apuntador,1,this.semaImpresion);
           this.cocinerosEntrada[i].start();
           
        }
       

    }

        
     

    
    
}
