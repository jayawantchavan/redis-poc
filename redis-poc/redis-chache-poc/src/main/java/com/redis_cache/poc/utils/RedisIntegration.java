/*
package com.redis_cache.poc.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;

public class RedisIntegration {
    public static void main(String[] args) throws Exception {
        // Load the certificate and private key
        KeyStore keyStore = loadKeyStore("redis.cert", "redis.key");

        // Create an SSLContext with the certificate and private key
        SSLContext sslContext = createSSLContext(keyStore);

        // Create a JedisPoolConfig with TLS enabled
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setSsl(true);
        poolConfig.setSslSocketFactory(sslContext.getSocketFactory());

        // Create a JedisPool with the TLS configuration
        JedisPool jedisPool = new JedisPool(poolConfig, "localhost", 6379, 0);

        // Get a Jedis instance from the pool
        Jedis jedis = jedisPool.getResource();

        // Perform Redis operations
        jedis.set("key", "value");
        String value = jedis.get("key");
        System.out.println("Value: " + value);

        // Close the Jedis instance
        jedis.close();
    }

    private static KeyStore loadKeyStore(String certPath, String keyPath) throws Exception {
        // Load the certificate
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        FileInputStream certStream = new FileInputStream(certPath);
        java.security.cert.Certificate cert = certificateFactory.generateCertificate(certStream);
        certStream.close();

        // Load the private key
        FileInputStream keyStream = new FileInputStream(keyPath);
        byte[] keyBytes = new byte[keyStream.available()];
        keyStream.read(keyBytes);
        keyStream.close();

        // Create a KeyStore with the certificate and private key
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);
        keyStore.setCertificateEntry("redis-cert", cert);
        keyStore.setKeyEntry("redis-key", java.security.KeyFactory.getInstance("RSA").generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(keyBytes)), "redis-password".toCharArray(), new java.security.cert.Certificate[] { cert });

        return keyStore;
    }

    private static SSLContext createSSLContext(KeyStore keyStore) throws Exception {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, tmf.getTrustManagers(), null);
        return sslContext;
    }
}*/
