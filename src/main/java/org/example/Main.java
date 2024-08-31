package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        List<String> lineasDelArchivo = new ArrayList<>();
        List<Pregunta> preguntas = new ArrayList<>();
        try {
            File archivoConLineas = new File("src/main/resources/preguntas");
            Scanner lectorDeArchivo = new Scanner(archivoConLineas);
            while (lectorDeArchivo.hasNextLine()) {
                String data = lectorDeArchivo.nextLine();
                lineasDelArchivo.add(data);
            }
            lectorDeArchivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }
        for (String linea : lineasDelArchivo) {
            List<String> cadaLinea = new ArrayList<>(Arrays.stream(linea.split(",")).toList());
            List<String> cadaRespuesta = new ArrayList<>(Arrays
                    .stream(cadaLinea.get(1).split("&")).toList());
            preguntas.add(new Pregunta(cadaLinea.get(0), cadaRespuesta, Integer.parseInt(cadaLinea.get(2))));
        }
        quiz.iniciarQuiz(preguntas);
    }
}