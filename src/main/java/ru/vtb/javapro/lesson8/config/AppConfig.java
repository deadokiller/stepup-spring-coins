package ru.vtb.javapro.lesson8.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.vtb.javapro.lesson8.repository.UserDao;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ru.vtb.javapro.lesson8")
public class AppConfig {
    @Bean
    @Primary
    public DataSource dataSource() {
        Properties props = new Properties();
        props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
      //  props.setProperty("dataSource.driverClassName", "org.postgresql.Driver");
        props.setProperty("dataSource.user", "postgres");
        props.setProperty("dataSource.password", "postgres");
        props.setProperty("dataSource.url", "jdbc:postgresql://localhost:5432/lesson8");

        HikariConfig config = new HikariConfig(props);
        return new HikariDataSource(config);
    }

    @Bean
    public UserDao userDao() {
        return new UserDao(dataSource());
    }
}
