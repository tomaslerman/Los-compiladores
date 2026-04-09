package implementacion;

import Interfaces.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {

    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;

    public Conjunto() {
    }

    @Override
    public void InicializarConjunto() {
        datos = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void Agregar(int x) {
        if (!Pertenece(x) && cantidad < MAX) {
            datos[cantidad] = x;
            cantidad++;
        }
    }

    @Override
    public void Eliminar(int x) {
        int i = 0;
        while (i < cantidad && datos[i] != x) {
            i++;
        }
        if (i < cantidad) {
            datos[i] = datos[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public int Tamanio() {
        return cantidad;
    }

    @Override
    public boolean Pertenece(int x) {
        int i = 0;
        while (i < cantidad && datos[i] != x) {
            i++;
        }
        return i < cantidad;
    }

    @Override
    public boolean ConjuntoVacio() {
        return cantidad == 0;
    }
}
