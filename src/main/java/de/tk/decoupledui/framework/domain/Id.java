package de.tk.decoupledui.framework.domain;

import java.util.UUID;

public class Id {

	private final UUID value;

	public Id() {
		this(UUID.randomUUID());
	}

	public Id(UUID value) {
		this.value = value;
	}

	public UUID value() {
		return value;
	}
}
