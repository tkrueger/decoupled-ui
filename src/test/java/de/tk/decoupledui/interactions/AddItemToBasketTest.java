package de.tk.decoupledui.interactions;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.tk.decoupledui.domain.Basket;
import de.tk.decoupledui.domain.Product;
import de.tk.decoupledui.infrastructure.InMemoryRepository;

public class AddItemToBasketTest {

	private InMemoryRepository repository;
	private Basket basket;
	private Product product;
	private AddItemToBasket addItemToBasket;
	AddItemToBasketRequest requestModel;

	@Before
	public void setUp() {
		repository = new InMemoryRepository();
		basket = new Basket();
		product = new Product();
		repository.add(basket);
		repository.add(product);

		addItemToBasket = new AddItemToBasket(repository);
		requestModel = new AddItemToBasketRequest(basket.getId(), product.getId());
	}

	@Test
	public void itAddsTheProductToTheBasket() throws Exception {
		addItemToBasket.process(requestModel);

		assertTrue(basket.contains(product));
	}

	@Test
	public void itReturnsAnResponseModel() throws Exception {
		AddItemToBasketResponse response = addItemToBasket.process(requestModel);

		assertSame(basket, response.getBasket());
		assertSame(product, response.getAddedToBasket());
	}

}
