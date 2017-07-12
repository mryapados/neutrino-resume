package org.neutrinocms.resume.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.neutrinocms.core.bo.annotation.BOService;
import org.neutrinocms.core.exception.ServiceException;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.core.service.TranslationService;
import org.neutrinocms.resume.dao.CategoryDao;
import org.neutrinocms.resume.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@BOService
@Service
@Scope(value = "singleton")
public class CategoryService extends TranslationService<Category>{

	private Logger logger = Logger.getLogger(CategoryService.class);

	@Autowired
	private CategoryDao dao;

	public List<Category> findAllForFolderAndLang(Folder folder, Lang lang) throws ServiceException {
		try {
			return dao.findAllForFolderAndLang(folder, lang);
		} catch (PersistenceException e) {
			throw new ServiceException("erreur findAllForFolderAndLang Category", e);
		}
	}	
	
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}




}
