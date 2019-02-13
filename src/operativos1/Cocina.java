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
public class Cocina {
//Atributos
    
    CocineroEntrada[] cocinerosEntrada;
    CocineroFuerte[] cocinerosFuerte;
    CocineroPostre[] cocinerosPostre;
    Mesonero[] mesoneros;
    JefeMesonero jefeMesonero;
    Gerente gerente;
    int cantCocinerosEntrada;
    int cantCocinerosPostre;
    int cantCocinerosFuerte;
    int cantMesoneros;
    int horasTrabajo;
    String filename="C:\\Users\\kagua\\Documents\\NetBeansProjects\\Operativos_Proyecto_1\\src\\operativos1\\text.txt";
    LeerArchivos archivos;
 
    
    
    
    
    
    public Cocina() throws IOException {
        this.archivos = new LeerArchivos(this.filename);
        
    }
    
    
    
    
}
