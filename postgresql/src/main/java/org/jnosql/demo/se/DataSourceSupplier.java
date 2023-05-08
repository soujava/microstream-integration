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
    @Override
    @Produces
    @ApplicationScoped
    public DataSource get() {
        Config config = ConfigProvider.getConfig();
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
        dataSource.setUser("postgres");
        dataSource.setPassword("secret");
        return dataSource;
    }
}
