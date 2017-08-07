package spring.learn.chapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: za-lvjian
 * Date: 2017/8/7 12:02
 * DESC:
 */
@Service
@PropertySource("classpath:/app.properties")
public class TestProperties {

    public String setProperties(@Value("${disc.title}") String title) {
        System.out.println(title);
        return "";
    }

    @Value("#{T(System).currentTimeMillis()}")
    private long currnetMils;


    @Value("#{systemProperties['disc.title']}")
    private String title;

    @Value("#{systemEnvironment['disc.title']}")
    private String envM;


    @Value("#{3.14159}")
    private float FloatNum;
    @Value("#{3.14159}")
    private double doubleNum;



    @Value("#{false }")
    private boolean flag;


    @Value("#{'hello string'}")
    private String string;

    @Override
    public String toString() {
        return "TestProperties{" +
                "currnetMils=" + currnetMils +
                ", title='" + title + '\'' +
                ", envM='" + envM + '\'' +
                ", FloatNum=" + FloatNum +
                ", doubleNum=" + doubleNum +
                ", flag=" + flag +
                ", string='" + string + '\'' +
                '}';
    }

    @Autowired
    public void mkjk(Environment environment) {
        System.out.println(environment);
    }
}
