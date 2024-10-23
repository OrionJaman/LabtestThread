class Worker extends Thread {
    private final ResourcePool pool;

    public Worker(ResourcePool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            pool.acquire();
            System.out.println(Thread.currentThread().getName() + " acquired a resource.");
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + " releasing a resource.");
            pool.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

 public class Test {
    public static void main(String[] args) {
        int numResources = 5;
        ResourcePool pool = new ResourcePool(numResources);
        int numThreads = 20;

        for (int i = 0; i < numThreads; i++) {
            new Worker(pool).start();
        }
    }
}
