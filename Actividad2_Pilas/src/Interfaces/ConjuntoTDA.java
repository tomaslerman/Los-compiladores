package Interfaces;

public interface ConjuntoTDA {
    void InicializarConjunto();
    void Agregar(int x);
    void Eliminar(int x);
    int Tamanio();
    boolean Pertenece(int x);
    boolean ConjuntoVacio();
}
