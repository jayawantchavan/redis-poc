package com.redis_cache.poc.core;

import com.redis_cache.poc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.DefaultClientResources;
import javax.net.ssl.SSLContext;
import java.security.SecureRandom;
import java.time.Duration;

@Service
public class ProductService {


   //@Cacheable(value="product", key="#id")
    public Product getProduct(long id) {

          connect();
       return getDataPerkey(id);
    }


    public void connect() {
        RedisURI redisUri = RedisURI.builder()
                .withHost("localhost")
                .withPort(6380)  // Specify your Redis TLS port
                .withSsl(true)  // Enable SSL
               // .withSslVerifyPeer(true)  // Optional: verify peer certificates
                .withPassword("Test@123")  // Set password if necessary
                .withTimeout(Duration.ofSeconds(120))  // Optional timeout
                .build();

        // Create client resources (optional, can be customized)
        ClientResources clientResources = DefaultClientResources.create();

        // Create RedisClient
        RedisClient redisClient = RedisClient.create(clientResources, redisUri);

        // Open connection
        try (StatefulRedisConnection<String, String> connection = redisClient.connect()) {
            RedisCommands<String, String> syncCommands = connection.sync();

            // Test the connection with a PING
            String response = syncCommands.ping();
            System.out.println("Connected to Redis with TLS. PING response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the client
            redisClient.shutdown();
        }
    }


    public Product getDataPerkey(long id) {
       System.out.print("Inside adapter");
        return new Product(1, "ABC", 2, 3);
    }

}
