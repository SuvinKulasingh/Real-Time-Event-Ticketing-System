package com.ticketSystem.Back_end.Service;

public class Customer implements  Runnable{
    private int customerID;
    private int ticketRetrievalrate;
    private TicketPool ticketPool;
    public Customer(int customerID,TicketPool ticketPool,int ticketRetrievalrate){
        this.customerID=customerID;
        this.ticketPool=ticketPool;
        this.ticketRetrievalrate=ticketRetrievalrate;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                if (ticketPool.removeTickets() == 1) {
                    System.out.println("Customer " + customerID + " removed to the ticket pool");
                } else {
                    Thread.currentThread().interrupt();
                    break;
                }
                Thread.sleep(10000 / ticketRetrievalrate);
            }catch (InterruptedException e){

            }
        }
    }
}