import Interfaces.PilaTDA;
import implementacion.Pila;
import Interfaces.ColaTDA;
import implementacion.Cola;
import Interfaces.ColaPrioridadTDA;
import implementacion.ColaPrioridad;
import Interfaces.ConjuntoTDA;
import implementacion.Conjunto;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\nBienvenido, seleccione la opción deseada:");
            System.out.println("1. Parte uno, Pilas y Colas");
            System.out.println("2. Parte dos, Conjuntos");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    parte1();
                    break;
                case 2:
                    parte2();
                    break;
                case 3:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }

        scanner.close();
    }

    public static void parte1() {

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
        System.out.println(ejemplo + ": " + (EstaBalanceado(ejemplo) ? "Balanceado" : "No balanceado"));

        String ejemplo2 = "((a+b+c)*d";
        System.out.println(ejemplo2 + ": " +(EstaBalanceado(ejemplo2) ? "Balanceado" : "No balanceado"));

        // =========================
        // 4) Reversión de String
        // =========================
        System.out.println("\nEjercicio 4:");

        String palabra = "ALGORITMOS";
        PilaTDA pilaString = new Pila();
        pilaString.InicializarPila();

        for (int i = 0; i < palabra.length(); i++) {
            pilaString.Apilar(palabra.charAt(i));
        }

        System.out.print("Invertida: ");
        while (!pilaString.PilaVacia()) {
            System.out.print((char)pilaString.Tope());
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

        String[] resultado = {"Main", "Calcular", "Suma"};
        System.out.println("Función en el tope: " + resultado[callStack.Tope()-1]);

        // =========================
        // 6) Directorios
        // =========================
        System.out.println("\nEjercicio 6:");

        PilaTDA directorios = new Pila();
        directorios.InicializarPila();

        directorios.Apilar(1);
        directorios.Apilar(2);
        directorios.Apilar(3);

        String[] resulta2 = {"/home", "/home/user", "/home/user/documents"};
        System.out.println("Actual: " + resulta2[directorios.Tope()-1]);
        directorios.Desapilar();
        System.out.println("Después de subir: " + resulta2[directorios.Tope()-1]);

        // =========================
        // 7) Cajero (Cola comun)
        // =========================
        System.out.println("\nEjercicio 7:");

        ColaTDA cajero = new Cola();
        cajero.InicializarCola();

        System.out.println("Entran Juanito, Pepito y Gonzalito, en ese orden");
        cajero.Acolar(1);
        cajero.Acolar(2);
        cajero.Acolar(3);

        String[] resultado3 = {"Juanito", "Pepito", "Gonzalito"};

        System.out.println("Primero: " + resultado3[cajero.Primero()-1]);

        cajero.Desacolar();

        System.out.println("Siguiente: " + resultado3[cajero.Primero()-1]);

        // =========================
        // 8) Impresora
        // =========================
        System.out.println("\nEjercicio 8:");

        ColaTDA impresora = new Cola();
        impresora.InicializarCola();

        //Se imprimen los documentos en orden de llegada (aunque hayan llegado "al mismo tiempo")
        impresora.Acolar(1);
        impresora.Acolar(2);
        impresora.Acolar(3);
        impresora.Acolar(4);
        impresora.Acolar(5);

        while (!impresora.ColaVacia()) {
            System.out.println("Imprimiendo documento: " + impresora.Primero());
            impresora.Desacolar();
        }

        // =========================
        // 9) Hospital (Prioridad)
        // =========================
        System.out.println("\nEjercicio 9:");

        ColaPrioridadTDA hospital = new ColaPrioridad();
        hospital.InicializarCola();

        hospital.AcolarPrioridad(1, 1); //nene
        hospital.AcolarPrioridad(2, 100); //jubilado
        String[] resultado4 = {"nene", "jubilado"};

        System.out.println("Paciente atendido: " + resultado4[hospital.Primero()-1]);

        // =========================
        // 10) Examen
        // =========================
        System.out.println("\nEjercicio 10:");

        ColaPrioridadTDA examen = new ColaPrioridad();
        examen.InicializarCola();

        examen.AcolarPrioridad(1, 5); //regular
        examen.AcolarPrioridad(2, 10); //promocionante
        String[] resultado5 = {"regular", "promocionante"};

        System.out.println("Pasa primero: " + resultado5[examen.Primero()-1]);

        // =========================
        // 11) Buffet
        // =========================
        System.out.println("\nEjercicio 11:");

        ColaTDA buffet = new Cola();
        buffet.InicializarCola();

        buffet.Acolar(1); //Estudiante 1
        buffet.Acolar(2); //Estudiante 2
        String[] resultado6 = {"Estudiante 1", "Estudiante 2"};
        System.out.println("Se atiende primero: " + resultado6[buffet.Primero()-1]);

        // =========================
        // 12) Procesador de tareas
        // =========================
        System.out.println("\nEjercicio 12:");

        ColaPrioridadTDA cpu = new ColaPrioridad();
        cpu.InicializarCola();

        cpu.AcolarPrioridad(1, 10); //Spotify
        cpu.AcolarPrioridad(2, 50); //Proceso del sistema

        String[] resultado7 = {"Spotify", "Proceso del sistema"};
        System.out.println("Proceso ejecutado: " + resultado7[cpu.Primero()-1]);

        // =========================
        // 13) Aerolínea
        // =========================
        System.out.println("\nEjercicio 13:");

        ColaPrioridadTDA vuelo = new ColaPrioridad();
        vuelo.InicializarCola();

        vuelo.AcolarPrioridad(1, 3); //Movilidad reducida
        vuelo.AcolarPrioridad(2, 1); //Normal
        vuelo.AcolarPrioridad(3, 2); //Business
        vuelo.AcolarPrioridad(4,3); //Movilidad reducida

        String[] resultado8 = {"Movilidad reducida", "Normal", "Business", "Movilidad reducida"};
        for (int i = 1; i <= 4; i++) {
            System.out.println("Sube el pasajero " + vuelo.Primero() + ": " + resultado8[vuelo.Primero()-1]);
            vuelo.Desacolar();
        }

        // =========================
        // 14) Soporte IT
        // =========================
        System.out.println("\nEjercicio 14:");

        ColaPrioridadTDA soporte = new ColaPrioridad();
        soporte.InicializarCola();

        soporte.AcolarPrioridad(1, 0);
        soporte.AcolarPrioridad(2, 999);

        System.out.println("Ticket prioritario: " + soporte.Primero() + ", con prioridad " + soporte.Prioridad());
    }

    public static void parte2() {
        // =========================
        // 1) Padron electoral
        // =========================
        System.out.println("Ejercicio 1:");

        Conjunto Padron = new Conjunto();
        Padron.InicializarConjunto();
        int[] votantes = {1,2,3,4,4,5,6};

        for (int i = 0; i < votantes.length; i++) {
            if (!Padron.Pertenece(votantes[i])) {
                Padron.Agregar(votantes[i]);
                System.out.print("\nVotó el votante " + votantes[i]);
            }
            else {
                System.out.print("\nNo se permitió que el votante " + votantes[i] + " Vote otra vez");
            }
        }

        System.out.println();

        // =========================
        // 2) Fiesta
        // =========================
        System.out.println("Ejercicio 2:");
        Conjunto Lista = new Conjunto();
        Lista.InicializarConjunto();
        int[] invitados = {1,2,2,3,4,5,6,7,8,9,9,10};
        for (int invitado : invitados) {
            Lista.Agregar(invitado);
        }
        System.out.println("Se intentó agregar " + invitados.length + " invitados");
        System.out.println("Cantidad de invitados en la lista: " + Lista.Tamanio());

        // =========================
        // 3) Filtro de Spam
        // =========================
        
    }

    public static boolean EstaBalanceado(String linea) {
        PilaTDA pila = new Pila();
        pila.InicializarPila();

        for (char c : linea.toCharArray()) {
            if (c == '(') {
                pila.Apilar(c);
            } else if (c == ')') {
                if (pila.PilaVacia()) return false;
                pila.Desapilar();
            }
        }
        return pila.PilaVacia();
    }
}