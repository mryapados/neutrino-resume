package org.neutrinocms.resume.conf;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
	
	@Resource
	private Environment environment;

	private String resumeName;

	@PostConstruct
	public void init() {
		resumeName = environment.getProperty("resume.name");
	}

	public String getResumeName() {
		return resumeName;
	}
	
	
}
