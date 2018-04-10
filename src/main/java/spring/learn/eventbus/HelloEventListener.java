package spring.learn.eventbus;

import com.google.common.eventbus.Subscribe;

class HelloEventListener {

    @Subscribe
    public void listen(OrderEvent event) {
        System.out.println("HelloEventListener receive msg:" + event.getMessage());
    }

    @Subscribe
    public void listen(String event) {

        System.out.println("string event" + event);
    }
}