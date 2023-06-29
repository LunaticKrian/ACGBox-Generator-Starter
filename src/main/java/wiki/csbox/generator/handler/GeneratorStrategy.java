package wiki.csbox.generator.handler;

/**
 * @author Krian
 * @version 1.0
 * @description: 代码生成策略
 * @date 2023/6/29 0029 9:23
 */
public interface GeneratorStrategy {

    /**
     * 根据数据库字段生成代码
     *
     * @return boolean 代码生成是否成功
     */
    boolean generatorCode();

    /**
     * 根据给定配置项生成数据库
     *
     * @return boolean 数据库是否生成成功
     */
    boolean generatorDataBase();

    /**
     * 根据实体类生成数据表
     *
     * @return boolean 数据表生成是否成功
     */
    boolean generatorDataTable();

}
