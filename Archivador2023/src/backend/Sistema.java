/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author Franco Carreras
 */
public class Sistema implements SistemaI {
    private ArbolI directorio;
    private final int totalSize = 1000000;
    private int usedSize = 0;
    
    public Sistema() {
        this.directorio = new Directorio();
        File c = new Carpeta();
        c.setNombre("C:");
        NodoI r = new Nodo(c);
        this.directorio.setRaiz(r);
    }
    
    @Override
    public SistemReturn getDirectorio() {
        return new SistemReturn(TypeError.OK, "Completado con exito", this.directorio);
    }

    @Override
    public SistemReturn add(int parentId, String nombre, FileType type, int size, String extension) {
        NodoI nodoPadre = this.directorio.buscarPorId(parentId);
        
        if (nodoPadre == null || nodoPadre.getData().getType().equals(FileType.DOCUMENTO)) {
            return new SistemReturn(TypeError.ERROR1, "No existe carpeta de parentId dado o no es de una carpeta");
        }
        else if (this.directorio.existeNodoConNombre(nodoPadre, nombre, type)) {
            if (type.equals(FileType.CARPETA)) {
                return new SistemReturn(TypeError.ERROR2, "Existe carpeta con el mismo nombre");
            }
            else {
               return new SistemReturn(TypeError.ERROR2, "Existe documento con el mismo nombre"); 
            }
        }
        else if ((this.totalSize - this.usedSize) < size) {
            return new SistemReturn(TypeError.ERROR3, "No hay suficiente espacio en disco");
        }
        
        File nodoAinsertar = null;
        
        if(type.equals(FileType.CARPETA)) {
            nodoAinsertar = new Carpeta(nombre, size);
        }
        else {
            nodoAinsertar = new Documento(nombre, extension, size);
        }
        
        if(nodoPadre.getData().getType().equals(FileType.CARPETA)) {
            this.directorio.insertar(nodoPadre, nodoAinsertar);
        }
        
        nodoPadre.getData().setSize(nodoPadre.getData().getSize() + size);
        this.usedSize = this.usedSize + size;
        
        return new SistemReturn(TypeError.OK, "Insertado correctamente", this.directorio);
    }

    @Override
    public SistemReturn update(int fileId, String nombre, int size, String extension) {
        NodoI nodoAeditar = this.directorio.buscarPorId(fileId);
        
        if (nodoAeditar == null) {
            return new SistemReturn(TypeError.ERROR1, "El nodo no existe");
        }
        else if ((int) this.sizeAvailable().result < size) {
            return new SistemReturn(TypeError.ERROR3, "No hay suficiente espacio en disco");
        }
        
        boolean nombreIgual = this.directorio.existeNodoConNombre(this.directorio.getRaiz(), nombre, nodoAeditar.getData().getType());
        
        if(nombreIgual == true) {
            return new SistemReturn(TypeError.ERROR2, "Existe Carpeta/Documento con el mismo nombre");
        }
        
        this.usedSize = this.usedSize - nodoAeditar.getData().getSize() + size;
        
        if (nodoAeditar.getData().getType().equals(FileType.DOCUMENTO)) {
            File nuevaData = new Documento(nombre, extension, size);
            nodoAeditar.setData(nuevaData);
        }
        else {
            File nuevaData = new Carpeta();
            nuevaData.setNombre(nombre);
            nodoAeditar.setData(nuevaData);
        }
        
        return new SistemReturn(TypeError.OK, "Carpeta/Documento editado correctamente", nodoAeditar);
    }

