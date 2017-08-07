package spring.learn.chapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: za-lvjian
 * Date: 2017/8/7 14:16
 * DESC:
 */
@Configuration
public class MethodValidatorConfig {

    @Bean
    public MethodValidationPostProcessor initBean() {
        return new MethodValidationPostProcessor();
    }
}
