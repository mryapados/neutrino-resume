package org.neutrinocms.resume.controller;

import javax.servlet.http.HttpServletRequest;

import org.neutrinocms.core.controller.AbstractController;
import org.neutrinocms.core.exception.ControllerException;
import org.neutrinocms.core.exception.ResourceNotFoundException;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = CategoryController.CATEGORY_MAPPING)
public class CategoryController extends AbstractController {
	protected static final String CATEGORY_MAPPING = "/category";
	protected static final String CATEGORY_URL = "/category";
	protected static final String ATTR_CATEGORY = "name";
		
	@Autowired
	ResumeService resumeService;
	
	@RequestMapping(value = CATEGORY_URL, method = RequestMethod.GET)
	public ModelAndView view(@ModelAttribute(ATTR_CATEGORY) String category, Folder folder, HttpServletRequest request) throws ResourceNotFoundException, ControllerException {
		return baseView(category, null, folder);
	}

}