    @Override
    public SistemReturn delete(int fileId) {
        NodoI nodoAeliminar = this.directorio.buscarPorId(fileId);
        
        if (nodoAeliminar == null) {
            return new SistemReturn(TypeError.ERROR1, "No existe Carpeta/Documento de id " + fileId);
        }
        else if (this.directorio.getRaiz().getData().getId() == fileId) {
            return new SistemReturn(TypeError.ERROR2, "No se puede borrar la raíz del directorio");
        }
        
        if (nodoAeliminar.getData().getType().equals(FileType.CARPETA)) {
            int tamañoCarpeta = this.directorio.tamañoHijos(nodoAeliminar.getHijo());
            
            this.usedSize = this.usedSize - tamañoCarpeta;
        }
        else {
            this.usedSize = this.usedSize - nodoAeliminar.getData().getSize();
        }
        
        this.directorio.borrar(fileId);
        
        return new SistemReturn(TypeError.OK, "Carpeta/Documento borrado correctamente");
    }

    @Override
    public SistemReturn search(String nombre) {
        if(nombre.equals("") || nombre == null) {
            return new SistemReturn(TypeError.ERROR2, "La palabra clave para buscar es vacía");
        }
  
        Lista listaEncontrada = this.directorio.listaDeNodos(this.directorio.getRaiz());
        listaEncontrada = this.directorio.buscarPorNombre(listaEncontrada, nombre);
        
        if (listaEncontrada.esVacia()) {
            return new SistemReturn(TypeError.ERROR1, "No se encontraron resultados");
        }
        
        NodoLista current = listaEncontrada.getInicio();
        
        Object[][] matriz = new Object[listaEncontrada.largo() + 1][4];
        matriz[0][0] = "Nombre";
        matriz[0][1] = "Tipo";
        matriz[0][2] = "Tamaño";
        matriz[0][3] = "Ruta";
        
        while (current != null) {
            for (int i = 1; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    switch (j) {
                        case 0:
                            matriz[i][j] = current.getNombre();
                            break;
                        case 1:
                            matriz[i][j] = current.getTipo().toString();
                            break;
                        case 2:
                            matriz[i][j] = current.getTamaño();
                            break;
                        case 3:
                            matriz[i][j] = this.directorio.getRuta(current.getId());
                            break;
                    }
                }
                
                current = current.getSiguiente();
            }
        }
        
