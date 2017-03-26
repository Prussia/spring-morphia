package uk.co.caeldev.spring.morphia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.StandardAnnotationMetadata;

import uk.co.caeldev.spring.moprhia.EnableSpringMorphia;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableSpringMorphia(value = "uk.co.caeldev.spring.morphia")
public class SpringMorphiaApplication {
    public static void main(String[] args) {
    	 
					
		printBasepackage();
    	
        SpringApplication.run(SpringMorphiaApplication.class, args);
    }

	private static void printBasepackage() {
		StandardAnnotationMetadata metadata = new StandardAnnotationMetadata(SpringMorphiaApplication.class, true);
		AnnotationAttributes attributes = new AnnotationAttributes(metadata.getAnnotationAttributes(EnableSpringMorphia.class.getName()));
		System.out.println(attributes);
		String[] values = attributes.getStringArray("value");
		System.out.println(values[0]);
	}
}