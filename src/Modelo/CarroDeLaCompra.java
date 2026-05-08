package Modelo;

import java.util.ArrayList;
import java.util.List;

public class CarroDeLaCompra {
    private List<Producto> listaDeProductos = new ArrayList<Producto>();
    private int total = 0;

    public enum ESTADO {
        VACIO,
        PREPARADO,
        COMPRADO,
        ENVIADO,
        ANULADO
    }

    private ESTADO estado = ESTADO.VACIO;

    public ESTADO getEstado() {
        return estado;
    }

    public CarroDeLaCompra() {
    }

    public void añadirProductoAlCarrro(Producto producto) {
        listaDeProductos.add(producto);
        total = total + producto.getPrecio();
        estado = ESTADO.PREPARADO;
    }

    public void quitarProductoDelCarrro(int posicion, int precio) {
        if (posicion >= 0 && posicion < listaDeProductos.size()) {
            listaDeProductos.remove(posicion);
            total = total - precio;
            estado = ESTADO.PREPARADO;
        }
    }

    public void comprarCarrito() {
        estado = ESTADO.COMPRADO;
    }

    public int getTotal() {
        return total;
    }
}