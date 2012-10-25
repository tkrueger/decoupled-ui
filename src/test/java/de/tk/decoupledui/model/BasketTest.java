package de.tk.decoupledui.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasketTest {

	@Test
	public void aBasketIsInitiallyEmpty() throws Exception {
		assertTrue(new Basket().isEmpty());
	}

	@Test
	public void iCanPutProductsInTheBasket() throws Exception {
		Basket basket = new Basket();
		Product product = new Product();
		basket.add(product);
		assertTrue(basket.contains(product));
	}

	@Test
	public void whenIPutAProductInTheBasketItIsNotEmptyAnymore()
			throws Exception {
		Basket basket = new Basket();
		basket.add(new Product());
		assertFalse(basket.isEmpty());
	}

	@Test
	public void basketCanGiveTheNumberOfProductsInIt() throws Exception {
		Basket basket = new Basket();
		basket.add(new Product());
		assertEquals(1, basket.getSize());
	}
}
