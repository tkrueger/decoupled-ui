package de.tk.decoupledui.framework.interactions;

import de.tk.decoupledui.framework.Boundary;

public interface Interactor<I extends Request, O extends Response> extends Boundary {

	O process(I request);
}
