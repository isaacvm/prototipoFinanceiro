package applicationprototype.main.ui.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import applicationprototype.main.application.impl.ReportMovimentImpl;
import applicationprototype.main.domain.model.expense.ExpenseClassificationVO;
import applicationprototype.main.domain.model.expense.ExpenseTypeVO;
import applicationprototype.main.domain.shared.CoreFactory;
import applicationprototype.main.infrastructure.persistence.IContext;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.repository.ExpenseClassificationRepository;
import applicationprototype.main.infrastructure.repository.ExpenseRepository;
import applicationprototype.main.infrastructure.repository.ExpenseTypeRepository;
import applicationprototype.main.infrastructure.repository.IRepository;
import applicationprototype.main.infrastructure.repository.RevenueRepository;
import applicationprototype.main.ui.ListResumeUI;

public class ListPresenter extends BasePresenter{

	private ListResumeUI ui;
	
	public ListPresenter(IContext context) {
		super(context);
		ui = new ListResumeUI();
		getData();
		ui.getBtnClose().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ui.setVisible(false);
				ui.dispose();
			}
		});
		ui.setVisible(true);
	}

	private void getData() {
		try {
			setExpensesDataTable();
			setRevenuesDataTable();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setExpensesDataTable() throws PersistenceException {
		try {
			IRepository expenses = (ExpenseRepository) CoreFactory.create("expense.repository").newInstance(this.context);
			IRepository types = (ExpenseTypeRepository)CoreFactory.create("expensetype.repository").newInstance(this.context);
			IRepository classifications = (ExpenseClassificationRepository)CoreFactory.create("expenseclassification.repository").newInstance(this.context);
			Map<ExpenseTypeVO, Map<ExpenseClassificationVO, Double>> map = 
					new ReportMovimentImpl(expenses, types, classifications).getExpenses();
			populeTableExpenses(map);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException e) {
			e.printStackTrace();
		JOptionPane.showMessageDialog(null,e.getMessage().toString());
		}
	}

	private void populeTableExpenses(Map<ExpenseTypeVO, Map<ExpenseClassificationVO, Double>> map) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Tipo");
		dtm.addColumn("Classificação");
		dtm.addColumn("Valor");
		map.size();
		
	}


	private void setRevenuesDataTable() {
		try {
			IRepository revenues = (RevenueRepository) CoreFactory.create("expense.repository").newInstance(this.context);
			populeTableRevenues(revenues);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IOException e) {
		JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}

	private void populeTableRevenues(IRepository revenues) {
		// TODO Auto-generated method stub
		
	}

}
