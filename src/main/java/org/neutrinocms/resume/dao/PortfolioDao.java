package org.neutrinocms.resume.dao;

import org.neutrinocms.core.dao.TranslationDao;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.resume.model.Portfolio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioDao extends TranslationDao<Portfolio> {

	@Query("SELECT e FROM Portfolio e WHERE (e.folders IS EMPTY OR :folder IN elements(e.folders)) AND e.lang =:lang ORDER BY e.ordered DESC")
	Page<Portfolio> findAllForFolderAndLang(@Param("folder") Folder folder, @Param("lang") Lang lang, Pageable pageable);
	
}
