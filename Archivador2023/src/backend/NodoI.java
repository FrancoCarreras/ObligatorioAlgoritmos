/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package backend;

/**
 *
 * @author ezeco
 */
public interface NodoI {
    //Devuelve el nodo primer hijo del nodo
    public NodoI getHijo();
    //Devuelve el nodo siguiente hermano del nodo
    public NodoI getHermano();
    //Devuelve un objecto que contiene la info del nodo
    public File getData();
    //Setea el nodo dado como hijo del nodo
    public void setHijo(NodoI hijo);
    //Setea el nodo dado como hermano del nodo
    public void setHermano(NodoI hermano);
    //Setea el objecto FileData en los datos del nodo
    public void setData(File data);
    
}
