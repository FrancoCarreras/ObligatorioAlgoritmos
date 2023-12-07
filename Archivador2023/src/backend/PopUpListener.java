/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author Franco Carreras
 */
public interface PopUpListener {
    void onObjectCreated(String nombre, FileType type, int size, String extension);
    void onObjectEdited(String nombre, FileType type, int size, String extension, int fileId);
}
