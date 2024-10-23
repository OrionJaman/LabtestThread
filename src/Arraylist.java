import java.util.ArrayList;
import java.util.List;

public class Arraylist {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Thread addThread = new Thread(new AddTask());
        Thread removeThread = new Thread(new RemoveTask());

        addThread.start();
        removeThread.start();

        addThread.join();
        removeThread.join();

        System.out.println("Final list: " + list);
    }

    static class AddTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                list.add(i);
                System.out.println("Added " + i);
            }
        }
    }

    static class RemoveTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (!list.isEmpty()) {
                    Integer removed = list.remove(0);
                    System.out.println("Removed " + removed);
                }
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

