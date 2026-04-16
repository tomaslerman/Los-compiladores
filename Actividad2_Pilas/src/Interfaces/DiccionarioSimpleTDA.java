package Interfaces;

public interface DiccionarioSimpleTDA {
    void Agregar(int clave, int valor);
    void Eliminar(int clave);
    int Recuperar(int clave);
    ConjuntoTDA Claves();
}
