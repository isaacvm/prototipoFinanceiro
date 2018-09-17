package applicationprototype.main.ui.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import applicationprototype.main.application.impl.ExpenseMovimentImpl;
import applicationprototype.main.application.impl.RevenueMovimentImpl;
import applicationprototype.main.application.util.DateHelper;
import applicationprototype.main.domain.shared.CoreFactory;
import applicationprototype.main.domain.shared.IEntity;
import applicationprototype.main.domain.shared.IValueObject;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.repository.IRepository;
import applicationprototype.main.ui.CreateUI;

public class CreatePresenter extends BasePresenter {

	private CreateUI ui;

	public CreatePresenter(IContext context) {
		super(context);
		ui = new CreateUI();

		ui.getRadioExpense().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				radioExpenseAction();
			}
		});

		ui.getRadioRevenue().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				radioRevenueAction();
			}
		});

		ui.getComboType().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboTypeAction();
			}
		});

		ui.getRadioRevenue().setSelected(true);
		ui.getRadioRevenue().doClick();

		ui.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ui.setVisible(false);
				ui.dispose();
			}
		});

		ui.getBtnSave().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addFinancialMoviment();
			}
		});
		ui.setLocationRelativeTo(null);
		ui.pack();
		ui.setVisible(true);
	}

	private void addFinancialMoviment() {
		Enumeration<AbstractButton> elements = ui.getButtonGroup().getElements();
		String registro = null;
		while (elements.hasMoreElements()) {
			AbstractButton nextElement = elements.nextElement();
			if (nextElement.isSelected()) {
				registro = nextElement.getText();
				break;
			}
		}
		String type = ui.getComboType().getSelectedItem().toString();
		String classification = (ui.getComboClassification().getSelectedItem() == null) ? ""
				: ui.getComboClassification().getSelectedItem().toString();
		Date date = DateHelper.parseToDate(ui.getFieldDate().getText());
		double value = Double.parseDouble(ui.getFieldValue().getText());
		String notes = ui.getPaneObservation().getText();
		
		try {
			
			if (registro.equals("Expense")) {
				ExpenseMovimentImpl registry = new ExpenseMovimentImpl(
						(IRepository<IEntity>) CoreFactory.create("expense.repository").newInstance(this.context),
						(IRepository<IValueObject>) CoreFactory.create("expensetype.repository")
								.newInstance(this.context),
						(IRepository<IValueObject>) CoreFactory.create("expenseclassification.repository")
								.newInstance(this.context));

				registry.createMoviment(registro, type, classification, date, value, notes);
				
			} else {
				
				RevenueMovimentImpl registry = new RevenueMovimentImpl(
						(IRepository<IEntity>) CoreFactory.create("revenue.repository")
						.newInstance(this.context),
						(IRepository<IValueObject>) CoreFactory.create("revenuetype.repository")
						.newInstance(this.context));

				registry.createMoviment(registro, type, date, value, notes);
			}

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException | NoSuchMethodException | SecurityException | ClassNotFoundException
				| PersistenceException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void radioExpenseAction() {
		ui.getComboType().removeAllItems();
		ui.getComboType().addItem("Fixa");
		ui.getComboType().addItem("Variável");
		comboTypeAction();
	}

	private void comboTypeAction() {
		ui.getComboClassification().removeAllItems();
		if (ui.getRadioExpense().isSelected() && ui.getComboType().getSelectedItem() != null) {
			String item = ui.getComboType().getSelectedItem().toString();
			populateClassification(item);
			ui.getComboClassification().setSelectedIndex(0);
		}
	}

	private void radioRevenueAction() {
		ui.getComboType().removeAllItems();
		ui.getComboClassification().removeAllItems();
		ui.getComboType().addItem("Salário");
		ui.getComboType().addItem("Consultoria");
	}

	private void populateClassification(String selectedItem) {
		switch (selectedItem) {
		case "Fixa":
			ui.getComboClassification().addItem("Aluguél");
			ui.getComboClassification().addItem("Netflix");
			break;
		case "Variável":
			ui.getComboClassification().addItem("Supermercado");
			ui.getComboClassification().addItem("Gasolina");
			break;
		default:
			break;
		}
	}
}
