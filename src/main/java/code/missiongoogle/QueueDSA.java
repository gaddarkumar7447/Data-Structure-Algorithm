package code.missiongoogle;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import static java.lang.System.in;
import static java.lang.System.out;

public class QueueDSA {
    public static void main(String[] args) {
//        Queue<Integer> queue = new PriorityQueue<>();
//        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(700);
        queue.add(450);
        queue.add(400);
        queue.add(500);
        queue.add(600);
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }

    }
}
