package academy.mindswap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Container<String> queue = new Container<>(7);
        Producer p1 = new Producer(queue, 3);
        Thread t1 = new Thread(p1);
        t1.setName("p1");
        Producer p2 = new Producer(queue, 20);
        Thread t2 = new Thread(p2);
        t2.setName("p2");
        Consumer c1 = new Consumer(queue, 3);
        Thread t3 = new Thread(c1);
        t3.setName("c1");
        Consumer c2 = new Consumer(queue, 29);
        Thread t4 = new Thread(c2);
        t4.setName("c2");

        Producer p3 = new Producer(queue, 10);
        Thread t5 = new Thread(p3);
        t5.setName("p5");

        Consumer c3 = new Consumer(queue, 1);
        Thread t6 = new Thread(c3);
        t6.setName("c3");

        t3.start();
        t4.start();
        t6.start();
        t1.start();
        t2.start();
        t5.start();

    }
}
