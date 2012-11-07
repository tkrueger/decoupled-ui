package de.tk.decoupledui.interactions;

import de.tk.decoupledui.domain.Basket;
import de.tk.decoupledui.framework.interactions.Response;

public class ShowBasketResponse implements Response {

	private final Basket basket;

	public ShowBasketResponse(Basket basket) {
		this.basket = basket;
	}

	public Basket getBasket() {
		return basket;
	}

}
