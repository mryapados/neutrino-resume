package org.neutrinocms.resume.controller;

import org.neutrinocms.core.controller.AbstractController;
import org.neutrinocms.core.exception.ControllerException;
import org.neutrinocms.core.exception.ResourceNotFoundException;
import org.neutrinocms.core.model.independant.Folder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = PortfolioController.PORTFOLIO_MAPPING)
public class PortfolioController extends AbstractController {
	protected static final String PORTFOLIO_MAPPING = "/portfolio";
	protected static final String PORTFOLIO_URL = "/portfolio";
	protected static final String ATTR_NAME = "name";

	@RequestMapping(value = PORTFOLIO_URL, method = RequestMethod.GET)
	public ModelAndView view(@ModelAttribute(ATTR_NAME) String name, Folder folder) throws ResourceNotFoundException, ControllerException {
		return baseView(name, null, folder);
	}

}