        return new SistemReturn(TypeError.OK, "Archivos encontrados con éxito", matriz);
    }

    @Override
    public SistemReturn getById(int fileId) {
        if (!(fileId == (int)fileId)) {
            return new SistemReturn(TypeError.ERROR2, "El campo fieldId no es un entero");
        }
        
        NodoI nodoEncontrado = this.directorio.buscarPorId(fileId);
        
        if (nodoEncontrado  == null) {
            return new SistemReturn(TypeError.ERROR1, "No se encontraron resultados");
        }
        
        return new SistemReturn(TypeError.OK, "Nodo encontrado", nodoEncontrado);
    }

    @Override
    public SistemReturn copy(int fileId, int parentId) {
        NodoI nodoACopiar = this.directorio.buscarPorId(fileId);
        NodoI nuevoPadre = this.directorio.buscarPorId(parentId);

        if(nodoACopiar == null) {
            return new SistemReturn(TypeError.ERROR1, "El nodo a copiar no existe");
        }
        
        if(nuevoPadre == null) {
            return new SistemReturn(TypeError.ERROR2, "El nodo al que se quiere pegar el nodo copiado no existe");
        }

        NodoI nodoCopiado = this.directorio.copiarNodo(nodoACopiar, nuevoPadre);

        nodoCopiado.setHermano(nuevoPadre.getHijo());
        nuevoPadre.setHijo(nodoCopiado);
        
        if (nodoACopiar.getData().getType().equals(FileType.CARPETA)) {
            this.usedSize = this.usedSize + this.directorio.tamañoHijos(nodoACopiar);
        }
        else {
            this.usedSize = this.usedSize + nodoACopiar.getData().getSize();
        }
        
        return new SistemReturn(TypeError.OK, "Documento/Carpeta pegado exitosamente");
    }

    @Override
    public SistemReturn cut(int fieldId, int parentId) {
        NodoI nodoACopiar = this.directorio.buscarPorId(fieldId);
        NodoI nuevoPadre = this.directorio.buscarPorId(parentId);

        if(nodoACopiar == null) {
            return new SistemReturn(TypeError.ERROR1, "El nodo a cortar no existe");
        }
        
        if(nuevoPadre == null) {
            return new SistemReturn(TypeError.ERROR2, "El nodo al que se quiere pegar el nodo cortado no existe");
        }

        NodoI nodoCopiado = this.directorio.copiarNodo(nodoACopiar, nuevoPadre);

        nodoCopiado.setHermano(nuevoPadre.getHijo());
        nuevoPadre.setHijo(nodoCopiado);
        
        this.directorio.borrar(fieldId);
        
        return new SistemReturn(TypeError.OK, "Documento/Carpeta pegado exitosamente");
    }

    @Override
    public SistemReturn getTotalSize() {
        return new SistemReturn(TypeError.OK, "Tamaño total del sistema", this.totalSize);
    }

    @Override
    public SistemReturn sizeAvailable() {
        int tamañoDisponible = this.totalSize - this.usedSize;
        
        return new SistemReturn(TypeError.OK, "Espacio disponible del sistema", tamañoDisponible);
    }

    @Override
    public SistemReturn sizeOcuped() {
        return new SistemReturn(TypeError.OK, "Espacio ocupado del sistema", this.usedSize);
    }

    @Override
    public SistemReturn sizeOcuped(int fileId) {
        NodoI nodoEncontrado = this.directorio.buscarPorId(fileId);
        
        if(nodoEncontrado == null) {
            return new SistemReturn(TypeError.ERROR1, "El nodo no existe");
        }
        
        if (nodoEncontrado.getData().getType().equals(FileType.DOCUMENTO)) {
            return new SistemReturn(TypeError.OK, "Espacio ocupado encontrado correctamente", nodoEncontrado.getData().getSize());
        }
        else {
            int tamañoCarpeta = this.directorio.tamañoHijos(nodoEncontrado.getHijo());
            
            return new SistemReturn(TypeError.OK, "Espacio ocupado encontrado correctamente", tamañoCarpeta);
        }
    }

    @Override
    public SistemReturn totalFiles(int fileId) {
        NodoI nodoEncontrado = this.directorio.buscarPorId(fileId);
        
        if(nodoEncontrado == null) {
            return new SistemReturn(TypeError.ERROR1, "El nodo no existe");
        }
        
        if (nodoEncontrado.getData().getType().equals(FileType.DOCUMENTO)) {
            return new SistemReturn(TypeError.OK, "Cantidad de elementos encontrada", 1);
        }
        
        int cantidadElementos = this.directorio.cantidadDeElementos(fileId);
        
        return new SistemReturn(TypeError.OK, "Cantidad de elementos encontrada", cantidadElementos);
    }

    @Override
    public SistemReturn getFiles(int fileId) {
        NodoI nodoEncontrado = this.directorio.buscarPorId(fileId);
        
        if(nodoEncontrado == null) {
            return new SistemReturn(TypeError.ERROR1, "El nodo no existe");
        }
        
        if(nodoEncontrado.getData().getType().equals(FileType.DOCUMENTO)) {
            Object[][] data = new Object[2][4];
            data[0][0] = "Nombre";
            data[0][1] = "Tipo";
            data[0][2] = "Tamaño";
            data[0][3] = "Ruta";
            data[1][0] = nodoEncontrado.getData().getNombre();
            data[1][1] = nodoEncontrado.getData().getType();
            data[1][2] = nodoEncontrado.getData().getSize();
            data[1][3] = this.directorio.getRuta(fileId);
            
            return new SistemReturn(TypeError.OK, "Datos retornados correctamente", data);
        }
        else {
            Object[][] data = this.directorio.hijosDelNodo(fileId);
            
            return new SistemReturn(TypeError.OK, "Datos retornados correctamente", data);
        }
    }
}
