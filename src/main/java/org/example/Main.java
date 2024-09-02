package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        FileManager fileManager = new FileManager();
        quiz.iniciarQuiz(fileManager.leerPreguntas(fileManager.leerArchivo("src/main/resources/preguntas")));
    }
}