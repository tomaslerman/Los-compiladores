package Interfaces;

public interface DiccionarioMultipleTDA {
    void Agregar(int clave, int valor);
    void EliminarValor(int clave, int valor);
    ConjuntoTDA Recuperar(int clave);
    ConjuntoTDA Claves();
}
