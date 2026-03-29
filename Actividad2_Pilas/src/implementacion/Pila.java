package implementacion;


import Interfaces.PilaTDA;


public class Pila implements PilaTDA {


    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;


    public Pila() {
    }


    @Override
    public void InicializarPila() {
        datos = new int[MAX];
        cantidad = 0;
    }


    @Override
    public void Apilar(int x) {
        if (cantidad < MAX) {
            datos[cantidad] = x;
            cantidad++;
        }
    }


    @Override
    public void Desapilar() {
        if (!PilaVacia()) {
            cantidad--;
        }
    }


    @Override
    public int Tope() {
        return datos[cantidad - 1];
    }


    @Override
    public boolean PilaVacia() {
        return cantidad == 0;
    }
}
