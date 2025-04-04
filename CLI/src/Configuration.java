public class Configuration {
    private int maxTickets;
    private int totalTickets;
    private int ticketReleaserate;
    private int ticketRetrievalrate;
    private int noofVenders;
    private int noofCustomers;

    public Configuration(int maxTickets, int totalTickets, int ticketReleaserate, int ticketRetrievalrate, int noofVenders, int noofCustomers) {
        this.maxTickets = maxTickets;
        this.totalTickets = totalTickets;
        this.ticketReleaserate = ticketReleaserate;
        this.ticketRetrievalrate = ticketRetrievalrate;
        this.noofVenders = noofVenders;
        this.noofCustomers = noofCustomers;
    }

    public int getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(int maxTickets) {
        this.maxTickets = maxTickets;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaserate() {
        return ticketReleaserate;
    }

    public void setTicketReleaserate(int ticketReleaserate) {
        this.ticketReleaserate = ticketReleaserate;
    }

    public int getTicketRetrievalrate() {
        return ticketRetrievalrate;
    }

    public void setTicketRetrievalrate(int ticketRetrievalrate) {
        this.ticketRetrievalrate = ticketRetrievalrate;
    }

    public int getNoofVenders() {
        return noofVenders;
    }

    public void setNoofVenders(int noofVenders) {
        this.noofVenders = noofVenders;
    }

    public int getNoofCustomers() {
        return noofCustomers;
    }

    public void setNoofCustomers(int noofCustomers) {
        this.noofCustomers = noofCustomers;
    }
}