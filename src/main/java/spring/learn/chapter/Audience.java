package spring.learn.chapter;


import org.aspectj.lang.annotation.*;

//@Aspect
public class Audience {

    @Pointcut("execution(* com.springinaction.aop.Performer.perform(..))")
    public void performance() {} // 定义切点

    @Before("performance()")
    public void takeSeats() {
        // 节目开始之前
        System.out.println("演出前——观众开始入座");
    }

    @Before("performance()")
    public void turnOffCellPhones() {
        // 节目开始之前
        System.out.println("演出前——观众关机或静音");
    }

    @AfterReturning("performance()")
    public void applaud() {
        // 节目成功结束之后
        System.out.println("演出很成功——观众鼓掌：啪啪啪");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        // 节目表演失败之后
        System.out.println("节目演出很失败——切！一点都不好看，我们要求退钱！");
    }
}