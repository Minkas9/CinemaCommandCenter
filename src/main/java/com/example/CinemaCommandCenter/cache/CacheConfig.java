package com.example.CinemaCommandCenter.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * Creates and configures the cache manager.
     */

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("screenings");
    }
}