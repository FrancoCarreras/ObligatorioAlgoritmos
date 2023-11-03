/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author ezeco
 */
public class Carpeta extends File {

    public Carpeta() {
        this.type = FileType.CARPETA;
        contador++;
        this.id=contador;
    }
    
    public Carpeta(String nombre,int size) {
        this.nombre = nombre;
        this.size = size;
        this.type = FileType.CARPETA;
        contador++;
        this.id=contador;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
