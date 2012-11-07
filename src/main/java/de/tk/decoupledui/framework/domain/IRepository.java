package de.tk.decoupledui.framework.domain;

import de.tk.decoupledui.framework.Boundary;

public interface IRepository extends Boundary {

	<T extends IEntity> void add(T instance);

	<T extends IEntity> T get(Class<T> type, Id id);
}
