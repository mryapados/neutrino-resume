package org.neutrinocms.resume.dao;

import java.util.List;

import org.neutrinocms.core.dao.TranslationDao;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.resume.model.Achievement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementDao extends TranslationDao<Achievement> {
	@Query("SELECT e FROM Achievement e WHERE (e.folders IS EMPTY OR :folder IN elements(e.folders)) AND e.lang =:lang ORDER BY e.ordered DESC")
	List<Achievement> findAllForFolderAndLang(@Param("folder") Folder folder, @Param("lang") Lang lang);

}
