package learn.java.domain.ecommerce;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.DoublePredicate;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentTest {
    double units ;
    private DoublePredicate predicateTest = d -> d == 0;

    @Test
    public void testApacheEqualsBuilder(){
        Student stu1 = new Student("Amandeep", 50);
        Student stu2 = new Student("Amandeep", 50);
        assertThat(stu1.equals(stu2)).isEqualTo(true);

        assertThat(units == 0.0d).isEqualTo(true);
        assertThat(predicateTest.test(units)).isEqualTo(true);

        assertThat(BigDecimal.valueOf(1.445354).setScale(5, BigDecimal.ROUND_HALF_EVEN).doubleValue()).isEqualTo(1.44535);
        assertThat(BigDecimal.valueOf(1.445356).setScale(5, BigDecimal.ROUND_HALF_EVEN).doubleValue()).isEqualTo(1.44536);
        System.out.println(Runtime.getRuntime().availableProcessors());

    }

}