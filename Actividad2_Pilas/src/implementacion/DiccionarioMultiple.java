package implementacion;

import Interfaces.DiccionarioMultipleTDA;
import java.util.Objects;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

    private static final int MAX_CLAVES = 100;
    private static final int MAX_VALORES = 100;
    private String[] claves;
    private String[][] valores;
    private int[] cantValores;
    private int cantidad;

    public DiccionarioMultiple() {
    }

    @Override
    public void InicializarDiccionario() {
        claves = new String[MAX_CLAVES];
        valores = new String[MAX_CLAVES][MAX_VALORES];
        cantValores = new int[MAX_CLAVES];
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
        if (i != -1) {
            // Verificar que el valor no esté duplicado
            for (int j = 0; j < cantValores[i]; j++) {
                if (Objects.equals(valores[i][j], valor)) return;
            }
            if (cantValores[i] < MAX_VALORES) {
                valores[i][cantValores[i]] = valor;
                cantValores[i]++;
            }
        } else if (cantidad < MAX_CLAVES) {
            claves[cantidad] = clave;
            valores[cantidad][0] = valor;
            cantValores[cantidad] = 1;
            cantidad++;
        }
    }

    @Override
    public void EliminarValor(String clave, String valor) {
        int i = buscarIndice(clave);
        if (i == -1) return;
        for (int j = 0; j < cantValores[i]; j++) {
            if (Objects.equals(valores[i][j], valor)) {
                valores[i][j] = valores[i][cantValores[i] - 1];
                cantValores[i]--;
                if (cantValores[i] == 0) {
                    claves[i] = claves[cantidad - 1];
                    valores[i] = valores[cantidad - 1];
                    cantValores[i] = cantValores[cantidad - 1];
                    cantidad--;
                }
                return;
            }
        }
    }

    @Override
    public String[] Recuperar(String clave) {
        int i = buscarIndice(clave);
        if (i == -1) return new String[0];
        String[] resultado = new String[cantValores[i]];
        for (int j = 0; j < cantValores[i]; j++) {
            resultado[j] = valores[i][j];
        }
        return resultado;
    }

    @Override
    public String[] Claves() {
        String[] resultado = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            resultado[i] = claves[i];
        }
        return resultado;
    }
}
