package de.tk.decoupledui.wicket.views.basket;

import de.tk.decoupledui.wicket.PresentationModel;

public class BasketItemPresentation implements PresentationModel {

	private static final long serialVersionUID = 1L;

	public interface IBasketItemView {
		void addIcon(String iconName);
	}

	private final String productName;
	private final String imageKey;

	public BasketItemPresentation(String productName, String imageKey) {
		super();
		this.productName = productName;
		this.imageKey = imageKey;
	}

	public void initialize(IBasketItemView view) {
		view.addIcon(imageKey);
	}

	public String getProductName() {
		return productName;
	}

	public String getImageKey() {
		return imageKey;
	}

}
