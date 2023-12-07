/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author Franco Carreras
 */
public class Lista {
    private NodoLista inicio;
    
    public Lista() {
        this.inicio = null;
    }
    
    public void insertarInicio(int id, String nombre, int tamaño, FileType tipo) {
        NodoLista nuevo = new NodoLista(id, nombre, tamaño, tipo);
        nuevo.setSiguiente(this.inicio);
        this.inicio = nuevo;
    }

    public boolean esVacia() {
        return this.inicio == null;
    }
    
    public int largo() {
        int cont = 0;
        NodoLista aux = this.inicio;
        while (aux != null) {
            cont++;
            aux = aux.getSiguiente();
        }
        return cont;
    }
    
    public NodoLista obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= largo()) {
            return null;
        }

        NodoLista aux = this.inicio;
        int i = 0;
        while (i < indice) {
            aux = aux.getSiguiente();
            i++;
        }

        return aux;
    }

    public NodoLista getInicio() {
        return inicio;
    }

    public void setInicio(NodoLista inicio) {
        this.inicio = inicio;
    }
    
    
}
