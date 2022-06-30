package common.utli;

import java.io.IOException;
import java.util.Properties;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

/**
 * @ConfigurationProperties(prefix = "*")
   @PropertySource(value = "classpath:*.yml", factory = ImportYamlToolFactory.class)
 * @author Administrator
 *
 */
public class ImportYamlToolFactory implements PropertySourceFactory{

	@Override
	public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
		 YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
	        factory.setResources(resource.getResource());
	        factory.afterPropertiesSet();
	        Properties ymlProperties = factory.getObject();
	        String propertyName = name != null ? name : resource.getResource().getFilename();
	        return new PropertiesPropertySource(propertyName, ymlProperties);
	}

}
