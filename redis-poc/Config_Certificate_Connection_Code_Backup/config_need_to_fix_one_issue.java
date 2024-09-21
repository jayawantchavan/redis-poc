import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.DefaultClientResources;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public RedisURI redisUri() {
        return RedisURI.builder()
                .withHost("localhost")
                .withPort(6380) // Specify your Redis TLS port
                .withSsl(true) // Enable SSL
                .withPassword("Test@123") // Set password if necessary
                .withTimeout(Duration.ofSeconds(120)) // Optional timeout
                .build();
    }

    @Bean
    public ClientResources clientResources() {
        return DefaultClientResources.create(); // Create client resources (optional)
    }

    @Bean
    public RedisClient redisClient(ClientResources clientResources, RedisURI redisUri) {
        return RedisClient.create(clientResources, redisUri);
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory(RedisClient redisClient) {
        return new LettuceConnectionFactory(redisClient);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}