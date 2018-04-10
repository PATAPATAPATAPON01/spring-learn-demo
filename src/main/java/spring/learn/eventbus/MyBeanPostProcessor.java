package spring.learn.eventbus;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

//@Service
public class MyBeanPostProcessor implements InitializingBean,BeanPostProcessor  {


    //是在实例初始化,依赖注入之后以及自定义初始化方法,init-method指定的方法,postContruct注解指定的方法和initializingBean的afterPrpertiesSet()方法之前diaoyong
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {

        System.out.println("调用  ----postProcessBeforeInitialization");
        return bean;
    }

    @PostConstruct
    public void method() {

        System.out.println("调用  ----PostConstruct");

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {

        System.out.println("调用  ----postProcessAfterInitialization");

        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用  ----afterPropertiesSet");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }
}
