package de.tk.decoupledui.model;

import java.util.LinkedList;
import java.util.List;

import de.tk.decoupledui.framework.model.Entity;
import de.tk.decoupledui.framework.model.Id;

public class Basket extends Entity {

	private List<Product> products = new LinkedList<Product>();

	public Basket() {
		super();
	}

	public Basket(Id id) {
		super(id);
	}

	public boolean isEmpty() {
		return products.isEmpty();
	}

	public void add(Product product) {
		products.add(product);
	}

	public boolean contains(Product product) {
		return products.contains(product);
	}

	public int getSize() {
		return products.size();
	}

}
