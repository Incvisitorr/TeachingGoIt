package Task12.Task12_2;

import java.util.ArrayList;
import java.util.List;

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

        Thread num1=new Thread(new ConvertNumber(queue,"fizz",3));
        Thread num2=new Thread(new ConvertNumber(queue,"buzz",5));
        Thread num3=new Thread(new ConvertNumber(queue,"fizzbuzz",15));
        Thread num4=new Thread(new ReaderNumber(queue,3,5));

        Thread[] threads={num1,num2,num3,num4};
        for(Thread thread:threads){
            thread.start();
        }

//        new Thread(() -> {
//            int i = 0;
//            while (true) {
//                queue.put(++i);
//                //System.out.println("ProdAdd " + i);
//                //System.out.println(queue);
//                try {
//                    Thread.sleep(0);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                Integer j = queue.get();
//                if (j % 3 != 0 && j % 5 != 0) {
//
//                    //countThread.getAndIncrement();
//                    System.out.println(j);
//                    queue.out();
//                }
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                Integer j = queue.get();
//                if (j % 5 == 0) {
//                    //countThread.getAndIncrement();
//                    System.out.println("buzz ");
//                    queue.out();
//                }
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//        new Thread(() -> {
//            while (true) {
//                Integer j = queue.get();
//                if (j % 3 == 0) {
//                    // countThread.getAndIncrement();
//                    System.out.println("fizz ");
//                    queue.out();
//                }
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//        new Thread(() -> {
//            while (true) {
//                Integer j = queue.get();
//                if (j % 15 == 0) {
//                    //countThread.getAndIncrement();
//                    System.out.println("fizzbuzz ");
//                    queue.out();
//                }
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
    }
    static class ReaderNumber implements Runnable{
        BlockingQueue queue;
        int kratnost1;
        int kratnost2;

        public ReaderNumber(BlockingQueue queue,int kratnost1,int kratnost2) {
            this.queue = queue;
            this.kratnost1=kratnost1;
            this.kratnost2=kratnost2;
        }
        @Override
        public void run() {
            while (true) {
                Integer j = queue.get();
                if (j % kratnost1 != 0 && j % kratnost2 != 0) {
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
        }
    }

    static class ConvertNumber implements Runnable{
        BlockingQueue queue;
        String phrase;
        int kratnost;

        public ConvertNumber(BlockingQueue queue, String phrase,int kratnost) {
            this.queue = queue;
            this.phrase = phrase;
            this.kratnost=kratnost;
        }

        @Override
        public void run() {
            while (true) {
                Integer j = queue.get();
                if (j % kratnost == 0) {

                    //countThread.getAndIncrement();
                    System.out.println(phrase);
                    queue.out();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    static class BlockingQueue {
        List<Integer> tasks = new ArrayList<>();
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