package de.tk.decoupledui.wicket.pages.basket;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.tk.decoupledui.wicket.views.basket.BasketItemPresentation;
import de.tk.decoupledui.wicket.views.basket.BasketView;
import de.tk.decoupledui.wicket.views.basket.BasketViewPresentation;

public class ShowBasket extends WebPage {

	private static final long serialVersionUID = 1L;

	public ShowBasket(PageParameters parameters) {
		super(parameters);

		// TODO make roundtrip to ShowBasket Interaction
		// shortcut for spiking purposes
		ShowBasketPresentation showBasketPresentation = simulateBackendRoundtrip();

		IModel<ShowBasketPresentation> model = Model.of(showBasketPresentation);
		this.setDefaultModel(model);
	}

	/**
	 * Normally, we would travel to the backend, have an interaction take place
	 * if necessary and have someone build us as presentation model. Until this
	 * is implemented, we are just pretending.
	 * 
	 * @return
	 * 	{@link ShowBasketPresentation} to be used as Presenter
	 */
	private ShowBasketPresentation simulateBackendRoundtrip() {
		BasketViewPresentation basketViewPresentation = new BasketViewPresentation();
		basketViewPresentation.setCustomerName("Jimmy Bob Worthington");
		
		BasketItemPresentation basketItem1 = new BasketItemPresentation("product 1", "product_1_icon.png");
		BasketItemPresentation basketItem2 = new BasketItemPresentation("product 2", "product_2_icon.png");
		basketViewPresentation.setContents(Arrays.asList(basketItem1, basketItem2));

		ShowBasketPresentation showBasketPresentation = new ShowBasketPresentation();
		showBasketPresentation.setBasket(basketViewPresentation);
		return showBasketPresentation;
	}

	public ShowBasket(IModel<ShowBasketPresentation> model) {
		super(model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		BasketView basket = new BasketView("basket", new PropertyModel<BasketViewPresentation>(getDefaultModel(),
				"basket"));
		add(basket);
	}

}
