package implementacion_dinamica;

import Interfaces.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {

    private NodeClave cabeza;

    @Override
    public void InicializarDiccionario() {
        cabeza = null;
    }

    @Override
    public void Agregar(String clave, String valor) {
        NodeClave curr = cabeza;
        while (curr != null && !curr.getClave().equals(clave)) {
            curr = curr.getNext();
        }
        if (curr != null) {
            curr.getPrimero().setValor(valor);
        } else {
            cabeza = new NodeClave(clave, new NodeValor(valor, null), cabeza);
        }
    }

    @Override
    public void Eliminar(String clave) {
        NodeClave curr = cabeza;
        NodeClave prev = null;
        while (curr != null && !curr.getClave().equals(clave)) {
            prev = curr;
            curr = curr.getNext();
        }
        if (curr != null) {
            if (prev == null) {
                cabeza = curr.getNext();
            } else {
                prev.setNext(curr.getNext());
            }
        }
    }

    @Override
    public String Recuperar(String clave) {
        NodeClave curr = cabeza;
        while (curr != null && !curr.getClave().equals(clave)) {
            curr = curr.getNext();
        }
        if (curr == null) return null;
        return curr.getPrimero().getValor();
    }

    @Override
    public String[] Claves() {
        int count = 0;
        NodeClave curr = cabeza;
        while (curr != null) {
            count++;
            curr = curr.getNext();
        }
        String[] result = new String[count];
        curr = cabeza;
        for (int i = 0; i < count; i++) {
            result[i] = curr.getClave();
            curr = curr.getNext();
        }
        return result;
    }
}
