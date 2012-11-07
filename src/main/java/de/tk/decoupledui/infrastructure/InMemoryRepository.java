package de.tk.decoupledui.infrastructure;

import java.util.HashMap;

import com.google.common.collect.Maps;

import de.tk.decoupledui.framework.domain.IEntity;
import de.tk.decoupledui.framework.domain.IRepository;
import de.tk.decoupledui.framework.domain.Id;

public class InMemoryRepository implements IRepository {

	private final HashMap<Id, IEntity> storage = Maps.newHashMap();

	@Override
	public <T extends IEntity> void add(T instance) {
		storage.put(instance.getId(), instance);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IEntity> T get(Class<T> type, Id id) {
		return (T) storage.get(id);
	}

}
