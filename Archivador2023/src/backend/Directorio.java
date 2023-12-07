/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.awt.List;
import java.util.ArrayList;

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
        NodoI nuevoNodo = new Nodo(hijo);
        
        if (padre == null) {
            this.setRaiz(nuevoNodo);
        } else {
            NodoI actual = padre.getHijo();

            padre.setHijo(nuevoNodo);

            nuevoNodo.setHermano(actual);
        }
    }

    @Override
    public void borrar(int fieldId) {
        if (this.raiz == null) {
            return;
        }

        if (this.raiz.getData().getId() == fieldId) {
            return;
        }

        NodoI padre = buscarPadre(fieldId, this.raiz);

        if (padre == null) {
            throw new UnsupportedOperationException("Nodo padre no encontrado.");
        }

        NodoI actual = padre.getHijo();
        if (actual != null) {
            if (actual.getData().getId() == fieldId) {
                padre.setHijo(actual.getHermano());
            } else {
                while (actual.getHermano() != null) {
                    if (actual.getHermano().getData().getId() == fieldId) {
                        actual.setHermano(actual.getHermano().getHermano());
                        break;
                    }
                    actual = actual.getHermano();
                }
            }
        }
    }

    public NodoI buscarPadre(int fieldId, NodoI nodo) {
        if (nodo == null) {
            return null;
        }

        NodoI hijo = nodo.getHijo();
        
        while (hijo != null) {
            if (hijo.getData().getId() == fieldId) {
                return nodo;
            }
            NodoI resultado = buscarPadre(fieldId, hijo);
            if (resultado != null) {
                return resultado;
            }
            hijo = hijo.getHermano();
        }
        
        return null;
    }



    @Override
    public String getRuta(int idFile) {
        return buscarRuta(this.raiz, idFile, "");
    }

    private String buscarRuta(NodoI nodo, int idFile, String rutaActual) {
        if (nodo == null) {
            return null;
        }

        if (nodo.getData().getId() == idFile) {
            return rutaActual + nodo.getData().getNombre() + "/";
        }

        String rutaHijo = buscarRuta(nodo.getHijo(), idFile, rutaActual + nodo.getData().getNombre()+ "/");
        if (rutaHijo != null) {
            return rutaHijo;
        }

        return buscarRuta(nodo.getHermano(), idFile, rutaActual);
    }

    @Override
    public int peso() {
        if (this.raiz == null) {
            return 0;
        }
        
        return contarNodos(this.raiz.getHijo());
    }

    private int contarNodos(NodoI nodo) {
        if (nodo == null) {
            return 0;
        }
        
        return 1 + contarNodos(nodo.getHijo()) + contarNodos(nodo.getHermano());
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
    
    private int contarHijos(NodoI hijo) {
        int contador = 0;
        NodoI actual = hijo;

        while (actual != null) {
            contador++;
            actual = actual.getHermano();
        }

        return contador;
    }
    
    @Override
    public int tamañoHijos(NodoI hijo) {
        int contador = 0;
        NodoI actual = hijo;

        while (actual != null) {
            contador = contador + actual.getData().getSize();
            actual = actual.getHermano();
        }

        return contador;
    }

    @Override
    public Object[][] hijosDelNodo(int fieldId) {
        NodoI nodo = buscarPorId(fieldId);
        
        if (nodo == null) {
            Object[][] resultado = new Object[1][4];
            resultado[0][0] = "Nombre";
            resultado[0][1] = "Tipo";
            resultado[0][2] = "Tamaño";
            resultado[0][3] = "Ruta";
            
            return resultado;
        }
        
        int cantidadHijos = 0;
        
        if(nodo.getHijo() == null) {
            Object[][] resultado = new Object[1][4];
            resultado[0][0] = "Nombre";
            resultado[0][1] = "Tipo";
            resultado[0][2] = "Tamaño";
            resultado[0][3] = "Ruta";
            
            return resultado;
        }
        else {
            cantidadHijos = this.contarHijos(nodo.getHijo());
        }
        
        NodoI hijo = nodo.getHijo();
        
        if (cantidadHijos == 0) {
            Object[][] resultado = new Object[1][4];
            resultado[0][0] = "Nombre";
            resultado[0][1] = "Tipo";
            resultado[0][2] = "Tamaño";
            resultado[0][3] = "Ruta";
            
            return resultado;
        }

        Object[][] resultado = new Object[cantidadHijos + 1][4];
        
        resultado[0][0] = "Nombre";
        resultado[0][1] = "Tipo";
        resultado[0][2] = "Tamaño";
        resultado[0][3] = "Ruta";
        
        while (hijo != null) {
            for (int i = 1; i < resultado.length; i++) {
                for (int j = 0; j < resultado[i].length; j++) {
                    if(hijo != null) {
                        switch (j) {
                            case 0:
                                resultado[i][j] = hijo.getData().getNombre();
                                break;
                            case 1:
                                resultado[i][j] = hijo.getData().getType().toString();
                                break;
                            case 2:
                                if (hijo.getData().getType().equals(FileType.DOCUMENTO)) {
                                    resultado[i][j] = hijo.getData().getSize();
                                }
                                else {
                                    resultado[i][j] = this.tamañoHijos(hijo.getHijo());
                                }
                                break;
                            case 3:
                                resultado[i][j] = this.getRuta(hijo.getData().getId());
                                break;
                        }
                    }
                }
                
                hijo = hijo.getHermano();
            }   
        }
        
        return resultado;
    }
    
    @Override
    public int cantidadDeElementos(int fileId) {
        int contador = 0;
        NodoI nodoEncontrado = this.buscarPorId(fileId);
        NodoI hijo = nodoEncontrado.getHijo();
        
        while(hijo != null) {
            contador = contador + 1;
            hijo = hijo.getHermano();
        }
        
        return contador;
    }
    
    @Override
    public Lista buscarPorNombre(Lista lista, String text) {
        Lista result = new Lista();
        NodoLista current = lista.getInicio(); // Asumiendo que inicio es accesible; si no, usa un método getter.

        while (current != null) {
            if (current.getNombre().contains(text)) {
                result.insertarInicio(current.getId(), current.getNombre(), current.getTamaño(), current.getTipo());
            }
            current = current.getSiguiente();
        }

        return result;
    }
    
    @Override
    public Lista listaDeNodos(NodoI nodo) {
        Lista lista = new Lista();
        dfsAgregarALista(nodo, lista);
        return lista;
    }

    @Override
    public void dfsAgregarALista(NodoI nodo, Lista lista) {
        if (nodo == null) {
            return;}
        lista.insertarInicio(nodo.getData().getId(), nodo.getData().getNombre(), nodo.getData().getSize(), nodo.getData().getType());
        dfsAgregarALista(nodo.getHermano(), lista);
        dfsAgregarALista(nodo.getHijo(), lista);
    }
    
    @Override
    public boolean existeNodoConNombre(NodoI nodo, String nombreBuscado, FileType tipo) {
        if (nodo == null) {
            return false;
        }

        if (nombreBuscado.equals(nodo.getData().getNombre()) && tipo.equals(nodo.getData().getType())) {
            return true;
        }

        return existeNodoConNombre(nodo.getHijo(), nombreBuscado, tipo) || existeNodoConNombre(nodo.getHermano(), nombreBuscado, tipo);
    }
    
    @Override
    public NodoI copiarNodo(NodoI nodo, NodoI nodoPadreDestino) {
        if (nodo == null) {
            return null;
        }

        File copiaData;
        if (nodo.getData().getType() == FileType.CARPETA) {
            copiaData = new Carpeta(nodo.getData().getNombre(), nodo.getData().getSize());
        } else {
            copiaData = new Documento(nodo.getData().getNombre(), nodo.getData().getExtension(), nodo.getData().getSize());
        }

        if (existeNodoConNombre(nodoPadreDestino.getHijo(), copiaData.getNombre(), copiaData.getType())) {
            copiaData.setNombre(copiaData.getNombre() + "-copia");
        }

        NodoI copia = new Nodo(copiaData);

        copia.setHijo(copiarHijosYHermanos(nodo.getHijo()));

        return copia;
    }

    private NodoI copiarHijosYHermanos(NodoI nodo) {
        if (nodo == null) {
            return null;
        }

        File copiaDataHijo;
        if (nodo.getData().getType() == FileType.CARPETA) {
            copiaDataHijo = new Carpeta(nodo.getData().getNombre(), nodo.getData().getSize());
        } else {
            copiaDataHijo = new Documento(nodo.getData().getNombre(), nodo.getData().getExtension(), nodo.getData().getSize());
        }

        NodoI copiaNodo = new Nodo(copiaDataHijo);
        copiaNodo.setHijo(copiarHijosYHermanos(nodo.getHijo()));
        copiaNodo.setHermano(copiarHijosYHermanos(nodo.getHermano()));

        return copiaNodo;
    }
}
