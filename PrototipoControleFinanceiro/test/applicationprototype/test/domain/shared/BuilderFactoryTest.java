package applicationprototype.test.domain.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.junit.Test;

import applicationprototype.main.domain.factory.BuilderFactory;
import applicationprototype.main.domain.model.revenue.RevenueBuilder;
import applicationprototype.main.domain.shared.CoreFactory;
import applicationprototype.main.domain.shared.AbstractFinancialMovimentBuilder;

public class BuilderFactoryTest {

	@Test
	public void createWithSuccess() throws IOException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try {
			CoreFactory factory = new BuilderFactory();
			Constructor toFactory = factory.create("Revenue");
			RevenueBuilder target = (RevenueBuilder) toFactory.newInstance(GregorianCalendar.getInstance().getTime(),
					"lala", new BigDecimal(1));
			assertEquals(target.getClass(), RevenueBuilder.class);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
