package Interfaces;

public interface DiccionarioMultipleTDA {
    void Agregar(String clave, String valor);
    void EliminarValor(String clave, String valor);
    String[] Recuperar(String clave);
    String[] Claves();
}
