package de.tk.decoupledui.wicket.views;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

public class BuyProductsView extends Panel {

	public BuyProductsView(String id, IModel<BuyProducsPresentation> model) {
		super(id, model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		RepeatingView buyable = new RepeatingView("buyable");
		for (BuyableProductPresentation product : getPresentation().getProducts()) {
			BuyableItemView view = new BuyableItemView(buyable.newChildId(), Model.of(product));
		}
	}

	private BuyProducsPresentation getPresentation() {
		return (BuyProducsPresentation) getDefaultModelObject();
	}

}
