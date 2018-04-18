package mockito;

import com.google.common.base.Stopwatch;
import org.junit.Test;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 * @version :1.0.0
 * @author: term
 * @time: 2018-04-17 16:09
 * @description :
 */
public class SimpleTest {

    @Test
    public void method(){

        List list    = mock(List.class);
        System.out.println(list.add("aaa"));
        System.out.println(list);
        when(list.size()).thenReturn(100);
        System.out.println(list.size());

        when(list.toArray()).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object mock = invocation.getMock();
                invocation.getArguments();
                return null;
            }
        });
    list.toArray();


    when(list.get(anyInt())).thenReturn(1,2);

        System.out.println(list.get(1));
        System.out.println(list.get(1));
        System.out.println(list.get(1));



        doThrow(new RuntimeException("my exception")).when(list).clear();
        list.clear();

        doCallRealMethod().when(list).clear();
    }

    @Test
    public void  method2(){

        Map stringMock = mock(Map.class);

        when(stringMock.get(anyObject())).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                Object mock = invocation.getMock();
                return "lvjian";
            }
        });

        System.out.println(stringMock.get(111));
    }


    @Test
    public void  method3(){

        List list = new LinkedList();
        //监控一个真实对象
        List spy = spy(list);
//        when(spy.size()).thenReturn(100);
        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));
        System.out.println(spy.size());
        System.out.println();
        verify(spy).add("one");
        verify(spy).add("two");
    }

    @Test
    public void method5() throws InterruptedException {
        Stopwatch started = Stopwatch.createStarted();

        Thread.sleep(3000L);
        started.stop();
        System.out.println(started.elapsed(TimeUnit.SECONDS));
        started.reset();
        started.start();
        Thread.sleep(1000L);
        System.out.println(started.elapsed(TimeUnit.SECONDS));


    }
}
