package org.neutrinocms.resume.service;

import org.neutrinocms.core.bo.annotation.CustomService;
import org.neutrinocms.core.service.TranslationService;
import org.neutrinocms.resume.model.Job;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope(value = "singleton")
@CustomService
public class JobService extends TranslationService<Job>{


}
