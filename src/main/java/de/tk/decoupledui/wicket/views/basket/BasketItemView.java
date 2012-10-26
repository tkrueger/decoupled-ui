package de.tk.decoupledui.wicket.views.basket;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import de.tk.decoupledui.wicket.views.basket.BasketItemPresentation.IBasketItemView;

public class BasketItemView extends Panel implements IBasketItemView {

	private static final long serialVersionUID = 1L;

	public BasketItemView(final String id, final IModel<BasketItemPresentation> model) {
		super(id, new CompoundPropertyModel<BasketItemPresentation>(model));
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Label("productName"));
		getPresentation().initialize(this);
	}

	public void addIcon(String iconName) {
		add(new Image("icon", iconName));
	}

	private BasketItemPresentation getPresentation() {
		return (BasketItemPresentation) getDefaultModelObject();
	}
}
