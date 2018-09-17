package applicationprototype.main.ui.presenter;

import applicationprototype.main.infrastructure.persistence.IContext;

public abstract class BasePresenter {
	protected static IContext context;
		
	public BasePresenter(IContext context) {
		this.context=context;
	}

}
