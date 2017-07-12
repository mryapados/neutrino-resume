package org.neutrinocms.resume.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.neutrinocms.core.bo.annotation.CustomService;
import org.neutrinocms.core.exception.ServiceException;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.core.service.TranslationService;
import org.neutrinocms.resume.dao.ExperienceDao;
import org.neutrinocms.resume.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope(value = "singleton")
@CustomService
public class ExperienceService extends TranslationService<Experience>{
	private Logger logger = Logger.getLogger(ExperienceService.class);

	@Autowired
	private ExperienceDao dao;

	public List<Experience> findAllForFolderAndLang(Folder folder, Lang lang) throws ServiceException {
		try {
			return dao.findAllForFolderAndLang(folder, lang);
		} catch (PersistenceException e) {
			throw new ServiceException("erreur findAllAndFolderAndLang Experience", e);
		}
	}	
	

}
