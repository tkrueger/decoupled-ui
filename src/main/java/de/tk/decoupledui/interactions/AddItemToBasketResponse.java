package de.tk.decoupledui.interactions;

import de.tk.decoupledui.framework.interactions.Response;
import de.tk.decoupledui.model.Basket;
import de.tk.decoupledui.model.Product;

// TODO this looks suspiciously like an Event
public final class AddItemToBasketResponse implements Response {
	private final Basket basket;
	private final Product addedToBasket;

	public AddItemToBasketResponse(Basket basket, Product addedToBasket) {
		super();
		this.basket = basket;
		this.addedToBasket = addedToBasket;
	}

	public Basket getBasket() {
		return basket;
	}

	public Product getAddedToBasket() {
		return addedToBasket;
	}

}