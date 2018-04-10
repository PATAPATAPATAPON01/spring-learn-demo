package spring.learn.eventbus;

import com.google.common.eventbus.EventBus;

public class MT {

    public static void main(String[] args) {


        EventBus bus = new EventBus("ricky");


        bus.register(new MultiEventListener());

        bus.register(new HelloEventListener());


        bus.post(new OrderEvent("hello"));
        bus.post(new OrderEvent("world"));

//        bus.post("lvjian");
    }
}
