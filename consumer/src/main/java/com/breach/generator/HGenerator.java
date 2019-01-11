package com.breach.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings(value="all") // 消除代码重复黄线警告
public class HGenerator {

    public static void main(String[] args) {
        String packageName = "com.breach.common";
        String[] tables = {
                "consumer_auths",
                "consumer_info",
                "region_province",
                "region_city",
                "region_area",
                "consumer_education",
                "consumer_income_range"
        };
        generateByTables(packageName, tables);
    }

    /**
     * mysql
     *
     * @param packageName
     * @param tableNames
     */
    private static void generateByTables(String packageName, String... tableNames) {
        String projectPath = System.getProperty("user.dir");

        // 1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true)
                .setAuthor("shaokang")
                .setOutputDir(projectPath + "/consumer/src/main/java")
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setMapperName("I%sMapper")
                .setOpen(false);

        // 2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://HAN:3306/financial?useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setUsername("root")
                .setPassword("root");

        // 3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true) // 是否大写命名
                .setNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setSuperEntityClass("")
                .setSuperMapperClass("")
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组

        // 4.包名配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packageName)
                .setController("controller")
                .setService("service")
                .setMapper("mapper")
                .setXml("mapper.impl")
                .setEntity("entity");

        // 5.自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath +
                        "/consumer/src/main/resources/mappers/common/"
                        + tableInfo.getEntityName()
                        + "Mapper"
                        + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);

        // 6.整合执行
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setStrategy(strategyConfig)
                .setCfg(injectionConfig);
        autoGenerator.execute();

    }


    /**
     * oracle
     *
     * @param packageName
     * @param tableNames
     */
    private static void generateByOracleTables(String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "数据库地址";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.ORACLE)
                .setUrl(dbUrl)
                .setUsername("用户名")
                .setPassword("密码")
                .setDriverName("oracle.jdbc.driver.OracleDriver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
//                .setTablePrefix("表名前缀(生成的实体会省略这个前缀)")
                .setCapitalMode(true)//驼峰命名
                .setEntityLombokModel(true)//使用lombk
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setSuperEntityClass("com.example.common.SuperEntity")
                .setSuperMapperClass("com.example.common.SuperMapper")
                .setSuperControllerClass("com.example.common.SuperController")
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组

        config.setActiveRecord(false)
                .setAuthor("作者名")
                .setOutputDir("生成文件导出地址")
                .setEnableCache(false)
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                .setFileOverride(true);

        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setService("service")
                                .setServiceImpl("serviceImp")
                                .setEntity("model")
                ).execute();

    }
}