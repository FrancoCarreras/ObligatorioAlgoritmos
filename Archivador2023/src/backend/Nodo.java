/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author Franco Carreras
 */
public class Nodo implements NodoI {
    private NodoI hijo;
    private NodoI hermano;
    private File data;

    public Nodo(File data) {
        this.data = data;
        this.hermano = null;
        this.hijo = null;
    }

    @Override
    public NodoI getHijo() {
        return this.hijo;
    }

    @Override
    public NodoI getHermano() {
        return this.hermano;
    }

    @Override
    public File getData() {
        return this.data;
    }

    @Override
    public void setHijo(NodoI hijo) {
        this.hijo = hijo;
    }

    @Override
    public void setHermano(NodoI hermano) {
        this.hermano = hermano;
    }

    @Override
    public void setData(File data) {
        this.data = data;
    }
}
