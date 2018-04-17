package chapter2.dozer.FanXing;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class BaseService<M extends Serializable> {
    @Autowired
    protected BaseRepository<M> repository;  
  
    public void save(M m) {  
        repository.save(m);  
    }  
}  