package Interfaces;

public interface ColaPrioridadTDA {

    void InicializarColaPrioridad();

    void AcolarPrioridad(int x, int prioridad);

    void Desacolar();

    boolean ColaVacia();

    int Primero();

    int Prioridad();
}