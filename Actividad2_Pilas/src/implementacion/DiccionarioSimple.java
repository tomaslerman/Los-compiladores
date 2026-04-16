package implementacion;

import Interfaces.ConjuntoTDA;
import Interfaces.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

    private static final int MAX = 100;
    private int[] claves;
    private int[] valores;
    private int cantidad;

    public DiccionarioSimple() {
        claves = new int[MAX];
        valores = new int[MAX];
        cantidad = 0;
    }

    private int buscarIndice(int clave) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) return i;
        }
        return -1;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int i = buscarIndice(clave);
        if (i != -1) { //Si la clave ya existe, actualizar su valor
            valores[i] = valor;
        } else if (cantidad < MAX) { //Si no existe, agregar la clave y su valor
            claves[cantidad] = clave;
            valores[cantidad] = valor;
            cantidad++;
        }
    }

    @Override
    public void Eliminar(int clave) {
        int i = buscarIndice(clave);
        if (i != -1) {
            claves[i] = claves[cantidad - 1];
            valores[i] = valores[cantidad - 1]; //Se reemplaza el elemento seleccionado con el ultimo en la lista
            cantidad--; //El ultimo se elimina
        }
    }

    @Override
    public int Recuperar(int clave) {
        int i = buscarIndice(clave);
        return valores[i];
    }

    @Override
    public ConjuntoTDA Claves() { //Devuelve las claves en un conjunto
        Conjunto c = new Conjunto();
        for (int i = 0; i < cantidad; i++) {
            c.Agregar(claves[i]);
        }
        return c;
    }
}
