package org.example;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Pregunta> preguntas;
    private int puntaje;

    public Quiz() {
        preguntas = new ArrayList<Pregunta>();
        puntaje = 0;
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    public void evaluarPregunta(int indicePregunta, int respuestaUsuario){
        if(preguntas.get(indicePregunta).getRespuestaCorrecta() == respuestaUsuario){
            puntaje++;
        }
    }

    public void mostrarPuntaje() {
        System.out.println("Su puntaje es: " + puntaje);
    }


}
