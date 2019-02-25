/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos1;

import java.io.IOException;
import java.util.concurrent.Semaphore;
import javax.swing.JTextField;

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
    int apuntadorE;
    int apuntadorF;
    int apuntadorP;

    
    Cocinero cocineroPrueba;
    //semaforos     
    private Semaphore semaProductorE;
    private Semaphore semaConsumidorE;
    private Semaphore semaExclusividadE;
    private Semaphore semaImpresionE;
    
    private Semaphore semaProductorF;
    private Semaphore semaConsumidorF;
    private Semaphore semaExclusividadF;
    private Semaphore semaImpresionF;
    
    private Semaphore semaProductorP;
    private Semaphore semaConsumidorP;
    private Semaphore semaExclusividadP;
    private Semaphore semaImpresionP;

    int horasRestaurant;
    String filename="C:\\Users\\kagua\\Desktop\\Operativos1\\src\\operativos1\\text.txt";
    LeerArchivos archivos;
 
   private int[] undsFinales;
   private int [] contadorHoraCierre;
   private JTextField CantidadEntradas;
   private JTextField CantidadFuertes;
   private JTextField CantidadPostres;
   private JTextField CantidadConierosFinales;
   private JTextField statusGerente;
   private JTextField statusJefeMesoneros;
   private JTextField HoraParaCierre;
   private JTextField HoraTranscurrida;
   
    
    
    
    
    public Cocina(JTextField CantidadEntradas,JTextField CantidadFuertes,JTextField CantidadPostres) throws IOException {
        this.archivos = new LeerArchivos(this.filename);
        this.cantCocinerosEntrada=this.archivos.cant_CocinerosEntradas;
        this.cantCocinerosFuerte=this.archivos.cant_CocinerosFuerte;
        this.cantCocinerosPostre=this.archivos.cant_CocinerosPostre;
        this.cantMaxCocinerosEntrada=this.archivos.cant_max_CocinerosEntradas;
        this.cantMaxCocinerosFuerte=this.archivos.cant_max_CocinerosFuerte;
        this.cantMaxCocinerosPostre=this.archivos.cant_max_CocinerosPostre;
        this.cantMesoneros=this.archivos.cant_mesoneros;
     //HORAS
        this.horaMesonero=this.archivos.cant_Horas_Mesonero;
        this.horaCocinerosEntrada=this.archivos.cant_Horas_CocineroEntrada;
        this.horaCocinerosFuerte=this.archivos.cant_Horas_CocineroFuerte;
        this.horaCocinerosPostre=this.archivos.cant_Horas_CocineroPostre;
        //Cantidad de mesones
        this.cantMesonesEntradas=this.archivos.cant_Meson_CocineroEntrada;
        this.cantMesonesFuertes=this.archivos.cant_Meson_CocineroFuerte;
        this.cantMesonesPostres=this.archivos.cant_Meson_CocineroPostre;
        
        //MESONES
        this.mesonEntrada=new Meson(this.cantMesonesEntradas);
        this.mesonFuerte=new Meson(this.cantMesonesFuertes);
        this.mesonPostre=new Meson(this.cantMesonesPostres);
        
        //Apuntadores
        this.apuntadorE=0;
        this.apuntadorF=0;
        this.apuntadorP=0;

       
         //semaforos de cocinero entrada
         this.semaProductorE=new Semaphore(this.cantMesonesEntradas);
         this.semaConsumidorE=new Semaphore(0);
         this.semaExclusividadE=new Semaphore(1);
         this.semaImpresionE=new Semaphore(1);
         //Semafotos de cocinero fuerte
         this.semaProductorF=new Semaphore(this.cantMesonesFuertes);
         this.semaConsumidorF=new Semaphore(0);
         this.semaExclusividadF=new Semaphore(1);
         this.semaImpresionF=new Semaphore(1);
         
         //Semaforos de cocinero postre
         this.semaProductorP=new Semaphore(this.cantMesonesPostres);
         this.semaConsumidorP=new Semaphore(0);
         this.semaExclusividadP=new Semaphore(1);
         this.semaImpresionP=new Semaphore(1);
         //jtextfield
         this.CantidadEntradas=CantidadEntradas;
         this.CantidadFuertes=CantidadFuertes;
         this.CantidadPostres=CantidadPostres;
                
                 
                 
    
        
        this.Cocinar();
        
        
    }
    
    
    
    
        
 public void Cocinar(){
     
     //COCINEROS DE ENTRADA
        this.cocinerosEntrada=new Cocinero[this.cantCocinerosEntrada];
        //inicializar cocineros 
        for(int i=0;i<this.cocinerosEntrada.length;i++){
            
           this.cocinerosEntrada[i]=new Cocinero(this.semaProductorE,this.semaExclusividadE,this.semaConsumidorE,this.horaCocinerosEntrada,"Entrada",this.mesonEntrada,this.apuntadorE,1,this.semaImpresionE,this.CantidadEntradas);
           this.cocinerosEntrada[i].start();
           
        }
        
      //COCINEROS DE PLATO FUERTE   
      
        this.cocinerosFuerte=new Cocinero[this.cantCocinerosFuerte];
        
           for(int i=0;i<this.cocinerosFuerte.length;i++){
            
           this.cocinerosFuerte[i]=new Cocinero(this.semaProductorF,this.semaExclusividadF,this.semaConsumidorF,this.horaCocinerosFuerte,"Fuerte",this.mesonFuerte,this.apuntadorF,1,this.semaImpresionF,this.CantidadFuertes);
           this.cocinerosFuerte[i].start();
           
        }
           
        //COCINEROS DE POSTRE
        
        this.cocinerosPostre=new Cocinero[this.cantCocinerosPostre];
        for(int i=0;i<this.cocinerosPostre.length;i++){
            
           this.cocinerosPostre[i]=new Cocinero(this.semaProductorP,this.semaExclusividadP,this.semaConsumidorP,this.horaCocinerosPostre,"Postre",this.mesonPostre,this.apuntadorP,1,this.semaImpresionP,this.CantidadPostres);
           this.cocinerosPostre[i].start();
           
        }
       

    }

        
     

    
    
}
