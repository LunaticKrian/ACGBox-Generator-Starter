package wiki.csbox.generator.handler.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MySQLGenerator {
    /**
     * 数据库连接配置信息
     */
    // @Value(value = "${spring.datasource.url}")
    private String url;
    // @Value(value = "${spring.datasource.username}")
    private String username;
    // @Value(value = "${spring.datasource.password}")
    private String password;
    private List<String> tables;

    /**
     * 生成Code配置信息
     */
    private String basicPackage;

    /**
     * userInfo
     */
    @Value(value = "${csbox.generator.mysql.author:---}")
    private String author;
    @Value(value = "${csbox.generator.mysql.email:---}")
    private String email;

    /**
     * 根据数据表生成MVC架构和实体类
     *
     * @return boolean 代码生成是否成功
     */
    public boolean generatorCode() {
        // 获取项目所在路径
        String path = System.getProperty("user.dir");
        // 数据库配置(DataSourceConfig)
        FastAutoGenerator.create(new DataSourceConfig.Builder(url, username, password)
                        .dbQuery(new MySqlQuery()))
                // 全局配置(GlobalConfig)
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .enableSwagger()  // 开启Swagger注解
                            .fileOverride()// 覆盖已生成文件
                            .commentDate("yyyy-MM-dd")
                            .outputDir(path + "/src/main/java")
                            .build(); // 指定输出目录
                })
                // 包配置(PackageConfig)
                .packageConfig(builder -> {
                    builder.parent(basicPackage) // 设置父包名
                            .mapper("mapper")
                            .entity("pojo")
                            .controller("controller")
                            .service("service")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, path + "/src/main/resources/mapper"))
                            .build(); // 设置mapperXml生成路径;
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder() // 实体层操作
                            .naming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略.默认下划线转驼峰命名:NamingStrategy.underline_to_camel
                            .enableTableFieldAnnotation() // 开启生成实体时生成字段注解
                            .enableRemoveIsPrefix() //开启 Boolean 类型字段移除 is 前缀
                            .enableLombok(); //开启 lombok 模型

                    builder.controllerBuilder() // controller层操作
                            .enableRestStyle(); //开启生成@RestController 控制器

                    builder.mapperBuilder()
                            .enableBaseResultMap() // 启用 BaseResultMap生成
                            .enableBaseColumnList(); //启用 BaseColumnList

                    builder.addTablePrefix("t_"); //增加过滤表前缀

                    builder.addInclude(tables)
                            .build(); // 设置需要生成的表名
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

        return true;
    }
}
