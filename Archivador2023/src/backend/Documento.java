/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author ezeco
 */
public class Documento extends File {

    public Documento() {
        this.type = FileType.DOCUMENTO;
        contador++;
        this.id = contador;
    }

    public Documento(String nombre, String extension, int size) {
        this.nombre = nombre;
        this.size = size;
        this.extension = extension;
        this.type = FileType.DOCUMENTO;
        contador++;
        this.id = contador;
    }

    @Override
    public String toString() {
        return this.nombre + "." + this.extension;
    }

}
