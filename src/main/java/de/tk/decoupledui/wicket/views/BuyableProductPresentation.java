package de.tk.decoupledui.wicket.views;

import de.tk.decoupledui.wicket.PresentationModel;

class BuyableProductPresentation implements PresentationModel {
	private String product;
	private long id;

	public BuyableProductPresentation(String product, long id) {
		super();
		this.product = product;
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}