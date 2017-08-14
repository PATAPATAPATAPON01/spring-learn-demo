package spring.learn.chapter;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: za-lvjian
 * Date: 2017/8/8 17:06
 * DESC:
 */
public class JunitTets {
    @Test
    public void method1() {
        Long param1=new Long(1);
        Long param2=new Long(1);
        System.out.println(param1==param2);
    }
}
