package nl.jouwapplicatie.serverQueue.data;

import java.util.HashSet;
import java.util.Set;

public class QueueManager {

    private Set<Queue> queues;

    public QueueManager() {
        this.queues = new HashSet<Queue>();
    }

    public Set<Queue> getQueues() {
        return this.queues;
    }

    public Queue getQueue(final String queue) {
        return this.queues.stream().filter(queues -> queues.getQueueServer().equals(queue)).findAny().orElse(null);
    }

    public void addQueue(final String queue) {
        this.queues.add(new Queue(queue));
    }

    public void removeQueue(final String queue) {
        this.queues.remove(queue);
    }

}
