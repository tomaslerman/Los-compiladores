package implementacion;

import Interfaces.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

    int[] valores;
    int[] prioridades;
    int cantidad;

    public void InicializarCola() {
        valores = new int[100];
        prioridades = new int[100];
        cantidad = 0;
    }

    public void AcolarPrioridad(int x, int p) {
        valores[cantidad] = x;
        prioridades[cantidad] = p;
        cantidad++;
    }

    public int Primero() {
        int pos = 0;

        for (int i = 1; i < cantidad; i++) {
            if (prioridades[i] > prioridades[pos]) {
                pos = i;
            }
        }

        return valores[pos];
    }

    public int Prioridad() {
        int pos = 0;

        for (int i = 1; i < cantidad; i++) {
            if (prioridades[i] > prioridades[pos]) {
                pos = i;
            }
        }

        return prioridades[pos];
    }

    public void Desacolar() {
        int pos = 0;

        for (int i = 1; i < cantidad; i++) {
            if (prioridades[i] > prioridades[pos]) {
                pos = i;
            }
        }

        // Corrimiento de elementos
        for (int i = pos; i < cantidad - 1; i++) {
            valores[i] = valores[i + 1];
            prioridades[i] = prioridades[i + 1];
        }

        cantidad--;
    }

    public boolean ColaVacia() {
        return (cantidad == 0);
    }
}

