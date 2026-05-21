package Interfaces;

public interface ArbolTDA {
    int raiz();
    ArbolTDA hijoIzq();
    ArbolTDA hijoDer();

    void agregarElem(int x);
    void eliminar(int x);

    boolean arbolVacio();
}
