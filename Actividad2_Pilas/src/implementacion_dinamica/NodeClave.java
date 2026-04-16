package implementacion_dinamica;

public class NodeClave {

    private String clave;
    private NodeValor primero; // cabeza de la lista de valores para esta clave
    private NodeClave next;

    public NodeClave(String clave, NodeValor primero, NodeClave next) {
        this.clave = clave;
        this.primero = primero;
        this.next = next;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public NodeValor getPrimero() {
        return primero;
    }

    public void setPrimero(NodeValor primero) {
        this.primero = primero;
    }

    public NodeClave getNext() {
        return next;
    }

    public void setNext(NodeClave next) {
        this.next = next;
    }
}
