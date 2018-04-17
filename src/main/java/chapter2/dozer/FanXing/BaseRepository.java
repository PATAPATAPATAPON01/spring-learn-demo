package chapter2.dozer.FanXing;

import java.io.Serializable;

public abstract class BaseRepository<M extends Serializable> {
    public void save(M m) {  
        System.out.println("=====repository save:" + m);  
    }  
}  
