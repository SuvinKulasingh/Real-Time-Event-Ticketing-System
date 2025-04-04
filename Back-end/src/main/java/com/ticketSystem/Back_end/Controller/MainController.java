package com.ticketSystem.Back_end.Controller;

import com.ticketSystem.Back_end.Config.ConfigurationHandler;
import com.ticketSystem.Back_end.Config.Settings;
import com.ticketSystem.Back_end.Dto.Config1;
import com.ticketSystem.Back_end.Model.Main;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {
    @GetMapping("/start")
    public String startService() {
        Main.startThread();
        return "Vendor and customer threads started.";
    }

    @GetMapping("/stop")
    public String stopService() {

        return "Vendor and customer threads stopped.";
    }

    @PostMapping("/set")
    public String setConfiguration(@RequestBody Config1 configRequest) {
        Settings.updateSettings(configRequest);
        ConfigurationHandler.saveConfiguration();
        System.out.println();
        System.out.println("Updated Main Configuration:");
        System.out.println();
        System.out.println("Total Tickets: " + configRequest.getTotalTickets());
        System.out.println("Max Tickets: " + configRequest.getMaxTicketCapacity());
        System.out.println("Ticket Release Rate: " + configRequest.getTicketReleaseRate());
        System.out.println("Customer Retrieval Rate: " + configRequest.getCustomerRetrievalRate());
        System.out.println("Number of Vendors: " + configRequest.getNumberOfVendors());
        System.out.println("Number of Customers: " + configRequest.getNumberOfCustomers());

        return "Configuration set successfully!";
    }

}
