package org.example.isaac;

import redis.clients.jedis.Jedis;

public class RedisManager {
    private static RedisManager instance = null;
    private Jedis jedis;
    private RedisManager() {
        this.jedis = new Jedis("152.228.218.211",200);
    }

    public static RedisManager getInstance() {
        if (instance == null) {
            instance = new RedisManager();
        }
        return instance;
    }

    public String get(String key){
        return jedis.get(key);
    }
    public void set(String key, String value){
        jedis.set(key,value);
    }
}
