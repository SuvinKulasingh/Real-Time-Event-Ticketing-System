package com.ticketSystem.Back_end.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ticketSystem.Back_end.Service.Customer;
import com.ticketSystem.Back_end.Service.Vendor;

import static com.ticketSystem.Back_end.Config.Settings.*;


public class Main {
    private final static List<Thread> threadList = new ArrayList<>();
    public static final String FILE_NAME = "config.json"; // path

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    }


    public static void startThread() {
        System.out.println("max tickets " + maxTickets );
        for(int i=1;i<noofVenders+1; i++){
            Vendor vendor = new Vendor(i, ticketPool,ticketReleaserate);
            Thread thread= new Thread(vendor);
            threadList.add(thread);
            thread.start();
        }
        for(int i=1;i<noofCustomers+1;i++){
            Customer customer= new Customer(i,ticketPool,ticketRetrievalrate);
            Thread thread=new Thread(customer);
            threadList.add(thread);
            thread.start();
        }
    }






}
