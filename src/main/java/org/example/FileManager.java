package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    List<String> lineasDelArchivo = new ArrayList<>();
    List<Pregunta> preguntas = new ArrayList<>();

    public List<String> leerArchivo(String pathToFile) {
        try {
            File archivoConLineas = new File(pathToFile);
            Scanner lectorDeArchivo = new Scanner(archivoConLineas);
            while (lectorDeArchivo.hasNextLine()) {
                String data = lectorDeArchivo.nextLine();
                lineasDelArchivo.add(data);
            }
            lectorDeArchivo.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }
        return lineasDelArchivo;
    }

    public List<Pregunta> leerPreguntas(List<String> lineasDelArchivo) {
        for (String linea : lineasDelArchivo) {
            List<String> cadaLinea = new ArrayList<>(Arrays.stream(linea.split(",")).toList());
            List<String> cadaRespuesta = new ArrayList<>(Arrays
                    .stream(cadaLinea.get(1).split("&")).toList());
            preguntas.add(new Pregunta(cadaLinea.get(0), cadaRespuesta, Integer.parseInt(cadaLinea.get(2))));
        }
        return preguntas;
    }
}
