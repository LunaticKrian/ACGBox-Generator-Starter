package wiki.csbox.generator.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wiki.csbox.generator.handler.generator.EntityGenerator;
import wiki.csbox.generator.properties.EntityProperties;

/**
 * @author Krian
 * @version 1.0
 * @description: 自动配置类，用于自动配置EntityProperties
 * @date 2023/6/29 0029 15:11
 */
@Configuration
@EnableConfigurationProperties({EntityProperties.class})
public class EntityGeneratorAutoConfiguration {

    private final EntityProperties properties;

    public EntityGeneratorAutoConfiguration(EntityProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public EntityGenerator entityGenerator() {
        EntityGenerator entityGenerator = new EntityGenerator();
        entityGenerator.setBasicPackage(properties.getBasicPackage());
        return entityGenerator;
    }

}
