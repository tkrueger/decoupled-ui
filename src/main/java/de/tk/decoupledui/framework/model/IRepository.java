package de.tk.decoupledui.framework.model;

public interface IRepository {

	<T extends IEntity> void add(T instance);

	<T extends IEntity> T get(Class<T> type, Id id);
}
