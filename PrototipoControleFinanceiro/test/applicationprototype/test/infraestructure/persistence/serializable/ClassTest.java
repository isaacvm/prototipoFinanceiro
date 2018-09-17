package applicationprototype.test.infraestructure.persistence.serializable;

import applicationprototype.main.domain.shared.IEntity;

public class ClassTest implements IEntity<ClassTest>{

	private String test;
	
	@Override
	public ClassTest getById(Number key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	

}
