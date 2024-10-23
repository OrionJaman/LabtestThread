import java.util.LinkedList;

class SimpleStack {
    private final LinkedList<Integer> stack = new LinkedList<>();
    private final int MAX_SIZE = 10;

    public synchronized void push(int item) throws InterruptedException {
        while (stack.size() >= MAX_SIZE) {
            wait();
        }
        stack.add(item);
        System.out.println("Produced: " + item);
        notify();
    }

    public synchronized int pop() throws InterruptedException {
        while (stack.isEmpty()) {
            wait();
        }
        int item = stack.removeLast();
        System.out.println("Consumed: " + item);
        notify();
        return item;
    }
}
