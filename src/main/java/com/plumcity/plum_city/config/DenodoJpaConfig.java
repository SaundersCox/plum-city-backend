package com.plumcity.plum_city.config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
//@EnableJpaRepositories(
//    basePackages = "com.plumcity.plum_city.entity.denodo"  // Package containing Denodo repositories
//)
public class DenodoJpaConfig {

//  @Bean
//  @ConfigurationProperties(prefix = "app.denodo.datasource")
//  public DataSource denodoDataSource() {
//    return DataSourceBuilder.create().build();
//  }
//
//  @Bean
//  public JdbcTemplate denodoJdbcTemplate(DataSource denodoDataSource) {
//    return new JdbcTemplate(denodoDataSource);
//  }

  // TODO: Install the Denodo Hibernate Dialect jar

//  @Bean
//  @ConfigurationProperties(prefix = "app.denodo.datasource")
//  public DataSource denodoDataSource() {
//    DataSource data = DataSourceBuilder.create().build();
//    System.out.println("hi " + data);
//    return data;
//  }
//
//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//      EntityManagerFactoryBuilder builder) {
//    return builder
//        .dataSource(denodoDataSource())
//        .packages("com.plumcity.plum_city.entity.denodo")  // Package containing Denodo entities
//        .persistenceUnit("denodo")
//        .properties(Map.of(
//            "hibernate.dialect", "com.denodo.connect.hibernate.dialect.DenodoDialect",
//            "hibernate.hbm2ddl.auto", "none",
//            "hibernate.show_sql", "true",
//            "hibernate.format_sql", "true"
//        ))
//        .build();
//  }
//
//  @Bean
//  public PlatformTransactionManager denodoTransactionManager(
//      @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
//    return new JpaTransactionManager(entityManagerFactory);
//  }
}