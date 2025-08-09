import static org.junit.Assert.*;
import org.junit.Test;

public class GammaFunctionTest {

    @Test
    public void testGamma1() {
        assertEquals(1.0, GammaFunction.gamma(1.0), 1e-8);
    }

    @Test
    public void testGamma2() {
        assertEquals(1.0, GammaFunction.gamma(2.0), 1e-8);
    }

    @Test
    public void testGamma3Point5() {
        assertEquals(3.3233509704478426, GammaFunction.gamma(3.5), 1e-8);
    }

    @Test
    public void testGamma0Point5() {
        assertEquals(Math.sqrt(Math.PI), GammaFunction.gamma(0.5), 1e-8);
    }

    @Test
    public void testGamma10() {
        assertEquals(362880.0, GammaFunction.gamma(10.0), 1e-8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGamma0ThrowsException() {
        GammaFunction.gamma(0); // Throws for x <= 0
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGammaNegativeIntegerThrowsException() {
        GammaFunction.gamma(-1);
    }

    @Test
    public void testGammaNegativeFractionValid() {
        double result = GammaFunction.gamma(-2.5);
        assertEquals(-0.9453087204829419, result, 1e-8);
    }

    @Test
    public void testGammaLargeValue() {
        double result = GammaFunction.gamma(100);
        assertTrue("Large value test failed", result > 0);
    }

    @Test
    public void testGammaPrecision() {
        double result = GammaFunction.gamma(2.5);
        assertEquals(1.329340388, result, 1e-8);
    }
}
