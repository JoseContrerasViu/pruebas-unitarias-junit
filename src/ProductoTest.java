import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Modelo.Producto;

public class ProductoTest {
    static Producto producto1;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass()");
        producto1 = new Producto("Samsung Galaxy", 300, "versuion 6");
        assertEquals("Comprobamos el numero de unidades para este producto", 0,
                producto1.getNumeroDeUnidadesEnAlmacen());
        for (int i = 0; i < 10; i++) {
            producto1.añadirUnidadAlAlmacen();
        }
        assertEquals("Comprobamos el numero de unidades para este producto", 10,
                producto1.getNumeroDeUnidadesEnAlmacen());
    }

    @Before
    public void setUp() {
        System.out.println("before");
        producto1.quitarUnidadDeAlmacen();
    }

    @Test
    public void testQuitarUnidadDelAlmacen() {
        assertEquals("Comprobamos el numero de unidades para este producto", 9,
                producto1.getNumeroDeUnidadesEnAlmacen());
    }

    @After
    public void tearDown() {
        System.out.println("After tearDown()");
        producto1.añadirUnidadAlAlmacen();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass()");
        for (int i = 0; i < 10; i++) {
            producto1.quitarUnidadDeAlmacen();
        }
        assertEquals("Comprobamos el numero de unidades para este producto", 0,
                producto1.getNumeroDeUnidadesEnAlmacen());
    }

        @Test
    public void testEsMasCaro() {
        Producto productoBarato = new Producto("Producto Barato", 100, "Descripción barata");
        Producto productoCaro = new Producto("Producto Caro", 500, "Descripción cara");
        
        assertTrue("El producto caro debería ser más caro", productoCaro.esMasCaro(productoBarato));
        assertTrue("El producto barato NO debería ser más caro", !productoBarato.esMasCaro(productoCaro));
    }
}