package org.neutrinocms.resume.dao;

import org.neutrinocms.core.dao.TranslationDao;
import org.neutrinocms.resume.model.Job;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDao extends TranslationDao<Job> {

}
