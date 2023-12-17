package com.projecto.Horadada.Util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;

public class Common {

    public int[] ultanios(int rango) {
        int currentYear = Year.now().getValue();
        int[] aniosArr = new int[rango];
        int c = 0;
        for (int i = currentYear; i > currentYear - rango; i--) {
            aniosArr[c] = i;
            c = c + 1;
        }
        return aniosArr;
    }

    public String buscarFile(String ruta, String nombre) {
        // Ruta del directorio donde se buscará el archivo
        String directorio = "D:/fileserver/" + ruta;

        // Nombre del archivo que se busca
        String nombreArchivo = nombre;

        // Creamos un objeto File para el directorio
        File dir = new File(directorio);

        // Verificamos si el directorio existe y es un directorio
        if (dir.exists() && dir.isDirectory()) {
            // Obtenemos un array de File con los archivos y subdirectorios dentro del directorio
            File[] archivos = dir.listFiles();

            // Iteramos sobre el array de File para buscar el archivo
            for (File archivo : archivos) {
                // Verificamos si el archivo es un archivo regular y si su nombre coincide con el que buscamos
                if (archivo.isFile() && archivo.getName().equals(nombreArchivo)) {
                    // Hemos encontrado el archivo
                    System.out.println("El archivo se encuentra en: " + archivo.getAbsolutePath());
                    return archivo.getAbsolutePath();
                }
            }
            // Si llegamos hasta aquí es porque no encontramos el archivo
            System.out.println("El archivo no se encuentra en el directorio especificado.");
        } else {
            // El directorio no existe o no es un directorio
            System.out.println("El directorio especificado no existe o no es un directorio.");
        }
        return null;
    }
    
    public boolean existeArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        return archivo.exists();
    }
    
    public Date setearFecha(String fecha) throws ParseException{
        SimpleDateFormat form =  new SimpleDateFormat("yyyy-mm-dd");
        return form.parse(fecha);
    } 
    public int getEdad(Date fecha){
        LocalDate fechaActual  = LocalDate.now();
        Period periodo = Period.between(fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() , fechaActual);
        
        return periodo.getYears();
    }
}
