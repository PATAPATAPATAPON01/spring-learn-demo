package spring.learn.eventbus;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service("sssssss")
public class TestBean implements InitializingBean {
    String name;  
   
    public String getName() {  
        return name;  
    }  
   
    public void setName(String name) {  
        this.name = name;  
    }  
   
    public void init() {  
        System.out.println("init-method is called");  
        System.out.println("******************************");  
    }  
   
    @Override 
    public void afterPropertiesSet() throws Exception {  
        System.out.println("******************************");  
        System.out.println("afterPropertiesSet is called");  
        System.out.println("******************************");  
    }  
}