package de.tk.decoupledui.wicket.views.basket;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.tk.decoupledui.wicket.views.basket.BasketViewPresentation.IBasketView;

public class BasketView extends Panel implements IBasketView {

	private static final long serialVersionUID = 1L;
	private RepeatingView contents;

	public BasketView(String id, IModel<BasketViewPresentation> model) {
		super(id, new CompoundPropertyModel<BasketViewPresentation>(model));
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Label("customerName"));
		contents = new RepeatingView("contents");
		add(contents);

		getPresentation().initialize(this);
	}

	@Override
	public void addContentItem(BasketItemPresentation item) {
		contents.add(new BasketItemView(contents.newChildId(), Model.of(item)));
	}

	BasketViewPresentation getPresentation() {
		return (BasketViewPresentation) getDefaultModelObject();
	}
}