/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosgonzalez.savedatasApp.main;

import java.io.File;
import java.util.Date;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;


/**
 *
 * @author alejandroCarlos
 */
public class CopyFile {
    private String rutaOrigen;
    private String rutaDestino;
    
    public CopyFile(){
        rutaOrigen = "E:\\Usuarios\\Carlos\\Documents\\The Witcher 3";
        rutaDestino = "E:\\Usuarios\\Carlos\\Escritorio\\savedatas\\The Witcher 3";
    }
    
    public CopyFile(String rutaOrigen, String rutaDestino){
        this.rutaOrigen = rutaOrigen;
        this.rutaDestino = rutaDestino;
    }
    
    public boolean copyDirectory(){
        File fileOrigen = new File(rutaOrigen);
        File fileDestino = new File(rutaDestino + "\\" + getTimestamp());

        try {
            FileUtils.copyDirectory(fileOrigen, fileDestino);
        } catch (IOException ex) {
            Logger.getLogger(CopyFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    private String getTimestamp(){
        return new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
    }
}
