import Interfaces.PilaTDA;
import implementacion.Pila;

public class Main {

    public static void main(String[] args) {

        // =========================
        // 1) Historial de páginas
        // =========================
        PilaTDA historial = new Pila();
        historial.InicializarPila();

        historial.Apilar(1); // fi.uba.ar
        historial.Apilar(2); // campus.utn.edu.ar
        historial.Apilar(3); // stackoverflow.com

        System.out.println("Página actual: " + historial.Tope());

        historial.Desapilar();

        System.out.println("Página después de volver: " + historial.Tope());


        // =========================
        // 2) Undo / Deshacer
        // =========================
        PilaTDA editor = new Pila();
        editor.InicializarPila();

        editor.Apilar(1); // código inicial
        editor.Apilar(2); // agrego línea
        editor.Apilar(3); // borro línea (error)

        System.out.println("Estado actual del código: " + editor.Tope());

        editor.Desapilar();

        System.out.println("Estado después de deshacer: " + editor.Tope());
    }
}