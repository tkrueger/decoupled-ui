package de.tk.decoupledui.wicket.views;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.tk.decoupledui.wicket.views.BuyProductsPresentation.IBuyableProductsView;

public class BuyProductsView extends Panel implements IBuyableProductsView {

	private static final long serialVersionUID = 1L;
	private RepeatingView buyableProducts;

	public BuyProductsView(String id, IModel<BuyProductsPresentation> model) {
		super(id, model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		buyableProducts = new RepeatingView("buyable");
		add(buyableProducts);

		getPresentation().initializeView(this);
	}

	@Override
	public void addProduct(BuyableProductPresentation product) {
		BuyableItemView view = new BuyableItemView(buyableProducts.newChildId(), Model.of(product));
		buyableProducts.add(view);
	}

	private BuyProductsPresentation getPresentation() {
		return (BuyProductsPresentation) getDefaultModelObject();
	}

}
