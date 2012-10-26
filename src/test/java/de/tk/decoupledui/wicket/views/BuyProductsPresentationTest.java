package de.tk.decoupledui.wicket.views;

import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.tk.decoupledui.wicket.views.BuyProductsPresentation.IBuyableProductsView;

@RunWith(MockitoJUnitRunner.class)
public class BuyProductsPresentationTest {
	@Mock
	IBuyableProductsView view;

	private BuyableProductPresentation product1 = new BuyableProductPresentation("product 1", 1L);
	private BuyableProductPresentation product2 = new BuyableProductPresentation("product 2", 2L);
	private BuyProductsPresentation presentation;

	@Before
	public void instantiateSUT() {
		presentation = new BuyProductsPresentation();
	}

	@Test
	public void itAddsAllProductsToTheView() throws Exception {
		List<BuyableProductPresentation> productList = Arrays.asList(product1, product2);
		presentation.setProducts(productList);

		presentation.initializeView(view);

		verify(view).addProduct(product1);
		verify(view).addProduct(product2);
	}
}
