/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author Franco Carreras
 */
public class NodoLista {
    private int id;
    private String nombre;
    private int tamaño;
    private FileType tipo;
    private NodoLista siguiente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public FileType getTipo() {
        return tipo;
    }

    public void setTipo(FileType tipo) {
        this.tipo = tipo;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }

    public NodoLista(int id, String nombre, int tamaño, FileType tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.tipo = tipo;
    }

    
}
