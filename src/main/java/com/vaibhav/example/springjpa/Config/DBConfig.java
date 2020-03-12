package com.vaibhav.example.springjpa.Config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@Configuration
@EnableTransactionManagement
@EnableMBeanExport(registration= RegistrationPolicy.IGNORE_EXISTING)
public class DBConfig {

    @Bean
    public DataSource dataSource(final DataSourceProperties dataSourceProperties){
        final HikariDataSource dataSource = (HikariDataSource) dataSourceProperties.initializeDataSourceBuilder()
                .username("sa")
                .password("")
                .build();

        dataSource.setMaximumPoolSize(10);
        dataSource.setRegisterMbeans(true);

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager
    transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new
                JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor
    exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return properties;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter)
    {
        LocalContainerEntityManagerFactoryBean emf
                = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan(new String[] { "com.vaibhav.example.springjpa" });
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.afterPropertiesSet();
        return emf.getObject();
    }
}
