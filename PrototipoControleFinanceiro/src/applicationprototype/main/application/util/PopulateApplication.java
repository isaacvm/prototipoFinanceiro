package applicationprototype.main.application.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import applicationprototype.main.domain.model.expense.Expense;
import applicationprototype.main.domain.model.expense.ExpenseClassificationVO;
import applicationprototype.main.domain.model.expense.ExpenseTypeVO;
import applicationprototype.main.domain.model.revenue.Revenue;
import applicationprototype.main.domain.model.revenue.RevenueTypeVO;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;

public class PopulateApplication {

	private List<RevenueTypeVO> rtypes;
	private List<ExpenseTypeVO> etype;
	private List<ExpenseClassificationVO> eclassif;
	private List<Expense> expense;
	private List<Revenue> revenue;
	private String BASEPATH = System.getProperty("user.dir")
			+ "\\src\\applicationprototype\\resource\\repositoryfiles\\";

	public PopulateApplication() {
		try {
			setRevenueTypes();
			setExpenseClassifications();
			setExpenseTypes();
			setRevenues();
			setExpenses();
		} catch (PersistenceException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setExpenses() throws PersistenceException {
		expense=new ArrayList<>();
		expense.add(new Expense(DateHelper.parseToDate("01/08/2018"), etype.get(0), eclassif.get(0), Double.parseDouble("5345.43")));
		expense.add(new Expense(DateHelper.parseToDate("10/01/2018"), etype.get(1),eclassif.get(3), Double.parseDouble("323.32")));
		String path = BASEPATH + Expense.class.getSimpleName()+".data";
		save(expense,path);
	}

	private void setRevenues() throws PersistenceException {
		revenue=new ArrayList<>();
		revenue.add(new Revenue(DateHelper.parseToDate("02/03/2018"), rtypes.get(1), 800));
		revenue.add(new Revenue(DateHelper.parseToDate("15/09/2018"), rtypes.get(3), 1400.43));
		String path = BASEPATH + Revenue.class.getSimpleName()+".data";
		save(revenue,path);
	}

	private void setRevenueTypes() throws PersistenceException, IOException {
		rtypes = new ArrayList<>();
		rtypes.add(new RevenueTypeVO("Salário"));
		rtypes.add(new RevenueTypeVO("Auxílio Alimentação"));
		rtypes.add(new RevenueTypeVO("Consultoria"));
		rtypes.add(new RevenueTypeVO("Bonificação"));
		String path = BASEPATH + RevenueTypeVO.class.getSimpleName() + ".data";
		save(rtypes, path);
	}

	private void setExpenseTypes() throws PersistenceException, IOException {
		etype = new ArrayList<>();
		etype.add(new ExpenseTypeVO(eclassif.get(0), "Fixa"));
		etype.add(new ExpenseTypeVO(eclassif.get(1), "Variável"));
		String path = BASEPATH + ExpenseTypeVO.class.getSimpleName() + ".data";
		save(etype, path);
	}

	private void setExpenseClassifications() throws PersistenceException, IOException {
		eclassif = new ArrayList<>();
		eclassif.add(new ExpenseClassificationVO("Aluguel"));
		eclassif.add(new ExpenseClassificationVO("Netflix"));
		eclassif.add(new ExpenseClassificationVO("Gasolina"));
		eclassif.add(new ExpenseClassificationVO("Supermercado"));
		String path = BASEPATH + ExpenseClassificationVO.class.getSimpleName() + ".data";
		save(eclassif, path);

	}

	private void save(List collection, String path) throws PersistenceException {
		try {
		checkFile(path);
		FileOutputStream fos;
		fos = new FileOutputStream(new File(path));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(collection);
		oos.close();
		fos.close();
		} catch (PersistenceException |  IOException e) {
			throw new PersistenceException(e);
		}
	}

	private final void checkFile(String dir) throws PersistenceException, IOException {
		File file = new File(dir);
		if (!file.exists()) {
				file.createNewFile();
		}

	}
}
