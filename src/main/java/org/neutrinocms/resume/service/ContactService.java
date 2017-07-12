package org.neutrinocms.resume.service;

import org.apache.log4j.Logger;
import org.neutrinocms.core.bo.annotation.BOService;
import org.neutrinocms.core.service.BaseService;
import org.neutrinocms.resume.dao.ContactDao;
import org.neutrinocms.resume.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@BOService
@Service
@Scope(value = "singleton")
public class ContactService extends BaseService<Contact>{

	private Logger logger = Logger.getLogger(ContactService.class);

	@Autowired
	private ContactDao dao;



}
