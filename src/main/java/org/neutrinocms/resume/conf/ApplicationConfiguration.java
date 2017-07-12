package org.neutrinocms.resume.conf;

import org.neutrinocms.core.conf.NeutrinoCoreConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.neutrinocms.resume" )
@Import({ NeutrinoCoreConfiguration.class })
public class ApplicationConfiguration {
	

}
