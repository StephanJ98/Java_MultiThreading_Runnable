import java.util.ArrayList;

class MyThread implements Runnable {
    public int name;

    MyThread(int idThread) {
        this.name = idThread;
    }

    public void run() {
        try {
            System.out.println("Hello you, starting!!! [Thread: " + name + " ]");
            // Do some work ...
            System.out.println("Hello you, this is the end!!! [Thread: " + name + " ]");
        } catch (Exception e) {
            System.err.println("Exception is caught");
        }
    }
}

class Hello {
    public static void main(String[] args) throws InterruptedException {
        int limit = 1;
        ArrayList<Thread> threads = new ArrayList<>();
        long start = System.currentTimeMillis();

        System.out.println("Hello world, this is " + args[0]);
        if (args.length > 1) {
            limit = Integer.parseInt(args[1]);
        }
        for (int i = 0; i <= limit - 1; i++) {
            threads.add(new Thread(new MyThread(i)));
            threads.get(i).start();
            //threads.get(i).join(); We finish the execution of a thread before starting other.
        }
        for (Thread myThread : threads) {
            myThread.join();
        }

        System.out.println("Hello " + args[0] + ", this is the end!!!");
        System.out.println("Complete in " + (float) (System.currentTimeMillis() - start) / 1000 + " seconds");
    }
}