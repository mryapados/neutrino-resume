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
@RequestMapping(value = ArticleController.ARTICLE_MAPPING)
public class ArticleController extends AbstractController {
	protected static final String ARTICLE_MAPPING = "/article";
	protected static final String ARTICLE_URL = "/article";
	protected static final String ATTR_NAME = "name";

	@RequestMapping(value = ARTICLE_URL, method = RequestMethod.GET)
	public ModelAndView view(@ModelAttribute(ATTR_NAME) String name, Folder folder) throws ResourceNotFoundException, ControllerException {
		return baseView(name, null, folder);
	}
	
}
