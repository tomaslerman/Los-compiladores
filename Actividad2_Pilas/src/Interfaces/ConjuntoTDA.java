package Interfaces;

public interface ConjuntoTDA {
    void Agregar(int x);
    void Sacar(int x);
    boolean Pertenece(int x);
    boolean ConjuntoVacio();
    int Elegir();
    int Tamanio();
}
