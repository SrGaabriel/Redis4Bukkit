package com.gabriel.redis4bukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

public class RedisServer {

    private final String host, username, password;
    private final int timeout;
    private final Integer port;
    private final JedisPoolConfig config;

    private JedisPool jedisPool;

    public RedisServer(String host, Integer port) {
        this(host, port, new JedisPoolConfig());
    }

    public RedisServer(String host, Integer port, JedisPoolConfig config) {
        this(host, port, null, config);
    }

    public RedisServer(String host, Integer port, String username, JedisPoolConfig config) {
        this(host, port, username, null, config);
    }

    public RedisServer(String host, Integer port, String username, String password, JedisPoolConfig config) {
        this(host, port, Protocol.DEFAULT_TIMEOUT, username, password, config);
    }

    public RedisServer(String host, Integer port, int timeout, String username, String password, JedisPoolConfig config) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
        this.username = username;
        this.password = password;
        this.config = config;
    }

    public void connect() {
        jedisPool = new JedisPool(config, host, port);
    }

    public Jedis getResource() {
        return getJedisPool().getResource();
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }
}