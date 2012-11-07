package de.tk.decoupledui.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.tk.decoupledui.framework.domain.Entity;
import de.tk.decoupledui.framework.domain.Id;

public class Basket extends Entity {

	private List<Id> products = new LinkedList<Id>();

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
		products.add(product.getId());
	}

	public boolean contains(Product product) {
		return products.contains(product.getId());
	}

	public int getSize() {
		return products.size();
	}
	
	public List<Id> getProducts() {
		return Collections.unmodifiableList(products);
	}

}
