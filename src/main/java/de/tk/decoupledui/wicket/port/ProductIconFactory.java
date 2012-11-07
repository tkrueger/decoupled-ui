package de.tk.decoupledui.wicket.port;

import de.tk.decoupledui.domain.Product;

public class ProductIconFactory {
	boolean toggle = true;
	
	public String itemKeyFor(Product product) {
		toggle = !toggle;

		String imageKey = toggle ? "product_1_icon.png" : "product_1_icon.png";
		return imageKey;
	}
}