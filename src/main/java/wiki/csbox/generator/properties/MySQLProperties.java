package wiki.csbox.generator.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author Krian
 * @version 1.0
 * @description: MySQL配置属性类，用于封装配置文件中的参数信息
 * @date 2023/6/29 0029 8:56
 */
@ConfigurationProperties(prefix = "csbox.generator.mysql")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MySQLProperties {
    /**
     * 数据库连接配置信息
     */
    private String url;
    private String username;
    private String password;
    private List<String> tables;

    /**
     * 生成Code配置信息
     */
    private String basicPackage;
    private String outputDir;

    /**
     * userInfo
     */
    private String author;

}
