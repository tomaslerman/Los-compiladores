import Interfaces.PilaTDA;
import implementacion.*;
import Interfaces.ColaTDA;
import Interfaces.ColaPrioridadTDA;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {
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
                    System.out.println("Chau!");
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
        hospital.InicializarColaPrioridad();

        hospital.AcolarPrioridad(1, 1); //nene
        hospital.AcolarPrioridad(2, 100); //jubilado
        String[] resultado4 = {"nene", "jubilado"};

        System.out.println("Paciente atendido: " + resultado4[hospital.Primero()-1]);

        // =========================
        // 10) Examen
        // =========================
        System.out.println("\nEjercicio 10:");

        ColaPrioridadTDA examen = new ColaPrioridad();
        examen.InicializarColaPrioridad();

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
        cpu.InicializarColaPrioridad();

        cpu.AcolarPrioridad(1, 10); //Spotify
        cpu.AcolarPrioridad(2, 50); //Proceso del sistema

        String[] resultado7 = {"Spotify", "Proceso del sistema"};
        System.out.println("Proceso ejecutado: " + resultado7[cpu.Primero()-1]);

        // =========================
        // 13) Aerolínea
        // =========================
        System.out.println("\nEjercicio 13:");

        ColaPrioridadTDA vuelo = new ColaPrioridad();
        vuelo.InicializarColaPrioridad();

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
        soporte.InicializarColaPrioridad();

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

        for (int votante : votantes) {
            if (!Padron.Pertenece(votante)) {
                Padron.Agregar(votante);
                System.out.print("\nVotó el votante " + votante);
            } else {
                System.out.print("\nNo se permitió que el votante " + votante + " Vote otra vez");
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
        System.out.println("\nEjercicio 3:");

        // IDs: 1="Crypto", 2="Ganá", 3="Premio", 4="Hola", 5="amigo", 6="ganaste"
        String[] palabrasClave = {"Crypto", "Ganá", "Premio", "Hola", "amigo", "ganaste"};

        Conjunto blacklist = new Conjunto();
        blacklist.InicializarConjunto();
        blacklist.Agregar(0); // "Crypto"
        blacklist.Agregar(1); // "Ganá"
        blacklist.Agregar(2); // "Premio"

        // Mail entrante: "Hola amigo ganaste un Premio"
        int[] mailEntrante = {3, 4, 5, 2};
        System.out.print("Mail entrante: ");
        for (int id : mailEntrante) System.out.print(palabrasClave[id] + " ");
        System.out.println();

        boolean esSpam = false;
        for (int id : mailEntrante) {
            if (blacklist.Pertenece(id)) {
                System.out.println("Palabra prohibida detectada: \"" + palabrasClave[id] + "\"");
                esSpam = true;
            }
        }
        System.out.println("¿Es spam? " + (esSpam ? "Sí" : "No"));

        // =========================
        // 4) Tags de Blog
        // =========================
        System.out.println("\nEjercicio 4:");

        Conjunto tagsPost = new Conjunto();
        tagsPost.InicializarConjunto();
        tagsPost.Agregar(0); // #Programacion
        tagsPost.Agregar(1); // #Java
        tagsPost.Agregar(2); // #OOP
        tagsPost.Agregar(1); // se intenta duplicar #Java

        System.out.println("Se intentaron agregar 4 tags (con #Java duplicado)");
        System.out.println("Tags únicos almacenados: " + tagsPost.Tamanio());
        System.out.println("¿Contiene #Java? " + tagsPost.Pertenece(1));
        System.out.println("Se usan conjuntos porque garantizan la unicidad de los elementos.");
        System.out.println("Una pila permitiría apilar #Java dos veces sin control.");

        // =========================
        // 5) Gestión de Legajos
        // =========================
        System.out.println("\nEjercicio 5:");

        Conjunto legajos = new Conjunto();
        legajos.InicializarConjunto();

        int legajo = 12345;
        legajos.Agregar(legajo);
        System.out.println("Alumno " + legajo + " inscripto en Informática. Legajos en BD: " + legajos.Tamanio());

        legajos.Agregar(legajo); // se intenta inscribirse en Sistemas con el mismo ID
        System.out.println("Alumno " + legajo + " intenta inscribirse en Sistemas. Legajos en BD: " + legajos.Tamanio());
        System.out.println("El alumno se inscribe en Sistemas con el legajo " + legajo + " porque ya existía, y se ignora el duplicado.");

        // =========================
        // 6) Elegir vs Sacar
        // =========================
        System.out.println("\nEjercicio 6:");

        Conjunto conjEjemplo = new Conjunto();
        conjEjemplo.InicializarConjunto();
        conjEjemplo.Agregar(10);
        conjEjemplo.Agregar(20);
        conjEjemplo.Agregar(30);

        int primera = conjEjemplo.Elegir();
        int segunda = conjEjemplo.Elegir();

        System.out.println("Primera llamada a Elegir(): " + primera);
        System.out.println("Segunda llamada a Elegir() sin Sacar(): " + segunda);
        System.out.println("¿Son iguales? " + (primera == segunda));
        System.out.println("Elegir() devuelve un elemento arbitrario, NO aleatorio.");
        System.out.println("En nuestra implementación, Elegir() siempre devuelve el mismo elemento (el primero en el array) si no se llama a Sacar().");

        // =========================
        // 7) Agenda de contactos
        // =========================
        System.out.println("\nEjercicio 7:");

        DiccionarioSimple agenda = new DiccionarioSimple();
        agenda.InicializarDiccionario();

        String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis", "Laura", "Carlos", "Sofía", "Diego", "Elena"};
        int[] telefonos = {123456789, 987654321, 555555555, 111111111, 222222222, 333333333, 444444444, 666666666, 777777777, 888888888};

        for (int i = 0; i < nombres.length; i++) {
            agenda.Agregar(nombres[i], Integer.toString(telefonos[i]));
        }

        System.out.println("\nAgenda de contactos:");
        for (String nombre : nombres) {
            System.out.println(nombre + ": " + agenda.Recuperar(nombre));
        }

        // =========================
        // 8) Diccionario de sinonimos
        // =========================
        System.out.println("\nEjercicio 8:");

        String[] palabras = {"romper", "arreglar", "caminar", "hablar"};
        String[][] sinonimos = {
                {"descomponer", "quebrar", "partir"},
                {"reparar", "solucionar", "corregir"},
                {"andar", "desplazarse", "marchar"},
                {"charlar", "conversar", "decir"},
        };

        DiccionarioMultiple dicSinonimos = new DiccionarioMultiple();
        dicSinonimos.InicializarDiccionario();
        for (int i = 0; i < palabras.length; i++) {
            for (String sinonimo : sinonimos[i]) {
                dicSinonimos.Agregar(palabras[i], sinonimo);
            }
        }

        System.out.println("Sinonimos:");
        for (String palabra : palabras) {
            System.out.println(palabra + ": " + java.util.Arrays.toString(dicSinonimos.Recuperar(palabra)));
        }

        // =========================
        // 9) Puntaje de torneo de E-Sports
        // =========================
        System.out.println("\nEjercicio 9:");

        System.out.println("Modelado: Clave = [Nombre de usuario], Valor = [Puntaje máximo]");

        DiccionarioSimple torneo = new DiccionarioSimple();
        torneo.InicializarDiccionario();
        torneo.Agregar("NinjaX", "9500");
        torneo.Agregar("ShadowByte", "8200");
        torneo.Agregar("PixelKiller", "11000");

        System.out.println("Puntaje de NinjaX: " + torneo.Recuperar("NinjaX"));
        System.out.println("Puntaje de PixelKiller: " + torneo.Recuperar("PixelKiller"));

        // =========================
        // 10) Traductor de Idiomas
        // "Bank" → "Banco" o "Orilla" (múltiples valores por clave)
        // TDA: DiccionarioMultiple — una palabra puede tener varias traducciones
        // =========================
        System.out.println("\nEjercicio 10:");

        System.out.println("TDA Usado: DiccionarioMultiple");
        System.out.println("'Bank' tiene varias traducciones (Banco, Orilla).");
        System.out.println("DiccionarioSimple solo guardaría una.");
        System.out.println("Asi que se eligió DiccionarioMultiple para guardar las traducciones.");

        DiccionarioMultiple traductor = new DiccionarioMultiple();
        traductor.InicializarDiccionario();
        traductor.Agregar("Bank", "Banco");
        traductor.Agregar("Bank", "Orilla");

        System.out.println("Traducciones de 'Bank': " + java.util.Arrays.toString(traductor.Recuperar("Bank")));

        // =========================
        // 11) Índice de Libro de Algoritmos
        // =========================
        System.out.println("\nEjercicio 11 - Índice de Libro:");

        DiccionarioMultiple indice = new DiccionarioMultiple();
        indice.InicializarDiccionario();
        indice.Agregar("Recursión", "12");
        indice.Agregar("Recursión", "45");
        indice.Agregar("Recursión", "88");

        System.out.println("'Recursión' aparece en páginas: " + java.util.Arrays.toString(indice.Recuperar("Recursión")));

        // =========================
        // 12) Inscripción por Alumno
        // =========================
        System.out.println("\nEjercicio 12 - Inscripción por Alumno:");

        DiccionarioMultiple inscripciones = new DiccionarioMultiple();
        inscripciones.InicializarDiccionario();
        inscripciones.Agregar("12345", "Algoritmos");
        inscripciones.Agregar("12345", "Matemática");
        inscripciones.Agregar("12345", "Física");

        System.out.println("Materias del legajo 12345: " + java.util.Arrays.toString(inscripciones.Recuperar("12345")));

        // =========================
        // 13) DNS (Domain Name System)
        // =========================
        System.out.println("\nEjercicio 13 - DNS:");

        DiccionarioSimple dns = new DiccionarioSimple(); //Se usan diccionarios simples para asociar dominios a IPs únicas
        dns.InicializarDiccionario();
        dns.Agregar("google.com", "142.250.190.46");
        dns.Agregar("github.com", "140.82.114.4");

        System.out.println("google.com → " + dns.Recuperar("google.com"));
        System.out.println("github.com → " + dns.Recuperar("github.com"));

        // =========================
        // 14) Chipotle Support Bot (Pepper)
        // =========================
        System.out.println("\nEjercicio 14 - Chipotle Support Bot (Pepper):");

        DiccionarioSimple pepper = new DiccionarioSimple(); //Se usan diccionarios simples para asociar Orden IDs a scripts Python unicos
        pepper.InicializarDiccionario();
        pepper.Agregar("ORD-001", "taco.py");
        pepper.Agregar("ORD-002", "burrito.py");
        pepper.Agregar("ORD-003", "aguacate.py");

        System.out.println("Script para ORD-001: " + pepper.Recuperar("ORD-001"));
        System.out.println("Script para ORD-002: " + pepper.Recuperar("ORD-002"));
        System.out.println("Script para ORD-003: " + pepper.Recuperar("ORD-003"));
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