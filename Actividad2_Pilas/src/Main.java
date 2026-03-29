import Interfaces.PilaTDA;
import implementacion.Pila;

public class Main {

    static void main(String[] args) {

        // =========================
        // 1) Historial de páginas
        // =========================
        System.out.println("Ejercicio 1:");

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
        System.out.println("\nEjercicio 2:");
        PilaTDA editor = new Pila();
        editor.InicializarPila();

        editor.Apilar(1); // código inicial
        editor.Apilar(2); // agrego línea
        editor.Apilar(3); // borro línea (error)

        System.out.println("Estado actual del código: " + editor.Tope());

        editor.Desapilar();

        System.out.println("Estado después de deshacer: " + editor.Tope());

        // =========================
        // 3) Balanceo de parentesis
        // =========================
        System.out.println("\nEjercicio 3:");
        String ejemplo = "((a+b)*c)";
        if (EstaBalanceado(ejemplo) == true) {
            System.out.println("La expresion "+ ejemplo + " tiene parentesis balanceados");
        }
        else {
            System.out.println("La expresion "+ ejemplo + " NO tiene parentesis balanceados");
        }
        String ejemplo2 = "((a+b+c)*d";
        if (EstaBalanceado(ejemplo2) == true) {
            System.out.println("La expresion "+ ejemplo2 + " tiene parentesis balanceados");
        }
        else {
            System.out.println("La expresion "+ ejemplo2 + " NO tiene parentesis balanceados");
        }
    }

    //Metodo para verificar los parentesis
    public static boolean EstaBalanceado(String linea) {
        PilaTDA pila = new Pila();
        pila.InicializarPila();
        for (char caracter : linea.toCharArray()) {
            if (caracter == '(') {
                pila.Apilar(caracter); //Se apila al abrir un parentesis
            }
            else if (caracter == ')') {
                if (pila.PilaVacia()) {
                    return false;  // Esto significa que los parentesis no están balanceados
                } else {
                    pila.Desapilar(); //Se desapila al cerrar un parentesis
                }
            }
        }return pila.PilaVacia(); //Si está vacía, los parentesis están balanceados (true)
    }
}