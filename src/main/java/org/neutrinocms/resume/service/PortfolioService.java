package org.neutrinocms.resume.service;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.neutrinocms.core.bo.annotation.BOService;
import org.neutrinocms.core.exception.ServiceException;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.core.service.TranslationService;
import org.neutrinocms.resume.dao.PortfolioDao;
import org.neutrinocms.resume.model.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@BOService
@Service
@Scope(value = "singleton")
public class PortfolioService extends TranslationService<Portfolio>{

	private Logger logger = Logger.getLogger(PortfolioService.class);

	@Autowired
	private PortfolioDao dao;

	public Page<Portfolio> findAllForFolderAndLang(Folder folder, Lang lang, Pageable pageable) throws ServiceException {
		try {
			return dao.findAllForFolderAndLang(folder, lang, pageable);
		} catch (PersistenceException e) {
			throw new ServiceException("erreur findAllForResumeAndFolderAndLang Portfolio", e);
		}
	}	
	
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}




}
