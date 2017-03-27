package uk.co.caeldev.spring.moprhia;

import com.mongodb.MongoClient;

import uk.co.caeldev.spring.morphia.SpringMorphiaApplication;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.StandardAnnotationMetadata;

@Configuration
@ConditionalOnClass({MongoSettings.class})
@ConditionalOnProperty({"morphia.entityPackage"})
public class MorphiaConfiguration {

    @Bean
    public Morphia morphia() {
    	StandardAnnotationMetadata metadata = new StandardAnnotationMetadata(SpringMorphiaApplication.class, true);
		AnnotationAttributes attributes = new AnnotationAttributes(metadata.getAnnotationAttributes(EnableSpringMorphia.class.getName()));
		String[] values = attributes.getStringArray("value");
        final Morphia morphia = new Morphia();
        morphia.mapPackage(values[0]);
        return morphia;
    }

    @Bean
    public Datastore dataStore(final Morphia morphia,
                               final MongoClient mongoClient,
                               final MongoSettings mongoSettings) {
        final Datastore datastore = morphia.createDatastore(mongoClient, mongoSettings.getDatabase());
        datastore.ensureIndexes();
        return datastore;
    }
}
