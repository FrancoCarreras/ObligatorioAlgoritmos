/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author ezeco
 */
public class SistemReturn {
    public TypeError type;
    public String message;
    public Object result;

    public SistemReturn(TypeError type) {
        this.type = type;
    }

    public SistemReturn(TypeError type, String message) {
        this.type = type;
        this.message = message;
    }

    public SistemReturn(TypeError type, String message, Object result) {
        this.type = type;
        this.message = message;
        this.result = result;
    }

}
