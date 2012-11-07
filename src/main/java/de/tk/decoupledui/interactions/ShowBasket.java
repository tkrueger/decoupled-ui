package de.tk.decoupledui.interactions;

import de.tk.decoupledui.domain.Basket;
import de.tk.decoupledui.framework.interactions.Interactor;

public class ShowBasket implements Interactor<ShowBasketRequest, ShowBasketResponse> {

	@Override
	public ShowBasketResponse process(ShowBasketRequest request) {
		return new ShowBasketResponse(new Basket());
	}

	
}
