public class AnalizadorCatalogo {

    // Asociación: el arreglo forma parte del estado del analizador
    private Producto[] productos;

    public AnalizadorCatalogo(Producto[] productos) {
        this.productos = productos;
    }

    public String listarProductos() {
        String resultado = "";

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                resultado += productos[i].mostrarInformacion() + "\n";
            }
        }

        return resultado;
    }

    public int contarDisponibles() {
        int contador = 0;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].isDisponible()) {
                contador++;
            }
        }

        return contador;
    }

    public double calcularPrecioPromedio() {
        double suma = 0;
        int validos = 0;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                suma += productos[i].getPrecio();
                validos++;
            }
        }

        if (validos == 0) {
            return 0; // arreglo vacío o sin productos válidos
        }

        return suma / validos;
    }

    public Producto buscarPorCodigo(String codigo) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getCodigo().equals(codigo)) {
                return productos[i];
            }
        }
        return null;
    }

    // Desafío adicional
    public Producto obtenerProductoMasCaro() {
        Producto masCaro = null;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                if (masCaro == null || productos[i].getPrecio() > masCaro.getPrecio()) {
                    masCaro = productos[i];
                }
            }
        }

        return masCaro;
    }
}