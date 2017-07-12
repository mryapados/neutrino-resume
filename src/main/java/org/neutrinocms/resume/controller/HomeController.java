package org.neutrinocms.resume.controller;

import javax.servlet.http.HttpServletRequest;

import org.neutrinocms.core.controller.AbstractController;
import org.neutrinocms.core.exception.ControllerException;
import org.neutrinocms.core.exception.ResourceNotFoundException;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = HomeController.HOME_MAPPING)
public class HomeController extends AbstractController{
	protected static final String HOME_MAPPING = "";
	protected static final String HOME_URL = "/";
	protected static final String HOME_URL_INDEX = "/index";
	protected static final String HOME_PAGE = "home";
	protected static final String ATTR_CATEGORY = "cat";

	@Autowired
	ResumeService resumeService;

	@RequestMapping(value = HOME_URL, method = RequestMethod.GET)
	public ModelAndView viewHome(Folder folder) throws ControllerException, ResourceNotFoundException {
		return baseView(HOME_PAGE, null, folder);
	}

	@RequestMapping(value = HOME_URL_INDEX, method = RequestMethod.GET)
	public ModelAndView viewHomeIndex(Folder folder) throws ResourceNotFoundException, ControllerException {
		return baseView(HOME_PAGE, null, folder);
	}
	
}
