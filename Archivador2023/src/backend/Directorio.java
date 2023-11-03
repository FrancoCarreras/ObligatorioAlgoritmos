/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author Franco Carreras
 */
public class Directorio implements ArbolI {
    private NodoI raiz;
    
    public Directorio() {
    }

    @Override
    public NodoI getRaiz() {
        return this.raiz;
    }

    @Override
    public void setRaiz(NodoI raiz) {
        this.raiz = raiz;
    }

    @Override
    public boolean esVacio() {
        return this.raiz == null;
    }

    @Override
    public File raiz() {
        return this.raiz.getData();
    }

    @Override
    public ArbolI hijo() {
        Directorio hijo = new Directorio();
        hijo.raiz = this.raiz.getHijo();
        
        return hijo;
    }

    @Override
    public ArbolI hermano() {
        Directorio hermano = new Directorio();
        hermano.raiz = this.raiz.getHermano();
        
        return hermano;
    }

    @Override
    public void insertar(NodoI padre, File hijo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrar(int fieldId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getRuta(int idFile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int peso() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NodoI buscarPorId(int fileId) {
        if (!this.esVacio()) {
            if (this.raiz.getData().getId() == fileId) {
                return this.raiz;
            } else {
                NodoI resultadoHijo = this.hijo().buscarPorId(fileId);
                
                if (resultadoHijo != null) {
                    return resultadoHijo;
                }
                
                return this.hermano().buscarPorId(fileId);
            }
        }
        
        return null;
    }

    @Override
    public Object[][] hijosDelNodo(int fieldId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
