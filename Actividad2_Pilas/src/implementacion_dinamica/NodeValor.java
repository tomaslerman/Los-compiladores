package implementacion_dinamica;

public class NodeValor {

    private String valor;
    private NodeValor next;

    public NodeValor(String valor, NodeValor next) {
        this.valor = valor;
        this.next = next;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NodeValor getNext() {
        return next;
    }

    public void setNext(NodeValor next) {
        this.next = next;
    }
}
