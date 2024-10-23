public class Main {
    public static void main(String[] args) {
        SimpleStack stack = new SimpleStack();

        Thread producer = new Producer(stack);
        Thread consumer = new Consumer(stack);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

