package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Pregunta> preguntas;
    private int puntaje;
    private Scanner scanner = new Scanner(System.in);


    public Quiz() {
        preguntas = new ArrayList<Pregunta>();
        puntaje = 0;
//        preguntas.
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    //va a haber muchas preguntas en el quiz, hay que fijarse cual es la pregunta que estamos evaluando
    //y ver si la respuesta dada por el usuario es la rta correcta.
    private void evaluarPregunta(Pregunta pregunta, int respuestaUsuario){
        if(pregunta.getRespuestaCorrecta() == respuestaUsuario){
            puntaje++;
        }
    }

    //Respuestas correctas sobre el total
    public void mostrarPuntaje() {
        System.out.println("Su puntaje es: " + puntaje + "/" + preguntas.size());
    }

    public void realizarPregunta(Pregunta pregunta) {
        pregunta.mostrarPregunta();
        System.out.print("Indique su respuesta: ");
        int respuestaUsuario = Integer.parseInt(scanner.nextLine());
        evaluarPregunta(pregunta, respuestaUsuario);
    }
    public void iniciarQuiz() {
        for (Pregunta pregunta : preguntas) {
            realizarPregunta(pregunta);
        }
        mostrarPuntaje();
    }
}
