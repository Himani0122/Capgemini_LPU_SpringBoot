
package com.prac.product_category_two_entity_case_study;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
public class ProductCategoryTwoEntityCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCategoryTwoEntityCaseStudyApplication.class, args);
	}
	
	@Bean
	public OpenAPI getopenApi() {
		return new OpenAPI();
	}

}
