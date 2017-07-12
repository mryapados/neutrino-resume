package org.neutrinocms.resume.dao;

import org.neutrinocms.core.dao.TranslationDao;
import org.neutrinocms.resume.model.Resume;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeDao extends TranslationDao<Resume> {

}
