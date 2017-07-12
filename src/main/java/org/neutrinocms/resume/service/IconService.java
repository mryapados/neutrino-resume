package org.neutrinocms.resume.service;

import org.neutrinocms.core.bo.annotation.CustomService;
import org.neutrinocms.core.service.NoTranslationService;
import org.neutrinocms.resume.model.Icon;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton")
@CustomService
public class IconService extends NoTranslationService<Icon>{

	
}
