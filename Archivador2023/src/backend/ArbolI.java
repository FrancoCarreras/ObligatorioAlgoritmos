/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package backend;

/**
 *
 * @author ezeco
 */
public interface ArbolI {
     //Obtiene el nodo raiz
    public NodoI getRaiz();
    //Setea el nodo Raiz
    public void setRaiz(NodoI raiz);
    //Retorna true si es vacio
    public boolean esVacio();
    //Obtiene dato de la raiz
    public File raiz();
    //Retorna el arbol hijo
    public ArbolI hijo();
    //Retorna el arbol hermano
    public ArbolI hermano();
    //Inserta el documento o carpeta
    public void insertar(NodoI padre ,File hijo);
    //Borra el documento o carpeta
    public void borrar(int fieldId);
    //Retorna la ruta del documento desde la raiz
    public String getRuta(int idFile);
    //Retorna la cantidad de nodos menos el de la raiz
    public int peso();
    //Retorna el nodo que contiene el documento o carpeta
    public NodoI buscarPorId(int fileId);
    //Retorna una matriz con los datos de los hijos del nodo dado
    public Object[][] hijosDelNodo(int fieldId);
    //Busca una lista de nodos por nombre
    public Lista buscarPorNombre(Lista lista, String text);
    public Lista listaDeNodos(NodoI nodo);
    public void dfsAgregarALista(NodoI nodo, Lista lista);
    public int cantidadDeElementos(int fileId);
    public int tamañoHijos(NodoI hijo);
    public boolean existeNodoConNombre(NodoI nodo, String nombreBuscado, FileType tipo);
    public NodoI buscarPadre(int fieldId, NodoI nodo);
    public NodoI copiarNodo(NodoI nodo, NodoI nodoPadreDestino);
}