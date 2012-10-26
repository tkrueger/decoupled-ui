package de.tk.decoupledui.wicket.views;

import java.util.List;

public class BuyProductsPresentation {

	public interface IBuyableProductsView {
		void addProduct(BuyableProductPresentation product);
	}
	
	private List<BuyableProductPresentation> products;

	private IBuyableProductsView view;
	
	public List<BuyableProductPresentation> getProducts() {
		return products;
	}

	public void setProducts(List<BuyableProductPresentation> products) {
		this.products = products;
	}
	
	public void initializeView(IBuyableProductsView view) {
		this.view = view;
		
		addProductsToView();
	}

	private void addProductsToView() {
		for (BuyableProductPresentation product : products) {
			view.addProduct(product);
		}
	}
}
