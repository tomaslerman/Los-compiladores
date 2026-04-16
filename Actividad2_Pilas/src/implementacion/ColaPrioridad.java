package implementacion;

import Interfaces.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

    int[] valores;
    int[] prioridades;
    int cantidad;

    public static final int MAX = 100;

    public void InicializarColaPrioridad() {
        valores = new int[MAX];
        prioridades = new int[MAX];
        cantidad = 0;
    }

    //Acolar un elemento con una prioridad específica
    public void AcolarPrioridad(int x, int p) {
        valores[cantidad] = x;
        prioridades[cantidad] = p;
        cantidad++;
    }

    //Devolver el elemento con mayor prioridad
    public int Primero() {
        int mejorPos = 0; //Indice del elemento con mayor prioridad

        //Buscar el elemento con mayor prioridad
        for (int i = 1; i < cantidad; i++) {
            if (prioridades[i] > prioridades[mejorPos]) {
                mejorPos = i;
            }
        }

        return valores[mejorPos];
    }

    //Devolver la *prioridad* del elemento con mayor prioridad
    public int Prioridad() {
        int mejorPos = 0;

        for (int i = 1; i < cantidad; i++) {
            if (prioridades[i] > prioridades[mejorPos]) {
                mejorPos = i;
            }
        }

        return prioridades[mejorPos];
    }

    public boolean ColaVacia() {
        return cantidad == 0;
    }

    //Desacolar el elemento con mayor prioridad
    public void Desacolar() {
        int mejorPos = 0;

        for (int i = 1; i < cantidad; i++) {
            if (prioridades[i] > prioridades[mejorPos]) {
                mejorPos = i;
            }
        }

        // Corrimiento de elementos hacia la izquierda
        for (int i = mejorPos; i < cantidad - 1; i++) {
            valores[i] = valores[i + 1];
            prioridades[i] = prioridades[i + 1];
        }
        cantidad--;
    }

}

