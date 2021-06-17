package academy.mindswap;

public class Producer implements Runnable{

    private int elementsToProduce;
    private final Container queue;
    public Producer(Container queue, int elementsToProduce){
        this.queue=queue;
        this.elementsToProduce=elementsToProduce;
    }
    @Override
    public void run() {

        synchronized (queue){

            for (int producedElement = 0; producedElement < elementsToProduce; producedElement++) {
                if(queue.getLimit() < queue.getSize() + 1){
                    System.out.println(Thread.currentThread().getName() + " Elements need to be consumed in order to produce more elements");
                    try {
                        System.out.println(Thread.currentThread().getName() + " waiting");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() +" added "+ (producedElement+1) );
                queue.offer(Thread.currentThread().getName()+  " "+ (producedElement+1) );
                queue.notify();
            }

        }



    }
}
