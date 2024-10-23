import java.util.concurrent.Semaphore;

class ResourcePool {
    private final Semaphore availableResources;

    public ResourcePool(int numResources) {
        availableResources = new Semaphore(numResources);
    }

    public void acquire() throws InterruptedException {
        availableResources.acquire();
    }

    public void release() {
        availableResources.release();
    }
}
