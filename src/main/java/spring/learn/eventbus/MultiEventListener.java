package spring.learn.eventbus;

import com.google.common.eventbus.Subscribe;

class MultiEventListener {

    @Subscribe
    public void listen(OrderEvent event) {
        System.out.println("multieventListener receive msg:" + event.getMessage());
    }

    @Subscribe
    public void listen(String event) {
        System.out.println("receive msg:" + event);
    }
}