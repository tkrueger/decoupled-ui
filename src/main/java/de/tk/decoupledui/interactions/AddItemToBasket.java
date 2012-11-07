package de.tk.decoupledui.interactions;

import de.tk.decoupledui.domain.Basket;
import de.tk.decoupledui.domain.Product;
import de.tk.decoupledui.framework.domain.IRepository;
import de.tk.decoupledui.framework.interactions.Interactor;

public class AddItemToBasket implements Interactor<AddItemToBasketRequest, AddItemToBasketResponse> {

	private final IRepository repository;

	public AddItemToBasket(IRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public AddItemToBasketResponse process(AddItemToBasketRequest request) {
		final Basket basket = repository.get(Basket.class, request.getBasket());
		final Product product = repository.get(Product.class, request.getProduct());

		basket.add(product);

		return new AddItemToBasketResponse(basket, product);
	}

}
