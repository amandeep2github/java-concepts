package learn.java.v8.functional;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class FunctionalInterfaceStaticInstancesTest {

    @Test
    public void testAddition(){
        assertThat(TwoNumberFunction.add().operation(10, 5)).isEqualTo(new Double(15));
    }

    @Test
    public void testSubtraction(){
        assertThat(TwoNumberFunction.subtract().operation(10, 5)).isEqualTo(new Double(5));
    }

}
