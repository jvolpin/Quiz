package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        List<String> archivoConLineas = new ArrayList<>();
        List<Pregunta> preguntas = new ArrayList<>();
        try {
            File myObj = new File("src/main/resources/preguntas");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                archivoConLineas.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }
        for (String lineaDeArchivo : archivoConLineas) {
            List<String> cadaLinea = new ArrayList<>(Arrays.stream(lineaDeArchivo.split(",")).toList());
            List<String> cadaRespuesta = new ArrayList<>(Arrays
                    .stream(cadaLinea.get(1).split("&")).toList());
            preguntas.add(new Pregunta(cadaLinea.get(0), cadaRespuesta, Integer.parseInt(cadaLinea.get(2))));
        }
        for(Pregunta pregunta : preguntas) {
            quiz.agregarPregunta(pregunta);
        }
        quiz.iniciarQuiz();
    }
}