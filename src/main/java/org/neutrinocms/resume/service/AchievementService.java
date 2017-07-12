package org.neutrinocms.resume.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.neutrinocms.core.bo.annotation.CustomService;
import org.neutrinocms.core.exception.ServiceException;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.core.service.TranslationService;
import org.neutrinocms.resume.dao.AchievementDao;
import org.neutrinocms.resume.model.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CustomService
public class AchievementService extends TranslationService<Achievement>{
	private Logger logger = Logger.getLogger(EducationService.class);

	@Autowired
	private AchievementDao dao;

	public List<Achievement> findAllForFolderAndLang(Folder folder, Lang lang) throws ServiceException {
		try {
			return dao.findAllForFolderAndLang(folder, lang);
		} catch (PersistenceException e) {
			throw new ServiceException("erreur findAllForFolderAndLang Education", e);
		}
	}	
}
