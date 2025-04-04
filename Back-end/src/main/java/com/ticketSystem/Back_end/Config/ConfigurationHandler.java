package com.ticketSystem.Back_end.Config;

import com.ticketSystem.Back_end.Dto.Config1;
import com.ticketSystem.Back_end.Service.TicketPool;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.ticketSystem.Back_end.Config.Settings.*;
import static com.ticketSystem.Back_end.Model.Main.FILE_NAME;

public class ConfigurationHandler {

    public static void saveConfiguration() {
        JSONObject json = new JSONObject();
        json.put("totalTickets", totalTickets);
        json.put("ticketReleaseRate", ticketReleaserate);
        json.put("customerRetrievalRate", ticketRetrievalrate);
        json.put("maxTicketCapacity", maxTickets);
        json.put("numberOfVendors", noofVenders);
        json.put("numberOfCustomers", noofCustomers);

        try (FileWriter file = new FileWriter(FILE_NAME)) {
            json.write(file);
            System.out.println("Configuration saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving configuration: " + e.getMessage());
        }
    }

    public void loadConfiguration() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            JSONObject json = new JSONObject(content);

            totalTickets = json.getInt("totalTickets");
            ticketReleaserate = json.getInt("ticketReleaseRate");
            ticketRetrievalrate = json.getInt("customerRetrievalRate");
            maxTickets = json.getInt("maxTicketCapacity");
            noofVenders = json.getInt("numberOfVendors");
            noofCustomers = json.getInt("numberOfCustomers");
            ticketPool = new TicketPool(maxTickets, totalTickets);

            System.out.println("Configuration loaded successfully!");
            System.out.println("Total Tickets: " + totalTickets);
            System.out.println("Ticket Release Rate: " + ticketReleaserate);
            System.out.println("Customer Retrieval Rate: " + ticketRetrievalrate);
            System.out.println("Max Ticket Capacity: " + maxTickets);
            System.out.println("Number Of Vendors: " + noofVenders);
            System.out.println("Number Of Customers: " + noofCustomers);
        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
        }
    }
}
