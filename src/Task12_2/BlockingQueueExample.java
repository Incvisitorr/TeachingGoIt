package Task12_2;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

public class BlockingQueueExample {
    public static void main(String[] args) {

        BlockingQueue queue = new BlockingQueue();

        new Thread(() -> {
            int i = 0;

            while (true) {
                queue.put(++i);
                //System.out.println("ProdAdd " + i);
                //System.out.println(queue);
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Integer j = queue.get();
                if (j % 3 != 0 && j % 5 != 0) {

                    //countThread.getAndIncrement();
                    System.out.println(j);
                    queue.out();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Integer j = queue.get();
                if (j % 5 == 0) {
                    //countThread.getAndIncrement();
                    System.out.println("buzz ");
                    queue.out();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                Integer j = queue.get();
                if (j % 3 == 0) {
                    // countThread.getAndIncrement();
                    System.out.println("fizz ");
                    queue.out();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                Integer j = queue.get();
                if (j % 15 == 0) {
                    //countThread.getAndIncrement();
                    System.out.println("fizzbuzz ");
                    queue.out();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }

    static class BlockingQueue {
        ArrayList<Integer> tasks = new ArrayList<>();
        Integer task;

        public synchronized Integer get() {
            while (tasks.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            task = tasks.get(0);
            return task;
        }

        public Integer out() {
            tasks.remove(task);
            return task;
        }

        public synchronized void put(int task) {
            tasks.add(task);
            notifyAll();
        }

        @Override
        public String toString() {
            return "BlockingQueue{" +
                    "tasks=" + tasks +
                    '}';
        }
    }
}