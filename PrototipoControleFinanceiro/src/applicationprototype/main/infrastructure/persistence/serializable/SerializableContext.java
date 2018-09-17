package applicationprototype.main.infrastructure.persistence.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.repository.IRepository;


/*
 * Essa implementação trata estritamente da responsabilidade de persistência de dados em questão.
 */
public class SerializableContext implements IContext {

	protected final static String BASE_DIR = System.getProperty("user.dir")
			+ "\\src\\applicationprototype\\resource\\repositoryfiles\\";

	private IRepository repository;

	public SerializableContext() {
	}

	private final void checkFile(String dir) throws PersistenceException {
		File file = new File(dir);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new PersistenceException(e);
			}
		}

	}

	@Override
	public IRepository getRepository() throws PersistenceException {
		if (repository==null) 
		return loadCollection();
		return repository;
	}

	private IRepository loadCollection() {
		String pathname = new StringBuilder(BASE_DIR).append(this.repository.getClass().getSimpleName()).append(".data")
				.toString();
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		IRepository ret = null;
		try {
			fis = new FileInputStream(new File(pathname));
			ois = new ObjectInputStream(fis);
			ret = (IRepository) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public boolean saveChanges() {
		String pathname = new StringBuilder(BASE_DIR).append(this.repository.getClass().getSimpleName()).append(".data")
				.toString();
		FileOutputStream fos;
		ObjectOutputStream oos;
		boolean ret = false;
		try {
			checkFile(pathname);
			fos = new FileOutputStream(new File(pathname));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this.repository);
			ret = true;
		} catch (PersistenceException | IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public SerializableContext set(IRepository repo ) {
		this.repository = repo;
		return this;
	}
	/*
	 * @Override public void saveChanges(HashMap<String, AbstractRepository> map)
	 * throws PersistenceException { if (map != null && !map.isEmpty()) {
	 * FileOutputStream fos; ObjectOutputStream oos; for (String fileName :
	 * map.keySet()) { String pathname = new
	 * StringBuilder(BASE_DIR).append(fileName).append(".data").toString();
	 * checkFile(pathname); File file = new File(pathname);
	 * 
	 * try { fos = new FileOutputStream(file); oos = new ObjectOutputStream(fos);
	 * oos.writeObject(map.get(fileName)); oos.close(); fos.close(); } catch
	 * (IOException e) { throw new PersistenceException(e); } } } }
	 * 
	 * 
	 * @Override public List<T> getAll(){ return null; }
	 */

}
