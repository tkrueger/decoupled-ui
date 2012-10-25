package de.tk.decoupledui.framework.model;

public class Entity implements IEntity {

	private final Id id;

	public Entity() {
		this(new Id());
	}

	public Entity(Id id) {
		this.id = id;
	}

	@Override
	public Id getId() {
		return id;
	}
}
