package de.tk.decoupledui.wicket.views;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class BasketView extends Panel {

	private static final long serialVersionUID = 1L;

	public BasketView(String id, IModel<BasketViewPresentation> model) {
		super(id, new CompoundPropertyModel<BasketViewPresentation>(model));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new Label("customerName"));
		RepeatingView contents = new RepeatingView("contents", new PropertyModel<List<String>>(getDefaultModel(), "contents"));
		for (String product : getPresentation().getContents()) {
			contents.add(new Label(contents.newChildId(), Model.of(product)));
		}
		add(contents);
	}
	
	BasketViewPresentation getPresentation() {
		return (BasketViewPresentation)getDefaultModelObject();
	}
}