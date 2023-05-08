package org.jnosql.demo.se;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.util.function.Supplier;

@ApplicationScoped
class DataSourceSupplier implements Supplier<DataSource> {

    private static final String JDBC = "microstream.postgresql.jdbc=jdbc:postgresql";
    private static final String USER = "microstream.postgresql.user";
    private static final String PASSWORD = "microstream.postgresql.password";

    @Override
    @Produces
    @ApplicationScoped
    public DataSource get() {
        Config config = ConfigProvider.getConfig();
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(config.getValue(JDBC, String.class));
        dataSource.setUser(config.getValue(USER, String.class));
        dataSource.setPassword(config.getValue(PASSWORD, String.class));
        return dataSource;
    }
}
