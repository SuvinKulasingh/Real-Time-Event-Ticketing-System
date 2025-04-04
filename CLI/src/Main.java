import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.*;

public class Main {
    private static int maxTickets;
    private static int totalTickets;
    private static int ticketReleaserate;
    private static int ticketRetrievalrate;
    private static int noOfVenders;
    private static int noOfCustomers;
    private static TicketPool ticketPool;
    private final static List<Thread> threadList=new ArrayList<>();

    private static final String FILE_NAME = "settings.json";  // File to store settings

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File file = new File(FILE_NAME);
        if (!file.exists()){
            setConfiguration(input);
            saveConfigurationToFile();
        }
        else {
            System.out.println("     Configuration detected!");
            System.out.println("*************************************");
            System.out.println();
            System.out.println("If need to updated Select 1 or Enter 2 to start");
            int choice = input.nextInt();
            if (choice ==1){
                setConfiguration(input);
            }
            else {
                loadConfigurationFromFile();
            }
        }


        for(int i = 1; i< noOfVenders +1; i++){
            Vendor vendor = new Vendor(i, ticketPool,ticketReleaserate);
            Thread thread= new Thread(vendor);
            threadList.add(thread);
            thread.start();
        }
        for(int i = 1; i< noOfCustomers +1; i++){
            Customer customer= new Customer(i,ticketPool,ticketRetrievalrate);
            Thread thread=new Thread(customer);
            threadList.add(thread);
            thread.start();
        }
    }

    public static void setConfiguration(Scanner input) {
        // Validate totalTickets input
        while (true) {
            try {
                System.out.println("Enter the total number of tickets:");
                totalTickets = input.nextInt();
                if (totalTickets > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number for total tickets.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the buffer
            }
        }

        // Validate ticketReleaserate input
        while (true) {
            try {
                System.out.println("Enter the ticket release rate:");
                ticketReleaserate = input.nextInt();
                if (ticketReleaserate > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number for the ticket release rate.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the buffer
            }
        }

        // Validate ticketRetrievalrate input
        while (true) {
            try {
                System.out.println("Enter the customer retrieval rate:");
                ticketRetrievalrate = input.nextInt();
                if (ticketRetrievalrate > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number for the customer retrieval rate.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the buffer
            }
        }

        // Validate maxTickets input
        while (true) {
            try {
                System.out.println("Enter the max ticket capacity:");
                maxTickets = input.nextInt();
                if (maxTickets > 0 && maxTickets >= totalTickets) {
                    break;
                } else {
                    System.out.println("Please enter a positive number for max ticket capacity, and it should be greater than or equal to the total tickets.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the buffer
            }
        }

        // Validate noofVenders input
        while (true) {
            try {
                System.out.println("Enter the number of vendors:");
                noOfVenders = input.nextInt();
                if (noOfVenders > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number for the number of vendors.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the buffer
            }
        }

        // Validate noofCustomers input
        while (true) {
            try {
                System.out.println("Enter the number of customers:");
                noOfCustomers = input.nextInt();
                if (noOfCustomers > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number for the number of customers.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the buffer
            }
        }

        ticketPool = new TicketPool(maxTickets,totalTickets);

        System.out.println("\nConfiguration set successfully!");
    }

    private static void saveConfigurationToFile() {

        JSONObject json = new JSONObject();

        json.put("totalTickets",totalTickets);
        json.put("ticketReleaseRate",ticketReleaserate);
        json.put("customerRetrievalRate",ticketRetrievalrate);
        json.put("maxTicketCapacity",maxTickets);
        json.put("numberOfVendors", noOfVenders);
        json.put("numberOfCustomers", noOfCustomers);


        // Write the string to the file
        try (FileWriter file = new FileWriter(FILE_NAME)) {
            json.write(file);
            System.out.println("Configuration saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving configuration: " + e.getMessage());
        }
    }

    private static void loadConfigurationFromFile() {
        try {

            String content = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            JSONObject json = new JSONObject(content);

            totalTickets = json.getInt("totalTickets");
            ticketReleaserate = json.getInt("ticketReleaseRate");
            ticketRetrievalrate = json.getInt("customerRetrievalRate");
            maxTickets = json.getInt("maxTicketCapacity");
            noOfVenders = json.getInt("numberOfVendors");
            noOfCustomers = json.getInt("numberOfCustomers");
            ticketPool =new TicketPool(maxTickets,totalTickets);

            System.out.println("Configuration loaded successfully!");
            System.out.println("Total Tickets: " + totalTickets);
            System.out.println("Ticket Release Rate: " + ticketReleaserate);
            System.out.println("Customer Retrieval Rate: " + ticketRetrievalrate);
            System.out.println("Max Ticket Capacity: " + maxTickets);
            System.out.println("Number Of Vendors: " + noOfVenders);
            System.out.println("Number Of Customers: " + noOfVenders);
        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
        }
    }
}
