package de.tk.decoupledui.wicket.views;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class BuyableItemView extends Panel {

	private static final long serialVersionUID = 1L;

	public BuyableItemView(String id, IModel<BuyableProductPresentation> model) {
		super(id, model);
	}
	
}
