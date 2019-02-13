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
public class Operativos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        CocinaVista vista=new CocinaVista();
        vista.setVisible(true);
        String filename="C:\\Users\\kagua\\Documents\\NetBeansProjects\\Operativos_Proyecto_1\\src\\operativos1\\text.txt";
        LeerArchivos archivos=new LeerArchivos(filename);
        System.out.println(archivos.cant_Horas_Mesonero);
        
       
        
    }
    
}
