package de.tk.decoupledui.wicket.pages.basket;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.tk.decoupledui.wicket.views.BasketView;
import de.tk.decoupledui.wicket.views.BasketViewPresentation;

public class ShowBasket extends WebPage {

	private static final long serialVersionUID = 1L;

	
	public ShowBasket(PageParameters parameters) {
		super(parameters);
		
		// TODO make roundtrip to ShowBasket Interaction
		// shortcut for spiking purposes
		BasketViewPresentation basketViewPresentation = new BasketViewPresentation();
		basketViewPresentation.setCustomerName("Jimmy Bob Worthington");
		basketViewPresentation.setContents(Arrays.asList("product 1", "product 2"));
		
		ShowBasketPresentation showBasketPresentation = new ShowBasketPresentation();
		showBasketPresentation.setBasket(basketViewPresentation );
		
		IModel<ShowBasketPresentation> model = Model.of(showBasketPresentation);
		this.setDefaultModel(model);
	}

	public ShowBasket(IModel<ShowBasketPresentation> model) {
		super(model);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		BasketView basket = new BasketView("basket", new PropertyModel<BasketViewPresentation>(getDefaultModel(), "basket"));
		add(basket);
	}

	
}
