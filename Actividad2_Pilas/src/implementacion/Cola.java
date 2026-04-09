package implementacion;

import Interfaces.ColaTDA;

public class Cola implements ColaTDA {

    int[] arr;
    int primero;
    int ultimo;

    public static final int MAX = 100;

    public void InicializarCola() {
        arr = new int[MAX];
        primero = 0;
        ultimo = 0;
    }

    public void Acolar(int x) {
        arr[ultimo] = x;
        ultimo = (ultimo + 1) % MAX;
    }

    public void Desacolar() {
        primero = (primero + 1) % MAX;
    }

    public int Primero() {
        return arr[primero];
    }

    public boolean ColaVacia() {
        return (primero == ultimo);
    }
}