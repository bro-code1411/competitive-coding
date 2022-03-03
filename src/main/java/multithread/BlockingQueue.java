package multithread;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

    private List<Integer> queue = new LinkedList();
    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized  void enqueue (Integer a) throws InterruptedException {
        while (this.queue.size() == this.limit){
            wait();
        }
        if(this.queue.size() == 1){
            notifyAll();
        }
        if(this.queue.size()< this.limit){
            queue.add(a);
        }
    }

    public synchronized  Integer dequeue() throws InterruptedException{
        while(this.queue.size() == 0){
            wait();
        }
        if(this.queue.size()==this.limit) {
            notifyAll();
        }
        if(this.queue.size() >0){
            return this.queue.remove(0);
        }
        return null;
    }
}
