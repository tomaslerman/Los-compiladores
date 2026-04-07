import Interfaces.PilaTDA;
import implementacion.Pila;
import Interfaces.ColaTDA;
import implementacion.Cola;
import Interfaces.ColaPrioridadTDA;
import implementacion.ColaPrioridad;

public class Main {

    public static void main(String[] args) {

        // =========================
        // 1) Historial de páginas
        // =========================
        System.out.println("Ejercicio 1:");

        PilaTDA historial = new Pila();
        historial.InicializarPila();

        historial.Apilar(1);
        historial.Apilar(2);
        historial.Apilar(3);

        System.out.println("Página actual: " + historial.Tope());

        historial.Desapilar();

        System.out.println("Página después de volver: " + historial.Tope());

        // =========================
        // 2) Undo / Deshacer
        // =========================
        System.out.println("\nEjercicio 2:");

        PilaTDA editor = new Pila();
        editor.InicializarPila();

        editor.Apilar(1);
        editor.Apilar(2);
        editor.Apilar(3);

        System.out.println("Estado actual: " + editor.Tope());

        editor.Desapilar();

        System.out.println("Estado después de deshacer: " + editor.Tope());

        // =========================
        // 3) Balanceo de paréntesis
        // =========================
        System.out.println("\nEjercicio 3:");

        String ejemplo = "((a+b)*c)";
        System.out.println("Expresión 1: " + (EstaBalanceado(ejemplo) ? "Correcta" : "Incorrecta"));

        String ejemplo2 = "((a+b+c)*d";
        System.out.println("Expresión 2: " + (EstaBalanceado(ejemplo2) ? "Correcta" : "Incorrecta"));

        // =========================
        // 4) Reversión de String
        // =========================
        System.out.println("\nEjercicio 4:");

        String palabra = "ALGORITMOS";
        PilaTDA pilaString = new Pila();
        pilaString.InicializarPila();

        for (int i = 0; i < palabra.length(); i++) {
            pilaString.Apilar((int) palabra.charAt(i));
        }

        System.out.print("Invertida: ");
        while (!pilaString.PilaVacia()) {
            System.out.print((char) pilaString.Tope());
            pilaString.Desapilar();
        }
        System.out.println();

        // =========================
        // 5) Call Stack
        // =========================
        System.out.println("\nEjercicio 5:");

        PilaTDA callStack = new Pila();
        callStack.InicializarPila();

        callStack.Apilar(1); // Main
        callStack.Apilar(2); // Calcular
        callStack.Apilar(3); // Sumar

        System.out.println("Función en ejecución: " + callStack.Tope());

        // =========================
        // 6) Directorios
        // =========================
        System.out.println("\nEjercicio 6:");

        PilaTDA directorios = new Pila();
        directorios.InicializarPila();

        directorios.Apilar(1);
        directorios.Apilar(2);
        directorios.Apilar(3);

        System.out.println("Actual: " + directorios.Tope());
        directorios.Desapilar();
        System.out.println("Después de subir: " + directorios.Tope());

        // =========================
        // 7) Cajero (Cola)
        // =========================
        System.out.println("\nEjercicio 7:");

        ColaTDA cajero = new Cola();
        cajero.InicializarCola();

        cajero.Acolar(1);
        cajero.Acolar(2);
        cajero.Acolar(3);

        System.out.println("Primero: " + cajero.Primero());

        cajero.Desacolar();

        System.out.println("Después: " + cajero.Primero());

        // =========================
        // 8) Impresora
        // =========================
        System.out.println("\nEjercicio 8:");

        ColaTDA impresora = new Cola();
        impresora.InicializarCola();

        impresora.Acolar(10);
        impresora.Acolar(20);
        impresora.Acolar(30);

        while (!impresora.ColaVacia()) {
            System.out.println("Imprimiendo: " + impresora.Primero());
            impresora.Desacolar();
        }

        // =========================
        // 9) Hospital (Prioridad)
        // =========================
        System.out.println("\nEjercicio 9:");

        ColaPrioridadTDA hospital = new ColaPrioridad();
        hospital.InicializarCola();

        hospital.AcolarPrioridad(1, 1);
        hospital.AcolarPrioridad(2, 100);
        hospital.AcolarPrioridad(3, 50);

        System.out.println("Paciente atendido: " + hospital.Primero());

        // =========================
        // 10) Examen
        // =========================
        System.out.println("\nEjercicio 10:");

        ColaPrioridadTDA examen = new ColaPrioridad();
        examen.InicializarCola();

        examen.AcolarPrioridad(1, 5);
        examen.AcolarPrioridad(2, 10);

        System.out.println("Pasa primero: " + examen.Primero());

        // =========================
        // 11) Buffet
        // =========================
        System.out.println("\nEjercicio 11:");

        ColaTDA buffet = new Cola();
        buffet.InicializarCola();

        buffet.Acolar(1);
        buffet.Acolar(2);

        System.out.println("Se atiende: " + buffet.Primero());

        // =========================
        // 12) CPU
        // =========================
        System.out.println("\nEjercicio 12:");

        ColaPrioridadTDA cpu = new ColaPrioridad();
        cpu.InicializarCola();

        cpu.AcolarPrioridad(1, 10);
        cpu.AcolarPrioridad(2, 50);

        System.out.println("Proceso ejecutado: " + cpu.Primero());

        // =========================
        // 13) Aerolínea
        // =========================
        System.out.println("\nEjercicio 13:");

        ColaPrioridadTDA vuelo = new ColaPrioridad();
        vuelo.InicializarCola();

        vuelo.AcolarPrioridad(1, 1);
        vuelo.AcolarPrioridad(2, 3);
        vuelo.AcolarPrioridad(3, 2);

        System.out.println("Sube primero: " + vuelo.Primero());

        // =========================
        // 14) Soporte IT
        // =========================
        System.out.println("\nEjercicio 14:");

        ColaPrioridadTDA soporte = new ColaPrioridad();
        soporte.InicializarCola();

        soporte.AcolarPrioridad(1, 0);
        soporte.AcolarPrioridad(2, 999);

        System.out.println("Ticket prioritario: " + soporte.Primero());
    }

    public static boolean EstaBalanceado(String linea) {
        PilaTDA pila = new Pila();
        pila.InicializarPila();

        for (char c : linea.toCharArray()) {
            if (c == '(') {
                pila.Apilar(1);
            } else if (c == ')') {
                if (pila.PilaVacia()) return false;
                pila.Desapilar();
            }
        }
        return pila.PilaVacia();
    }
}