package com.dfbz.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.IOException;
import java.util.Properties;

/**
 * 标记为注解配置类
 */
/**
 * spring整合mybatis
 * 1.数据源
 * 2.sqlsessionFactoryBean
 * 3.扫描dao包
 * 4.开启spring组件扫描
 */

/**
 * 整合事务
 * 1.声明事务管理器
 * 2.开启事务注解支持
 * 3.在service层添加事务注解
 */
@Configuration
@MapperScan(basePackages = "com.dfbz.dao")//设置扫描mybatis接口包
@ComponentScan(basePackages = "com.dfbz.service")  //设置开启spring组件扫描
@EnableTransactionManagement//2.开启事务注解支持
public class SpringMybatis {

    //申明为spring管理的bean   <bean>
    @Bean
    public DruidDataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        Properties properties = new Properties();
        try {
            properties.load(SpringMybatis.class.getClassLoader().getResourceAsStream("mybatis.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource.configFromPropety(properties);
        return dataSource;
    }

    /**
     * 替代原mybatis的总配置文件配置
     * 别名简写  -忽略
     * 读写xml文件-忽略
     *
     * 数据源
     * 第三方插件
     * 日志设置
     * 开启驼峰命名支持
     *
     * @return
     */
    @Bean
    public SqlSessionFactoryBean getFactoryBean(DruidDataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        tk.mybatis.mapper.session.Configuration configuration = new tk.mybatis.mapper.session.Configuration();
        configuration.setLogImpl(Log4j2Impl.class);
        configuration.setMapUnderscoreToCamelCase(true);

        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(new Properties());
        sqlSessionFactoryBean.setPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }

    //事务管理器配置
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource druidDataSource){
        return new DataSourceTransactionManager(druidDataSource);
    }


}
