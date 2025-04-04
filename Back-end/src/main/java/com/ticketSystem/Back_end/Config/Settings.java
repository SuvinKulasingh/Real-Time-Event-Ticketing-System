package com.ticketSystem.Back_end.Config;

import com.ticketSystem.Back_end.Dto.Config1;
import com.ticketSystem.Back_end.Service.TicketPool;

public class Settings {
    public static int maxTickets;
    public static int totalTickets;
    public static int ticketReleaserate;
    public static int ticketRetrievalrate;
    public static int noofVenders;
    public static int noofCustomers;
    public static TicketPool ticketPool;

    public static void updateSettings(Config1 config) {
        totalTickets = config.getTotalTickets();
        maxTickets = config.getMaxTicketCapacity();
        ticketReleaserate = config.getTicketReleaseRate();
        ticketRetrievalrate = config.getCustomerRetrievalRate();
        noofVenders = config.getNumberOfVendors();
        noofCustomers = config.getNumberOfCustomers();

        // Assuming TicketPool constructor is something like this
        ticketPool = new TicketPool(maxTickets, totalTickets);
    }


}

