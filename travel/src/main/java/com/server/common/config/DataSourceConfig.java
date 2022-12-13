package com.server.common.config;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.server.common.dao")
@EnableTransactionManagement
@RequiredArgsConstructor
public class DataSourceConfig
{
    private static final String MYBATIS_CONFIG_FILE_PATH = "mybatis-config.xml";

//    @Bean
//    public BasicDataSource dataSource()
//    {
//        BasicDataSource dataSource = new BasicDataSource();
//
//
//
//        dataSource.setValidationQuery("select 1");
//        dataSource.setTestOnBorrow(true);
//        dataSource.setInitialSize(10);
//        dataSource.setMaxIdle(50);
//        dataSource.setMinIdle(10);
//        dataSource.setMaxActive(2048);
//        dataSource.setMaxWait(1000);
//
//        return dataSource;
//    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception
    {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG_FILE_PATH));
        sqlSessionFactoryBean.setTypeAliasesPackage("com/server/common/model");
        // sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com.server.common.dao/mybatis/mapper/*.xml"));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/server/common/dao/mybatis/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception
    {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}