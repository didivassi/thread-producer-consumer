package academy.mindswap;

public class Consumer implements Runnable{

    private int consumedElements;
    private final Container queue;

    public Consumer(Container queue, int consumedElements){
        this.queue=queue;
        this.consumedElements=consumedElements;
    }
    @Override
    public void run() {
        synchronized (queue){
            for (int consumedElement = 0; consumedElement < consumedElements; consumedElement++) {
                while(queue.getSize() == 0){
                    //System.out.println(Thread.currentThread().getName() + " Elements need to be produced in order to consume more elements");
                    try {
                        System.out.println(Thread.currentThread().getName() + " waiting");
                        queue.wait();
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
                }
                    System.out.println( Thread.currentThread().getName() + " consumed "+  queue.poll());
                    queue.notify();
            }

            //
        }




    }
}
