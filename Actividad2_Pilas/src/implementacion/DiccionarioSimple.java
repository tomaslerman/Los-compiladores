package implementacion;

import Interfaces.ConjuntoTDA;
import Interfaces.DiccionarioSimpleTDA;

import java.util.Objects;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

    private static final int MAX = 100;
    private String[] claves;
    private String[] valores;
    private int cantidad;

    public DiccionarioSimple() {
        claves = new String[MAX];
        valores = new String[MAX];
        cantidad = 0;
    }

    private int buscarIndice(String clave) {
        for (int i = 0; i < cantidad; i++) {
            if (Objects.equals(claves[i], clave)) return i;
        }
        return -1;
    }

    @Override
    public void Agregar(String clave, String valor) {
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
    public void Eliminar(String clave) {
        int i = buscarIndice(clave);
        if (i != -1) {
            claves[i] = claves[cantidad - 1];
            valores[i] = valores[cantidad - 1]; //Se reemplaza el elemento seleccionado con el ultimo en la lista
            cantidad--; //El ultimo se elimina
        }
    }

    @Override
    public String Recuperar(String clave) {
        int i = buscarIndice(clave);
        if (i == -1) return null;
        return valores[i];
    }

    @Override
    public String[] Claves() { //Devuelve el array de claves
        return claves;
    }
}
