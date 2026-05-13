import org.junit.*;
import static org.junit.Assert.*;
import Modelo.Usuario;
import Modelo.Liquidacion;

public class GestionBarrioTests {

    private static Usuario usuarioPrueba;
    private static Liquidacion liquidacionPrueba;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("=== INICIO DE TODAS LAS PRUEBAS DE GESTIÓN DE BARRIO ===");
        usuarioPrueba = new Usuario("josevecino", "123456", "jose@barrio.es");
        liquidacionPrueba = new Liquidacion("Cuota mensual barrio", 120.0);
    }

    @Before
    public void setUp() {
        System.out.println("--- Preparando nuevo test ---");
    }

    @Test
    public void testRegistrarUsuarioExitoso() {
        boolean registrado = usuarioPrueba.registrar();
        assertTrue("El usuario debe registrarse correctamente", registrado);
    }

    @Test
    public void testAutenticarUsuarioCorrecto() {
        boolean autenticado = usuarioPrueba.autenticar("123456");
        assertTrue("La autenticación con contraseña correcta debe funcionar", autenticado);
        assertTrue("El usuario debe quedar autenticado", usuarioPrueba.isAutenticado());
    }

    @Test
    public void testAutenticarUsuarioConPasswordIncorrecta() {
        boolean autenticado = usuarioPrueba.autenticar("passwordmal");
        assertFalse("La autenticación con contraseña incorrecta debe fallar", autenticado);
    }

    @Test
    public void testCalcularTotalLiquidacionSinImpuestos() {
        double total = liquidacionPrueba.calcularTotal();
        assertEquals("El total sin impuestos debe ser igual al importe base", 120.0, total, 0.01);
    }

    @Test
    public void testCalcularTotalLiquidacionConImpuestos() {
        liquidacionPrueba.añadirImpuesto(10);
        liquidacionPrueba.añadirImpuesto(5);
        double total = liquidacionPrueba.calcularTotal();
        assertEquals("El total con impuestos debe ser correcto", 138.0, total, 0.01);
    }

    @After
    public void tearDown() {
        System.out.println("--- Test finalizado ---");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("=== FIN DE TODAS LAS PRUEBAS DE GESTIÓN DE BARRIO ===");
    }
}