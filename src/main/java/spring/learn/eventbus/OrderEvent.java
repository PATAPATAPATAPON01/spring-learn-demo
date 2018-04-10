package spring.learn.eventbus;

class OrderEvent {
    private String message;

    public OrderEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}