package org.neutrinocms.resume.dao;

import java.util.List;

import org.neutrinocms.core.dao.TranslationDao;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.resume.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends TranslationDao<Category> {

	@Query("SELECT c FROM Category c WHERE (c.folders IS EMPTY OR :folder IN elements(c.folders)) AND c.lang =:lang AND c.inMenu = true AND (c.active = 1) ORDER BY c.ordered")
	List<Category> findAllForFolderAndLang(@Param("folder") Folder folder, @Param("lang") Lang lang);
	
}
