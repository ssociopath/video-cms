package org.video.cms.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author bobo
 */
@SpringBootApplication(scanBasePackages = "org.video.cms")
@EnableJpaRepositories(basePackages = "org.video.cms.data.repository.concrete")
@EntityScan(basePackages="org.video.cms.data.entity")
public class CmsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsApiApplication.class, args);
	}

}
