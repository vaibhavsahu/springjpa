package com.vaibhav.example.springjpa.Config;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
public class HibernateConfig {
//
//    @Bean
//    public DataSource dataSource(){
//        DataSource dataSource = new BasicDataSource();
//        ((BasicDataSource) dataSource).setDriverClassName("org.h2.Driver");
//        ((BasicDataSource) dataSource).setUrl("jdbc:h2:mem:testdb");
//        ((BasicDataSource) dataSource).setUsername( "sa" );
//        ((BasicDataSource) dataSource).setPassword( "password" );
//        return dataSource;
//    }
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory(){
//        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
//        localSessionFactoryBean.setPackagesToScan("com.vaibhav.example.springjpa");
//        localSessionFactoryBean.setDataSource(dataSource());
//        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
//        return localSessionFactoryBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager
//                = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().
//                getObject());
//        return transactionManager;
//    }
//
//    Properties hibernateProperties(){
//        Properties properties = new Properties();
//       // properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        return properties;
//    }
}
