package implementacion_dinamica;

public class NodePrioridad {

    private int dato;
    private int prioridad;
    private NodePrioridad next;

    public NodePrioridad(int dato, int prioridad, NodePrioridad next) {
        this.dato = dato;
        this.prioridad = prioridad;
        this.next = next;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public NodePrioridad getNext() {
        return next;
    }

    public void setNext(NodePrioridad next) {
        this.next = next;
    }
}
