package org.neutrinocms.resume.dao;

import java.util.List;

import org.neutrinocms.core.dao.TranslationDao;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.resume.model.Education;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDao extends TranslationDao<Education> {

	@Query("SELECT e FROM Education e WHERE (e.folders IS EMPTY OR :folder IN elements(e.folders)) AND e.lang =:lang ORDER BY e.year DESC")
	List<Education> findAllForFolderAndLang(@Param("folder") Folder folder, @Param("lang") Lang lang);

}
