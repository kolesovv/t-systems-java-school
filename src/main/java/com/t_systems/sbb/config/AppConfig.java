package com.t_systems.sbb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.t_systems.sbb")
public class AppConfig implements WebMvcConfigurer {
    // Define Database DataSource / connection pool
    @Bean
    public DataSource comboPooledDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sbb_db?" +
                "useSSL=false&" +
                "serverTimezone=UTC&" +
                "zeroDateTimeBehavior=convertToNull");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(5);
        dataSource.setMaxPoolSize(20);
        dataSource.setMaxIdleTime(30000);

        return dataSource;
    }

    // Setup Hibernate session factory
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(comboPooledDataSource());
        sessionFactoryBean.setPackagesToScan("com.t_systems.sbb.entity");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());

        return sessionFactoryBean;
    }

    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return transactionManager;
    }
}
