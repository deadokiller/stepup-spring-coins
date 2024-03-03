package ru.vtb.javapro.homework.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.vtb.javapro.homework.repository.UserProductDao;
import ru.vtb.javapro.homework.repository.impl.UserDaoImpl;
import ru.vtb.javapro.homework.repository.impl.UserProductDaoImpl;
import ru.vtb.javapro.homework.repository.UserDao;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ru.vtb.javapro.homework")
public class AppConfig {
    @Bean
    @Primary
    public DataSource dataSource() {
        Properties props = new Properties();
        props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
        props.setProperty("dataSource.user", "postgres");
        props.setProperty("dataSource.password", "postgres");
        props.setProperty("dataSource.url", "jdbc:postgresql://localhost:5432/lesson10");

        HikariConfig config = new HikariConfig(props);
        return new HikariDataSource(config);
    }

    @Bean
    @Primary
    public UserDao userDao() {
        return new UserDaoImpl(dataSource());
    }

    @Bean
    @Primary
    public UserProductDao userProductDao() {
        return new UserProductDaoImpl(dataSource());
    }
}
