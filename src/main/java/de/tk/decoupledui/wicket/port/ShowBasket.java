package de.tk.decoupledui.wicket.port;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.tk.decoupledui.domain.Basket;
import de.tk.decoupledui.domain.Product;
import de.tk.decoupledui.framework.domain.IRepository;
import de.tk.decoupledui.framework.domain.Id;
import de.tk.decoupledui.framework.interactions.Interactor;
import de.tk.decoupledui.interactions.ShowBasketRequest;
import de.tk.decoupledui.interactions.ShowBasketResponse;
import de.tk.decoupledui.wicket.views.basket.BasketItemPresentation;
import de.tk.decoupledui.wicket.views.basket.BasketViewPresentation;

/**
 * Port for Wicket UIs.
 * <p>
 * Converts Wicket {@link PageParameters} into {@link ShowBasketRequest}, feeds
 * that to the appropriate Interaction to execute and converts the
 * {@link ShowBasketResponse} into {@link BasketViewPresentation} on the way
 * back.
 * 
 * @author tku
 */
public class ShowBasket {

	private ProductIconFactory iconFactory = new ProductIconFactory();

	private IRepository repository;

	public ShowBasket(IRepository repository) {
		this.repository = repository;
	}

	public BasketViewPresentation showBasket(PageParameters parameters) {
		ShowBasketRequest requestModel = createRequestModelFrom(parameters);
		Interactor<ShowBasketRequest, ShowBasketResponse> interaction = newInteraction();

		ShowBasketResponse responseModel = interaction.process(requestModel);
		Basket basket = responseModel.getBasket();

		BasketViewPresentation presentation = new BasketViewPresentation();
		presentation.setContents(createItemPresentations(basket));
		return presentation;
	}

	private List<BasketItemPresentation> createItemPresentations(Basket basket) {
		List<BasketItemPresentation> itemPresentations = new LinkedList<BasketItemPresentation>();
		if (basket != null) {
			for (Id productId : basket.getProducts()) {
				Product product = repository.get(Product.class, productId);
				String imageKey = iconFactory.itemKeyFor(product);
				BasketItemPresentation itemPresentation = new BasketItemPresentation("product#" + product, imageKey);
				itemPresentations.add(itemPresentation);
			}
		}
		return itemPresentations;
	}

	private ShowBasketRequest createRequestModelFrom(PageParameters parameters) {
		String idArgument = parameters.get("id").toString();
		UUID uuid = UUID.fromString(idArgument);
		return new ShowBasketRequest(new Id(uuid));
	}

	protected Interactor<ShowBasketRequest, ShowBasketResponse> newInteraction() {
		return new de.tk.decoupledui.interactions.ShowBasket();
	}
}
