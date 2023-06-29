package wiki.csbox.generator.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Krian
 * @version 1.0
 * @description: 根据实体类生成数据库表属性配置类
 * @date 2023/6/29 0029 14:59
 */
@ConfigurationProperties(prefix = "csbox.generator.entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EntityProperties {


}
