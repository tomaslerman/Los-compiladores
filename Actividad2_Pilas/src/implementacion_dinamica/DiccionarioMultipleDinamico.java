package implementacion_dinamica;

import Interfaces.DiccionarioMultipleTDA;

public class DiccionarioMultipleDinamico implements DiccionarioMultipleTDA {

    private NodeClave cabeza;

    @Override
    public void InicializarDiccionario() {
        cabeza = null;
    }

    @Override
    public void Agregar(String clave, String valor) {
        NodeClave nodoClave = buscarClave(clave);
        if (nodoClave == null) {
            cabeza = new NodeClave(clave, new NodeValor(valor, null), cabeza);
        } else {
            if (!existeValor(nodoClave, valor)) {
                nodoClave.setPrimero(new NodeValor(valor, nodoClave.getPrimero()));
            }
        }
    }

    @Override
    public void EliminarValor(String clave, String valor) {
        NodeClave nodoClave = buscarClave(clave);
        if (nodoClave == null) return;

        NodeValor curr = nodoClave.getPrimero();
        NodeValor prev = null;
        while (curr != null && !curr.getValor().equals(valor)) {
            prev = curr;
            curr = curr.getNext();
        }
        if (curr != null) {
            if (prev == null) {
                nodoClave.setPrimero(curr.getNext());
            } else {
                prev.setNext(curr.getNext());
            }
            if (nodoClave.getPrimero() == null) {
                eliminarClave(clave);
            }
        }
    }

    @Override
    public String[] Recuperar(String clave) {
        NodeClave nodoClave = buscarClave(clave);
        if (nodoClave == null) return new String[0];

        int count = 0;
        NodeValor curr = nodoClave.getPrimero();
        while (curr != null) {
            count++;
            curr = curr.getNext();
        }
        String[] result = new String[count];
        curr = nodoClave.getPrimero();
        for (int i = 0; i < count; i++) {
            result[i] = curr.getValor();
            curr = curr.getNext();
        }
        return result;
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

    private void eliminarClave(String clave) {
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

    private NodeClave buscarClave(String clave) {
        NodeClave curr = cabeza;
        while (curr != null && !curr.getClave().equals(clave)) {
            curr = curr.getNext();
        }
        return curr;
    }

    private boolean existeValor(NodeClave nodoClave, String valor) {
        NodeValor curr = nodoClave.getPrimero();
        while (curr != null) {
            if (curr.getValor().equals(valor)) return true;
            curr = curr.getNext();
        }
        return false;
    }
}
