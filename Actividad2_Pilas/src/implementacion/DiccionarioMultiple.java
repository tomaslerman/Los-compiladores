package implementacion;

import Interfaces.ConjuntoTDA;
import Interfaces.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

    private static final int MAX = 100;
    private int[] claves;
    private Conjunto[] valores; //Los valores se guardan en una lista de conjuntos
    private int cantidad;

    public DiccionarioMultiple() {
        claves = new int[MAX];
        valores = new Conjunto[MAX];
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
        if (i != -1) {
            valores[i].Agregar(valor);
        } else if (cantidad < MAX) {
            claves[cantidad] = clave;
            valores[cantidad] = new Conjunto();
            valores[cantidad].Agregar(valor);
            cantidad++;
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) {
        int i = buscarIndice(clave);
        if (i != -1) {
            valores[i].Sacar(valor);
            if (valores[i].ConjuntoVacio()) { //Si ya no hay valores con esta clave, se elimina la clave tambien
                claves[i] = claves[cantidad - 1];
                valores[i] = valores[cantidad - 1];
                cantidad--;
            }
        }
    }

    @Override
    public ConjuntoTDA Recuperar(int clave) {
        int i = buscarIndice(clave);
        if (i == -1) return null; //Si no existe la clave, retorna null
        return valores[i];
    }

    @Override
    public ConjuntoTDA Claves() {
        Conjunto c = new Conjunto();
        for (int i = 0; i < cantidad; i++) {
            c.Agregar(claves[i]);
        }
        return c;
    }
}
