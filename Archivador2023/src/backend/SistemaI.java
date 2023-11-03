/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package backend;

/**
 *
 * @author ezeco
 */
public interface SistemaI {
   //Retorna arbol del directorio
    public SistemReturn getDirectorio();
    //Agrega un nuevo archivo o carpeta al directorio
    public SistemReturn add(int parentId,String nombre,FileType type,int size,String extension);
    //Edita un archivo o carpeta
    public SistemReturn update(int fileId,String nombre,int size,String extension);
    //Elimina el elemento del directorio
    public SistemReturn delete(int fileId);
    //Busca los elementos del directorio que contengan el nombre dado
    public SistemReturn search(String nombre);
    //Retorna el elemento de la id dada
    public SistemReturn getById(int fileId);
    //copia el elemento de id fileId en el nodo que contiene parentId
    public SistemReturn copy(int fileId,int parentId);
    //copia el elemento en el nuevo nodo padre y lo borra del viejo 
    public SistemReturn cut(int fieldId,int parentId);
    //retorna tamaño total del sistema
    public SistemReturn getTotalSize();
    //retorna tamaño disponible del sistema
    public SistemReturn sizeAvailable();
    //retorna tamaño ocupado del sistema
    public SistemReturn sizeOcuped();
    //retorna tamaño de la carpeta o documento seleccionado
    public SistemReturn sizeOcuped(int fileId);
    //retorna la cantidad de documentos y subcarpetas de una carpeta 
    public SistemReturn totalFiles(int fileId);
    //retorna las subcarpetas y documentos de un directorio
    public SistemReturn getFiles(int fileId);
   
}
