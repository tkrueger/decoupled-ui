package de.tk.decoupledui.interactions;

import de.tk.decoupledui.framework.interactions.Request;
import de.tk.decoupledui.framework.model.Id;

public final class AddItemToBasketRequest implements Request {
	private final Id basket;
	private final Id product;

	public AddItemToBasketRequest(Id basket, Id product) {
		super();
		this.basket = basket;
		this.product = product;
	}

	public Id getBasket() {
		return basket;
	}

	public Id getProduct() {
		return product;
	}

}