package wiki.csbox.generator.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wiki.csbox.generator.handler.generator.MySQLGenerator;
import wiki.csbox.generator.properties.MySQLProperties;

/**
 * @author Krian
 * @version 1.0
 * @description: 自动配置类，用于自定配置MySQLProperties类
 * @date 2023/6/29 0029 9:08
 */
@Configuration
@EnableConfigurationProperties({MySQLProperties.class})
public class MySQLGeneratorAutoConfiguration {

    /**
     * MySQL 属性配置类
     */
    private final MySQLProperties properties;

    public MySQLGeneratorAutoConfiguration(MySQLProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public MySQLGenerator mySQLGenerator() {
        MySQLGenerator mySQLGenerator = new MySQLGenerator();
        // 设置属性值：
        mySQLGenerator
                // --- 数据库连接信息 ---
                .setUrl(properties.getUrl())
                .setUsername(properties.getUsername())
                .setPassword(properties.getPassword())
                .setTables(properties.getTables())
                // --- 生成Code配置信息 ---
                .setBasicPackage(properties.getBasicPackage())
                // --- 生成用户信息 ---
                .setAuthor(properties.getAuthor());

        return mySQLGenerator;
    }
}
