import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class FractionHamcrestTest
{
    Fraction fr;
    @Test
    public void test_getNominator()
    {
        fr = Fraction.HALF;
        assertThat(fr.getNominator(), equalTo(1));
    }
    
    @Test
    public void test_GetDenominator()
    {
        fr = Fraction.HALF;
        assertThat(fr.getDenominator(), equalTo(2));
    }
    
    @Test
    public void test_doubleNaN()
    {
        fr = Fraction.INDETERMINATE;
        assertThat(fr.doubleValue(), notANumber());
    }
    
    @Test
    public void test_doubleValue_FULL()
    {
        fr = Fraction.FULL;
        assertThat(fr.doubleValue(), equalTo(1.0));
    }
    
    @Test
    public void test_doubleValue_HALF()
    {
        fr = Fraction.HALF;
        assertThat(fr.doubleValue(), closeTo(0.5, 0));
    }
    
    @Test
    public void test_doubleValue_OneThird()
    {
        fr = Fraction.ONE_THIRD;
        assertThat(fr.doubleValue(), is(closeTo(0.3, 0.1)));
    }
    
    @Test
    public void test_of()
    {
        fr = Fraction.of(1,2);
        Fraction fr1 = Fraction.HALF;
        assertThat(fr, equalTo(fr1));
    }
    
    @Test
    public void test_multiply()
    {
        Fraction a = Fraction.HALF;
        Fraction b = Fraction.ONE_THIRD;
        assertThat(Fraction.multiply(a,b).toString(), equalTo("1/6"));
    }
    
    @Test
    public void test_add()
    {
        Fraction a = Fraction.HALF;
        Fraction b = Fraction.ONE_THIRD;
        assertThat(Fraction.add(a,b).toString(), equalTo("5/6"));
    }
    
    @Test
    public void test_add_zero()
    {
        Fraction a = Fraction.HALF;
        Fraction b = Fraction.INDETERMINATE;
        assertThat(Fraction.add(a,b), equalTo(Fraction.INDETERMINATE));
    }
}