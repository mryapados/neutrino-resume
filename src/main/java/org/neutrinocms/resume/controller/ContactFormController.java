package org.neutrinocms.resume.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.neutrinocms.core.controller.AbstractController;
import org.neutrinocms.core.exception.ControllerException;
import org.neutrinocms.core.exception.ResourceNotFoundException;
import org.neutrinocms.core.exception.ServiceException;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.resume.exception.FormException;
import org.neutrinocms.resume.model.Contact;
import org.neutrinocms.resume.service.ContactService;
import org.neutrinocms.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = ContactFormController.CONTACTFORM_MAPPING)
public class ContactFormController extends AbstractController {
	protected static final String CONTACTFORM_MAPPING = "/contact";
	protected static final String CONTACTFORM_SAVE_URL = "/save";

	@Autowired
	ResumeService resumeService;
	
	@Autowired
	ContactService contactService;
	
	@RequestMapping(value = CONTACTFORM_SAVE_URL, method = RequestMethod.POST)
	public @ResponseBody Contact save(@Valid @ModelAttribute Contact contact, BindingResult result, Folder folder) throws ControllerException, ResourceNotFoundException, FormException {
		try {
			if (result.hasErrors()){
				List<String> errors = new ArrayList<>();
				for (ObjectError objectError : result.getAllErrors()) {
					errors.add(objectError.getDefaultMessage());
					System.out.println(objectError.getDefaultMessage());
				}
				throw new FormException("form errors", result.getAllErrors());			
			}
			contact.setFolder(folder);
			return contactService.save(contact);
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}

}
