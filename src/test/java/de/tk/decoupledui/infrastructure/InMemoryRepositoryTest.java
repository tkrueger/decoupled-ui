package de.tk.decoupledui.infrastructure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.tk.decoupledui.framework.model.Entity;
import de.tk.decoupledui.framework.model.Id;



public class InMemoryRepositoryTest {

	class SomeEntity extends Entity {
	}
	
	InMemoryRepository repository;
	
	@Before
	public void setUp() {
		repository = new InMemoryRepository();
	}
	
	@Test
	public void willGiveNullForObjectsNotInThere() throws Exception {
		assertNull(repository.get(SomeEntity.class, new Id()));
	}
	
	@Test
	public void canAddEntitiesToIt() throws Exception {
		SomeEntity entity = new SomeEntity();
		repository.add(entity);
		SomeEntity receivEdentity = repository.get(SomeEntity.class, entity.getId());
		assertSame(entity, receivEdentity);
	}
	
}
