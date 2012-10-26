package de.tk.decoupledui.wicket;

import org.apache.wicket.protocol.http.WebApplication;

import de.tk.decoupledui.wicket.pages.basket.ShowBasket;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see de.tk.decoupledui.wicket.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		mountPage("/basket/view", ShowBasket.class);
	}
}
