import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketPool {
    private int maxTickets;
    private int totalTickets;

    private List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

    public TicketPool(int maxTickets, int totalTickets) {
        this.maxTickets = maxTickets;
        this.totalTickets = totalTickets;
    }

    public synchronized int addTickets() {
        if (totalTickets < maxTickets) {
            totalTickets++;
            list.add(1);
            System.out.println("A ticket is successfully added to the ticket pool");
            notifyAll();
            return 1;
        } else {
            System.out.println("Ticket pool is full");
            return 0;
        }
    }

    public synchronized int removeTickets() {
        while (list.isEmpty() && totalTickets < maxTickets) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
        if(!list.isEmpty() && totalTickets < maxTickets) {
            System.out.println("successfully removed the ticket");
            return list.remove(0);
        }else{
            System.out.println("Ticket pool is reach maximum capacity & ticket pool is empty");
            return 0;
        }
    }
}
