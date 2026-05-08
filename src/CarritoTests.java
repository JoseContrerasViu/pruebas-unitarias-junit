import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Modelo.CarroDeLaCompra;
import Modelo.Producto;

public class CarritoTests {
    static Producto producto1, producto2;
    static CarroDeLaCompra carro;

    @BeforeClass
    public static void beforeClass() {
        producto1 = new Producto("Samsung Galaxy", 500, "Version 6");
        producto2 = new Producto("Iphone", 1000, "Version 15");
        carro = new CarroDeLaCompra();
    }

    @Before
    public void setUp() {
        System.out.println("before");
        carro = new CarroDeLaCompra();
    }

    @Test
    public void testAñadirProductoAlCarro() {
        assertEquals("Comprobamos el carro de la compra esta vacio ", 
                     CarroDeLaCompra.ESTADO.VACIO, carro.getEstado());
        assertEquals("Comprobamos el precio del carro tras incorporar el Samsung Galaxy", 
                     0, carro.getTotal());

        carro.añadirProductoAlCarrro(producto1);
        assertEquals("Comprobamos el precio del carro tras incorporar el Samsung Galaxy", 
                     500, carro.getTotal());

        carro.añadirProductoAlCarrro(producto2);
        assertEquals("Comprobamos el precio del carro tras incorporar el Iphone", 
                     1500, carro.getTotal());

        assertEquals("Comprobamos que el carro esta preparado", 
                     CarroDeLaCompra.ESTADO.PREPARADO, carro.getEstado());
    }

    @After
    public void tearDown() {
        System.out.println("After tearDown()");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass()");
    }

        @Test
    public void testQuitarProductoDelCarro() {
        carro.añadirProductoAlCarrro(producto1);
        carro.añadirProductoAlCarrro(producto2);

        assertEquals("El total debería ser 1500 antes de quitar", 1500, carro.getTotal());

        carro.quitarProductoDelCarrro(0, producto1.getPrecio());

        assertEquals("El total debería ser 1000 después de quitar", 1000, carro.getTotal());
        assertEquals("El estado sigue siendo PREPARADO", 
                     CarroDeLaCompra.ESTADO.PREPARADO, carro.getEstado());
    }
}