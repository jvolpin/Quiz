package org.example;

import java.util.List;

public class Pregunta {
    private String tituloPregunta;
    private List<String> respuestas;
    private int respuestaCorrecta;

    public Pregunta(String tituloPregunta, List<String> respuestas, int respuestaCorrecta) {
        this.tituloPregunta = tituloPregunta;
        this.respuestas = respuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void mostrarPregunta() {
        System.out.println(tituloPregunta);
        for (String respuesta : respuestas) {
            System.out.println(respuestas.indexOf(respuesta)+1 + ". " + respuesta);
        }
    }
}
