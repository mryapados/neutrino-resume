package org.neutrinocms.resume.dao;

import java.util.List;

import org.neutrinocms.core.dao.TranslationDao;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.resume.model.Experience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceDao extends TranslationDao<Experience> {

	@Query("SELECT e FROM Experience e WHERE (e.folders IS EMPTY OR :folder IN elements(e.folders)) AND e.lang =:lang AND (e.active = 1) ORDER BY e.start DESC")
	List<Experience> findAllForFolderAndLang(@Param("folder") Folder folder, @Param("lang") Lang lang);

}
