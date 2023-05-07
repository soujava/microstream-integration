package org.jnosql.demo.se;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.interceptor.Interceptor;
import one.microstream.afs.blobstore.types.BlobStoreFileSystem;
import one.microstream.afs.redis.types.RedisConnector;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.types.StorageManager;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import java.util.function.Supplier;

@Alternative
@Priority(Interceptor.Priority.APPLICATION)
@ApplicationScoped
class RedisSupplier implements Supplier<StorageManager> {

    private static final String REDIS_PARAMS = "microstream.redis";

    @Override
    @Produces
    @ApplicationScoped
    public StorageManager get() {
        Config config = ConfigProvider.getConfig();
        String redis = config.getValue(REDIS_PARAMS, String.class);
        BlobStoreFileSystem fileSystem = BlobStoreFileSystem.New(
                RedisConnector.Caching(redis)
        );
        return EmbeddedStorage.start(fileSystem.ensureDirectoryPath("microstream_storage"));
    }

    public void close(@Disposes StorageManager manager) {
        manager.close();
    }
}