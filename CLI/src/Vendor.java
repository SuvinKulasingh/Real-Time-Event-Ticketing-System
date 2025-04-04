public class Vendor implements Runnable {
    private int vendorID;
    private TicketPool ticketPool;
    private int ticketReleaserate;

    public Vendor(int vendorID, TicketPool ticketPool, int ticketReleaserate) {
        this.vendorID = vendorID;
        this.ticketPool = ticketPool;
        this.ticketReleaserate = ticketReleaserate;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if(ticketPool.addTickets() ==1 ) {
                    System.out.println("Vendor" + vendorID + " " + "added to the ticket pool");
                } else {
                    Thread.currentThread().interrupt();
                    break;
                }
                Thread.sleep(10000 / ticketReleaserate);
            } catch (InterruptedException e) {

            }
        }
    }
}
