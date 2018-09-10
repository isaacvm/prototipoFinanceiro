package applicationprototype.main.infrastructure.persistence.serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import applicationprototype.main.domain.shared.Entity;

public abstract class AbstractRepositorySerializable implements Serializable{
	
	private final static String BASE_DIR = System.getProperty("user.dir")+"\\src\\applicationprototype\\resource\\repositoryfiles\\";
	protected List<Entity> collection;
	
	public AbstractRepositorySerializable() {
		checkFile();
		this.collection = new ArrayList<>();
	}

	private void checkFile() {
		String dir = new StringBuilder(BASE_DIR).append(this.getClass().getSimpleName()).append(".data").toString();
		File file = new File(dir);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public abstract void save(List<Entity> collection);
	public abstract List<Entity> read();
	

}