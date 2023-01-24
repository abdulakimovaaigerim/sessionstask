package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.models.Laptop;

import java.util.Properties;

public class DatabaseConnection {
    public static SessionFactory createSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/sessions");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgres");

        properties.put(Environment.HBM2DDL_AUTO, "create");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Laptop.class);

        return configuration.buildSessionFactory();
    }

    public static EntityManagerFactory createEntityManagerFactory() {
        final SessionFactory sessionFactory1 = createSessionFactory();
        return sessionFactory1.unwrap(EntityManagerFactory.class);


    }
}
