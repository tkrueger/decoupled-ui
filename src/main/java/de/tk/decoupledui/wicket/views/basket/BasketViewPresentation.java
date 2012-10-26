package de.tk.decoupledui.wicket.views.basket;

import java.io.Serializable;
import java.util.List;

public class BasketViewPresentation implements Serializable {

	public interface IBasketView {
		void addContentItem(BasketItemPresentation item);
	}

	private static final long serialVersionUID = 1L;
	private String customerName;
	private List<BasketItemPresentation> contents;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<BasketItemPresentation> getContents() {
		return contents;
	}

	public void setContents(List<BasketItemPresentation> contents) {
		this.contents = contents;
	}

	public void initialize(IBasketView view) {
		addContentItems(view);
	}

	private void addContentItems(IBasketView view) {
		for (BasketItemPresentation content : contents) {
			view.addContentItem(content);
		}
	}

}
