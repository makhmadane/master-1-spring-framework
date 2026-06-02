package config;

import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource dataSource() {

        BasicDataSource ds = new BasicDataSource();

        // PostgreSQL Driver
        ds.setDriverClassName("org.postgresql.Driver");

        // URL PostgreSQL
        ds.setUrl("jdbc:postgresql://localhost:5432/test");

        ds.setUsername("postgres");
        ds.setPassword("root"); // adapte selon ton installation

        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean em =
                new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(dataSource());

        // package des entités
        em.setPackagesToScan("com.example.master.entity");

        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();

        em.setJpaVendorAdapter(vendorAdapter);

        // options Hibernate (important pour PostgreSQL)
        java.util.Properties props = new java.util.Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "true");

        em.setJpaProperties(props);

        return em;
    }
}