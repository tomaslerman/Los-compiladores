package implementacion;

import Interfaces.ArbolTDA;

public class Arbol implements ArbolTDA {

    class NodoABB {
        int info;
        Arbol hijoIzq;
        Arbol hijoDer;
    }

    NodoABB nodo;

    @Override
    public void agregarElem(int x) {
        if (nodo == null) {
            nodo = new NodoABB();
            nodo.info = x;
            nodo.hijoIzq = new Arbol();
            nodo.hijoDer = new Arbol();
        }
        else if (nodo.info > x) {
            nodo.hijoIzq.agregarElem(x);
        }
        else if (nodo.info < x) {
            nodo.hijoDer.agregarElem(x);
        }
    }

    @Override
    public int raiz() {
        return 0;
    }

    @Override
    public ArbolTDA hijoIzq() {
        return null;
    }

    @Override
    public ArbolTDA hijoDer() {
        return null;
    }

    @Override
    public void eliminar(int x) {

    }

    @Override
    public boolean arbolVacio() {
        return false;
    }
}