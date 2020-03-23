import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class FractionAssertJTest
{
    Fraction fr;
    @Test
    public void test_getNominator()
    {
        fr = Fraction.HALF;
        assertThat(fr.getNominator()).isEqualTo(1);
    }
    
    @Test
    public void test_GetDenominator()
    {
        fr = Fraction.HALF;
        assertThat(fr.getDenominator()).isEqualTo(2);
    }
    
    @Test
    public void test_doubleNan()
    {
        fr = Fraction.INDETERMINATE;
        assertThat(fr.doubleValue()).isNaN();
    }
    
    @Test
    public void test_doubleValue_FULL()
    {
        fr = Fraction.FULL;
        assertThat(fr.doubleValue()).isEqualTo(1.0);
    }
    
    @Test
    public void test_doubleValue_HALF()
    {
        fr = Fraction.HALF;
        assertThat(fr.doubleValue()).isEqualTo(0.5);//, closeTo(0.5, 0));
    }
    
    @Test
    public void test_doubleValue_OneThird()
    {
        fr = Fraction.ONE_THIRD;
        assertThat(fr.doubleValue()).isCloseTo(0.3, within(0.1));
    }
    
    @Test
    public void test_of()
    {
        fr = Fraction.of(1,2);
        Fraction fr1 = Fraction.HALF;
        assertThat(fr).isEqualTo(fr1);
    }
    
    @Test
    public void test_multiply()
    {
        Fraction a = Fraction.HALF;
        Fraction b = Fraction.ONE_THIRD;
        assertThat(Fraction.multiply(a,b).toString()).isEqualTo("1/6");
    }
    
    @Test
    public void test_add()
    {
        Fraction a = Fraction.HALF;
        Fraction b = Fraction.ONE_THIRD;
        assertThat(Fraction.add(a,b).toString()).isEqualTo("5/6");
    }
    
    @Test
    public void test_add_zero()
    {
        Fraction a = Fraction.HALF;
        Fraction b = Fraction.INDETERMINATE;
        assertThat(Fraction.add(a,b)).isEqualTo(Fraction.INDETERMINATE);
    }
}