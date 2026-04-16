package Interfaces;

public interface DiccionarioSimpleTDA {
    void Agregar(String clave, String valor);

    void Eliminar(String clave);

    String Recuperar(String clave);

    String[] Claves();
}
