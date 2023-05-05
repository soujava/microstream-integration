package br.org.soujava.microstream.integration.mongodb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.Produces;
import jakarta.interceptor.Interceptor;
import one.microstream.afs.blobstore.types.BlobStoreFileSystem;
import one.microstream.afs.redis.types.RedisConnector;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import one.microstream.storage.types.StorageManager;

import javax.annotation.Priority;
import java.util.function.Supplier;

@Alternative
@Priority(Interceptor.Priority.APPLICATION)
@ApplicationScoped
class CustomSupplier implements Supplier<StorageManager> {

    @Override
    @Produces
    @ApplicationScoped
    public StorageManager get() {
        String redisUri = "redis://localhost:6379/0";
        BlobStoreFileSystem fileSystem = BlobStoreFileSystem.New(
                RedisConnector.Caching(redisUri)
        );
        EmbeddedStorageManager manager = EmbeddedStorage.start(fileSystem.ensureDirectoryPath("microstream_storage"));
        return manager.start();
    }
}