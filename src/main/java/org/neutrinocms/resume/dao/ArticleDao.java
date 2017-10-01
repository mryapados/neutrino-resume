package org.neutrinocms.resume.dao;

import org.neutrinocms.core.dao.TranslationDao;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.resume.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends TranslationDao<Article> {

	@Query("SELECT e FROM Article e WHERE (e.folders IS EMPTY OR :folder IN elements(e.folders)) AND e.lang =:lang AND (e.active = 1) ORDER BY e.ordered DESC")
	Page<Article> findAllForFolderAndLang(@Param("folder") Folder folder, @Param("lang") Lang lang, Pageable pageable);
	
}
