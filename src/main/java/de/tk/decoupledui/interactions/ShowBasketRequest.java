package de.tk.decoupledui.interactions;

import de.tk.decoupledui.framework.domain.Id;
import de.tk.decoupledui.framework.interactions.Request;

public class ShowBasketRequest implements Request {

	private final Id id;

	public ShowBasketRequest(Id id) {
		this.id = id;
	}

	public Id getId() {
		return id;
	}

}
