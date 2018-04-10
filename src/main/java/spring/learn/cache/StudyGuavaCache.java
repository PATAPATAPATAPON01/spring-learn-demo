package spring.learn.cache;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;

public class StudyGuavaCache {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        LoadingCache<String, Object> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, Object>() {

            @Override
            public Object load(String key) throws Exception {
                Thread.sleep(2000); //休眠1s，模拟加载数据
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        });

        cache.get("key1");

        System.out.println(cache.get("ke2", () -> {

            System.out.println("in callable process");
            return "hhaha";
        }));


    }
}
