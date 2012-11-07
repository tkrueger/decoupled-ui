package de.tk.decoupledui.wicket.port;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.junit.Before;
import org.junit.Test;

import de.tk.decoupledui.domain.Basket;
import de.tk.decoupledui.domain.Product;
import de.tk.decoupledui.framework.domain.IRepository;
import de.tk.decoupledui.framework.interactions.Interactor;
import de.tk.decoupledui.infrastructure.InMemoryRepository;
import de.tk.decoupledui.interactions.ShowBasketRequest;
import de.tk.decoupledui.interactions.ShowBasketResponse;
import de.tk.decoupledui.wicket.views.basket.BasketViewPresentation;

public class ShowBasketTest {

	static class TestableShowBasket extends ShowBasket {

		// the response we returned for the request
		ShowBasketResponse givenResponse;

		// the request given to the interaction to process
		ShowBasketRequest processedRequest;

		private ShowBasketResponse responseToGive;

		public TestableShowBasket(IRepository repository) {
			super(repository);
		}

		public void prepareResponse(ShowBasketResponse responseToGive) {
			this.responseToGive = responseToGive;
		}

		public Interactor<ShowBasketRequest, ShowBasketResponse> newInteraction() {
			return new Interactor<ShowBasketRequest, ShowBasketResponse>() {
				@Override
				public ShowBasketResponse process(ShowBasketRequest requestToProcess) {
					processedRequest = requestToProcess;
					givenResponse = responseToGive;
					return givenResponse;
				}
			};
		}
	}

	TestableShowBasket sut;
	private BasketViewPresentation presentation;
	IRepository repository;

	@Before
	public void setUp() {
		repository = new InMemoryRepository();
		Basket basket = new Basket();
		Product product = new Product();
		basket.add(product);
		repository.add(basket);
		repository.add(product);

		sut = new TestableShowBasket(repository);
		sut.prepareResponse(new ShowBasketResponse(basket));

		PageParameters pageParameters = new PageParameters();
		pageParameters.add("id", basket.getId().value());

		presentation = sut.showBasket(pageParameters);
	}

	@Test
	public void itConvertsThePageParametersToARequestModel() throws Exception {
		assertThat(sut.processedRequest, isA(ShowBasketRequest.class));
	}

	@Test
	public void itConvertsTheResponseModelIntoAPresentation() throws Exception {
		assertThat(presentation, isA(BasketViewPresentation.class));
	}

	@Test
	public void itContainsPresentationsForProductsInBasket() throws Exception {
		assertThat(presentation.getContents(), hasSize(1));
	}
}
