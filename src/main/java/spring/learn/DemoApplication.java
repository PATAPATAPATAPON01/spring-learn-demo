package spring.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import spring.learn.chapter.TestBean;
import spring.learn.chapter.TestProperties;
import spring.learn.chapter.UserService;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        System.setProperty("server.port", "0");
        System.setProperty("disc.title", "this is my title");

        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//        UserService service = context.getBean(UserService.class);
//        try {
//            service.getUser("");
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("========================");

        //springEl
//        TestProperties testProperties = context.getBean(TestProperties.class);
//        System.out.println(testProperties);

        //springEl invoke bean
        TestBean testBean = context.getBean(TestBean.class);
        System.out.println(testBean);
    }
}
