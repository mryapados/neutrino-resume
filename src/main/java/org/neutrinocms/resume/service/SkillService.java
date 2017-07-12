package org.neutrinocms.resume.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.neutrinocms.core.bo.annotation.CustomService;
import org.neutrinocms.core.exception.ServiceException;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.core.service.TranslationService;
import org.neutrinocms.resume.dao.SkillDao;
import org.neutrinocms.resume.model.Skill;
import org.neutrinocms.resume.model.Skill.SkillKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@CustomService
public class SkillService extends TranslationService<Skill>{
	private Logger logger = Logger.getLogger(SkillService.class);

	@Autowired
	private SkillDao dao;

	public List<Skill> findAllKindForFolderAndLang(SkillKind kind, Folder folder, Lang lang) throws ServiceException {
		try {
			return dao.findAllKindForFolderAndLang(kind, folder, lang);
		} catch (PersistenceException e) {
			throw new ServiceException("erreur findAllKindForReumeAdFolderAndLang Skill", e);
		}
	}

}
