package multithreading.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by prituladima on 2/4/18.
 */
public class AtomicStack <T>{

    private AtomicReference<Node<T>> nodeAtomicReference = new AtomicReference<>();

    public void push(T value){
        for(;;){
            Node<T> newHead = new Node<>();
            newHead.value = value;
            Node<T> oldOne = nodeAtomicReference.get();
            newHead.next = oldOne;

            if(nodeAtomicReference.compareAndSet(oldOne, newHead)){
                break;
            }

        }
    }

    public T peek(){
        for (;;){
            Node<T> currentHead = nodeAtomicReference.get();
            Node<T> newHead = currentHead.next;

            if(nodeAtomicReference.compareAndSet(currentHead, newHead)){
                return newHead.value;
            }

        }
    }

    public class Node<T>{

        T value;
        Node<T> next;


    }

}
