package de.tk.decoupledui.framework.interactions;

public interface Interactor<I extends Request, O extends Response> {

	O process(I request);
}
