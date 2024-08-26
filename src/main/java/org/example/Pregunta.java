package org.example;

import java.util.List;

public class Pregunta {
    private String pregunta;
    private List<String> respuestas;
    private int respuestaCorrecta;

    public Pregunta(String pregunta, List<String> respuestas, int respuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void mostrarPregunta() {
        System.out.println(pregunta);
        for (String respuesta : respuestas) {
            System.out.println(respuestas.indexOf(respuesta)+1 + ". " + respuesta);
        }
    }
}
