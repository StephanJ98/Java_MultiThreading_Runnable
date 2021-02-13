# :rocket: Examples of Java MultiThreading implementing Runnable Interface

:pencil: Basic example of MultiThreading in Java, actually only with the implementing Runnable Interface method.

In the file ``twoClasses.java`` we need two classes in our main class, in this case ``Hello`` and another class that extends the Thread class, in this case ``MyThread``.

We are going to start with the easy class. ``MyThread`` (***In this case***) we need a var that stores the name of the Thread, for this we are using an integer.

We create the constructor of the class. Where the only thing we do is giving the name of the thread.
```java
MyThread(int idThread) {
    this.name = idThread;
}
```
And next we redefine the `run()` function. Where we only says it to show two messages. But if we want it to make more things is there where to put the instructions.
```java
public void run() {
    System.out.println("Hello you, starting!!! [Thread: " + name + " ]");
    // Do some work ...
    System.out.println("Hello you, this is the end!!! [Thread: " + name + " ]");
}
```

Ok now that we finished the `MyThread` class we are going to see the `Hello` class.

We define our vars.
```java
int limit = 1;
ArrayList<Thread> threads = new ArrayList<>();
long start = System.currentTimeMillis();
```
We are using the `limit` var to store the lowest number of threads that the code is going to create.
The `threads` var is an ArrayList where we are going to store the `MyThread` objects created.
And the `start` var is used to get a timestamp of the moment that the program started.

```java
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
```

First we show a *Hello World* message. The **if** checks if we gived one or more arguments to the console call.

(`This is wrong because I'm not checking the case of we didn't give arguments or the case we give two or more and these aren't numbers.`)

The `for` block adds all the MyThread objects to the `ArrayList` and next executes the `start()` method to start the new thread. And the `join()` method makes the one thread wait the older threads to finish and make his work. (`This is a simple way to reach the simplest synchronization in Threads.`)

```java
System.out.println("Hello " + args[0] + ", this is the end!!!");
System.out.println("Complete in " + (float)(System.currentTimeMillis() - start)/1000 + " seconds");
```

And for finish we show two messages a *Hello World* and a message that gives the time duration of the program in seconds.

# :robot: Usage

Execute `java Hello` and one or two argument.
For example `java Hello StephanJ98 1000`, this is going to show my name in the *Hello world* message and create 1000 threads.

If you change the code or want to recompile the code you need to execute `javac twoclasses.java`

# :raised_hand: Requirements

You only need a Java JDK. I'm using ``OpenJDk 15.0.2``
