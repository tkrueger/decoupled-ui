package de.tk.decoupledui.interactions;

import de.tk.decoupledui.framework.interactions.Request;

public class ShowBasketRequest implements Request {

	private final long id;

	public ShowBasketRequest(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

}
