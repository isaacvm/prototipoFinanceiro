package applicationprototype.main.ui.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.ui.HomeUI;

public class HomePresenter extends BasePresenter{

	private HomeUI ui;

	public HomePresenter(IContext context) {
		super(context);
		this.context = context;
		ui = new HomeUI();
		ui.getBtnCreate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createRegistry();
			}
		});
		ui.getBtnExpenseList().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listResume();
				
			}
		});
		ui.setLocationRelativeTo(null);
		ui.pack();
		ui.setVisible(true);
	}

	private void listResume() {
		new ListPresenter(this.context);
		ui.toBack();
	}

	private void createRegistry() {
		new CreatePresenter(this.context);
		ui.toBack();		
	}

}
