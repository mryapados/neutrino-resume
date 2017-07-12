package org.neutrinocms.resume.dao;

import java.util.List;

import org.neutrinocms.core.dao.TranslationDao;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.resume.model.Skill;
import org.neutrinocms.resume.model.Skill.SkillKind;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillDao extends TranslationDao<Skill> {

	@Query("SELECT s FROM Skill s WHERE (s.folders IS EMPTY OR :folder IN elements(s.folders)) AND s.lang =:lang AND s.kind =:kind ORDER BY s.ordered")
	List<Skill> findAllKindForFolderAndLang(@Param("kind") SkillKind kind, @Param("folder") Folder folder, @Param("lang") Lang lang);
	
	
}
