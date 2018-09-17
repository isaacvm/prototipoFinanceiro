package applicationprototype.main.application.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import applicationprototype.main.application.AbstractFinancialMoviment;
import applicationprototype.main.domain.model.expense.Expense;
import applicationprototype.main.domain.model.expense.ExpenseClassificationVO;
import applicationprototype.main.domain.model.expense.ExpenseTypeVO;
import applicationprototype.main.domain.model.revenue.Revenue;
import applicationprototype.main.domain.model.revenue.RevenueTypeVO;
import applicationprototype.main.domain.shared.IEntity;
import applicationprototype.main.domain.shared.IValueObject;
import applicationprototype.main.infrastructure.persistence.exception.PersistenceException;
import applicationprototype.main.infrastructure.repository.IRepository;

public class ReportMovimentImpl extends AbstractFinancialMoviment {

	private IRepository<IValueObject> classificationRepo;

	public ReportMovimentImpl(IRepository<IEntity> entityRepo, IRepository<IValueObject> typeRepo,
			IRepository<IValueObject> classifRepo) {
		super(entityRepo, typeRepo);
		this.classificationRepo = classifRepo;
	}

	public Map<RevenueTypeVO, Double> getRevenues() throws PersistenceException {
		List<IEntity> entities = this.entityRepo.getAll();
		List<IValueObject> types = this.typeRepo.getAll();
		Map<RevenueTypeVO, Double> map = new HashMap<>();
		for (IEntity e : entities) {
			Revenue r = (Revenue) e;
			if (types.contains(r.getType())) {
				Double last = map.containsKey(r.getType()) ? map.get(r.getType()) : 0;
				last += r.getValue();
				map.put((RevenueTypeVO) r.getType(), last);
			}
		}
		return map;
	}
	
	public Map<ExpenseTypeVO, Map<ExpenseClassificationVO,Double>> getExpenses() throws PersistenceException {
		List<IEntity> entities = this.entityRepo.getAll();
		List<IValueObject> types = this.typeRepo.getAll();
		List<IValueObject> classification = this.classificationRepo.getAll();
		Map<ExpenseClassificationVO, Double> mapParam = new HashMap<>();
		for (IEntity e : entities) {
			Expense r = (Expense) e;
			if (types.contains(r.getType())) {
				Double last = mapParam.containsKey(r.getType()) ? mapParam.get(r.getType()) : 0;
				last += r.getValue();
				mapParam.put((ExpenseClassificationVO) r.getClassification(), last);
			}
		}
		Map<ExpenseTypeVO,Map<ExpenseClassificationVO,Double>> map = new HashMap<>();
		List<Map<ExpenseClassificationVO, Double>> asList = Arrays.asList(mapParam);
		for (Map<ExpenseClassificationVO, Double> map2 : asList) {
			for (IValueObject t : types) {
				ExpenseTypeVO r = (ExpenseTypeVO) t;
				if(map2.containsKey(r.getClassification())){
					map.put(r, map2);
				}
			}			
		}
		return map;
	}
}
