package com.concurrency;

import java.util.concurrent.Semaphore;

/*
1114. Print in Order

Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(),
thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to
ensure that second() is executed after first(), and third() is executed after second().

Note:

We do not know how the threads will be scheduled in the operating system, even though the numbers in the
input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.



Example 1:

Input: nums = [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(),
thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
Example 2:

Input: nums = [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second().
"firstsecondthird" is the correct output.

Logic
-----
"Semaphore is a bowl of marbles" - Professor Stark

Semaphore is a bowl of marbles (or locks in this case). If you need a marble, and there are none, you wait.
You wait until there is one marble and then you take it. If you release(), you will add one marble to the bowl
(from thin air). If you release(100), you will add 100 marbles to the bowl. run2.release(); will add one "run2"
marble to the "run2 bowl".
The thread calling third() will wait until the end of second() when it releases a 'run3' marble. The second()
will wait until the end of **first() **when it releases a 'run2' marble. Since first() never acquires anything,
it will never wait. There is a forced wait ordering.
With semaphores, you can start out with 1 marble or 0 marbles or 100 marbles. A thread can take marbles
(up until it's empty) or put many marbles at a time.
You can solve this using other solutions (check bottom), but if you wake up a thread and make it spin in a loop
and wait for some condition, it is a waste of CPU. You can make the thread go to sleep and wait for someone to
notify it to wake up.
 */
public class PrintInOrder {
}

class Foo {
    Semaphore run3, run2;
    public Foo() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        run2.release();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        run2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        run3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
