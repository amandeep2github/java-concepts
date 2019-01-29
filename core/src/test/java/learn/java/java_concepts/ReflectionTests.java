package learn.java.java_concepts;

import static org.junit.Assert.*;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import learn.java.domain.ecommerce.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReflectionTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBeanIntrospector() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Transaction trn = new Transaction();
		trn.setReasonCd("CK");
		trn.setTransactionCategory("OO");
		trn.setTransactionType("trading");
		trn.setTrnCd("XM");
		
		BeanInfo beanInfo = Introspector.getBeanInfo(trn.getClass());
		PropertyDescriptor pdFound = null;
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds) {
			if(pd.getName().equals("reasonCd")) {
				pdFound = pd;
				break;
			}
		}
		if(pdFound != null) {
			Method method = pdFound.getReadMethod();
			System.out.println(method.invoke(trn, new Object[] {}));
		}
	}

}
