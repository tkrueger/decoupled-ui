package de.tk.decoupledui.wicket.views;

import java.io.Serializable;
import java.util.List;

public class BasketViewPresentation implements Serializable {

	private static final long serialVersionUID = 1L;
	private String customerName;
	private List<String> contents;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
		this.contents = contents;
	}

}
