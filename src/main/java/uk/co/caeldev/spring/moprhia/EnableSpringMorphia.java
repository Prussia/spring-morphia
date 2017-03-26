package uk.co.caeldev.spring.moprhia;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ MongoConfiguration.class, MorphiaConfiguration.class, MongoClientConfiguration.class})
public @interface EnableSpringMorphia {
	
	/**
	 * Alias for the {@link #basePackages()} attribute. Allows for more concise annotation declarations e.g.:
	 * {@code @EnableJpaRepositories("org.my.pkg")} instead of {@code EnableSpringMorphia(basePackages="org.my.pkg")}.
	 */
	String[] value() default {"org.my.pkg"};

	String[] basePackages() default {"org.my.pkg"};
}
