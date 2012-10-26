package de.tk.decoupledui.wicket.pages.basket;

import de.tk.decoupledui.wicket.PresentationModel;
import de.tk.decoupledui.wicket.views.basket.BasketViewPresentation;

public class ShowBasketPresentation implements PresentationModel {

	private static final long serialVersionUID = 1L;

	private BasketViewPresentation basket;

	public BasketViewPresentation getBasket() {
		return basket;
	}

	public void setBasket(BasketViewPresentation basket) {
		this.basket = basket;
	}

}
