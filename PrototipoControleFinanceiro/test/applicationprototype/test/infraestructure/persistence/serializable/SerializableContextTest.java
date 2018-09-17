package applicationprototype.test.infraestructure.persistence.serializable;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import applicationprototype.main.domain.model.revenue.Revenue;
import applicationprototype.main.domain.model.revenue.RevenueTypeVO;
import applicationprototype.main.domain.shared.IEntity;
import applicationprototype.main.infrastructure.persistence.AbstractRepository;
import applicationprototype.main.infrastructure.persistence.AbstractUnitOfWork;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.persistence.serializable.SerializableContext;
import applicationprototype.main.infrastructure.repository.ExpenseRepository;

public class SerializableContextTest {

	private final static String BASE_DIR = System.getProperty("user.dir")
			+ "\\src\\applicationprototype\\resource\\repositoryfiles\\";
	private final static String BASE_ARCHIEVE = TestRepositorySerializable.class.getSimpleName();
	private final static String BASE_TEST_FILE = new StringBuilder(BASE_DIR).append(BASE_ARCHIEVE).append(".data")
			.toString();
	private static File file;
	private IContext context;
	private AbstractRepository<IEntity> test;
	private IEntity entity;

	@Before
	public void setUp() {
		file = new File(BASE_TEST_FILE);
		context = new SerializableContext();
		test = new TestRepositorySerializable(context);
		entity = new ClassTest();
	}

	@SuppressWarnings("static-access")
	@Test
	public void createFileWithSuccess() {
		deleteTestFile();
		try {
			test.store(entity);
		} catch (PersistenceException e) {
			e.printStackTrace();
		};
		assertTrue(this.file.exists());
	}

	@Test
	public void keepCreatedFile() throws PersistenceException {
		deleteTestFile();
		String sampleData = "teste unitário";
		((ClassTest)this.entity).setTest(sampleData);
		test.store(this.entity);
		test.store(new ClassTest());
		List<IEntity> all = test.getAll(entity);
		assertEquals(2, all.size());
	}

	private TestRepositorySerializable updateFile() {
		TestRepositorySerializable ret = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ret =  (TestRepositorySerializable) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	private void saveFile(TestRepositorySerializable test) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(test);
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void deleteTestFile() {
		if (file.exists())
			file.delete();
	}

	@AfterClass
	public static void destroyArchieves() {
		deleteTestFile();
	}
}
