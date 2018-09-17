package applicationprototype.main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

import applicationprototype.main.application.util.PopulateApplication;
import applicationprototype.main.domain.shared.CoreFactory;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.ui.presenter.HomePresenter;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private Main() {
		
	}
	
	private void run() {
		try {
			new PopulateApplication();//popular com alguns dados para exemplo.
			new HomePresenter((IContext) CoreFactory.create("context.init").newInstance());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"oh no!!", JOptionPane.ERROR_MESSAGE, null);
			e.printStackTrace();
		}
	}

}
