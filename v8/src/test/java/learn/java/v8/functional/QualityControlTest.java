package learn.java.v8.functional;

import learn.java.domain.ecommerce.MobilePhone;
import learn.java.domain.ecommerce.Product;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class QualityControlTest {

    @Test
    public void testWithLambda() {
        MobilePhone phone1 = new MobilePhone(6);
        MobilePhone phone2 = new MobilePhone(5);

        List<Product> mobilePhonesTotal = Arrays.asList(phone1, phone2);

        QualityControl qc = new QualityControl();
        List<Product> mobilePhonesPassed = qc.execute(mobilePhonesTotal, (product) -> {
            MobilePhone mb = (MobilePhone) product;
            return mb.getScreenSize() > 5;
        });
        assertThat(mobilePhonesTotal).size().isEqualTo(2);
        assertThat(mobilePhonesPassed).size().isEqualTo(1);


    }

    @Test
    public void testWithFunctionalPointer() {
        MobilePhone phone1 = new MobilePhone(6);
        MobilePhone phone2 = new MobilePhone(5);

        List<Product> mobilePhonesTotal = Arrays.asList(phone1, phone2);

        QualityControl qc = new QualityControl();
        List<Product> mobilePhonesPassed = qc.execute(mobilePhonesTotal, MobilePhoneTester::check);
        assertThat(mobilePhonesTotal).size().isEqualTo(2);
        assertThat(mobilePhonesPassed).size().isEqualTo(1);


    }
}