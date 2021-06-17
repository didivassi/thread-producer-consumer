package academy.mindswap;

import java.util.LinkedList;

public class Container<T> {

    private  int limit;
    private LinkedList<T> list;

    public Container(int limit){
        this.limit=limit;
        list = new LinkedList<>();
    }

    public int getLimit() {
            return limit;
    }

    public int getSize(){
        return list.size();
    }

    public void offer(T elementsToOffer){
        list.offer(elementsToOffer);
        //System.out.println(elementsToOffer + " offer");

    }

    public T poll(){
       // System.out.println(elementsToPoll + " poll");
       return list.poll();
    }
}
