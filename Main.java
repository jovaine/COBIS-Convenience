package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Products> products = new ArrayList<Products>();

        Products merch = new Products();
        merch.setItem("Red-Hot Spicy Doritos");
        merch.setPrice(2.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Cool Ranch Doritos");
        merch.setPrice(2.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Coke");
        merch.setPrice(0.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Diet Coke");
        merch.setPrice(0.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Pepsi");
        merch.setPrice(0.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Five Hour Energy");
        merch.setPrice(3.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Sunflower Seeds");
        merch.setPrice(0.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Peanuts");
        merch.setPrice(0.99);
        products.add(merch);

        merch = new Products();
        merch.setItem("Mac Book Chargers");
        merch.setPrice(120.00);
        products.add(merch);

        merch = new Products();
        merch.setItem("Dell Chargers");
        merch.setPrice(50.00);
        products.add(merch);
        String response = "";
        String cus_order = "";
        String ord_item = "";
        double ord_price =0;
        String cus_output = "";
        String customer_response = "";
        double cus_total = 0.00;
        ArrayList<Order> order = new ArrayList<Order>();
        ArrayList<Customer_Orders> cname = new ArrayList<Customer_Orders>();
        do {
            System.out.println("Welcome to COBIS Convenience Store");
            System.out.println("Enter 1 to enter new customer order or 2 to close");
            Scanner input = new Scanner(System.in);
            response = input.nextLine();

            if (response.equals("1")) {
                System.out.println("Please enter customer's name");
                customer_response = input.nextLine();
                Customer_Orders customer = new Customer_Orders();
                customer.setCus_name(customer_response);
                int previous_size = 0;
                //Customer_Orders customer = new Customer_Orders();
                //customer.setCus_name(customer_response);
                do {
                    System.out.println("Please enter customer order from list when done type 2 ");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(products.get(i).getItem() + "-----" + products.get(i).getPrice());
                    }
                    cus_order = input.nextLine();
                    int index = -1;
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i).getItem().equals(cus_order)) {
                            index = i;
                        }
                    }
                    if (index == -1) {
                        System.out.println("");
                    } else {
                        ord_item = products.get(index).getItem();
                        ord_price = products.get(index).getPrice();
                        Order orders = new Order();
                        orders.setItem(ord_item);
                        orders.setPrice(ord_price);
                        order.add(orders); // adding the elements in Orders class to array list
                        customer = new Customer_Orders();
                        customer.setItem(ord_item);
                        customer.setPrice(ord_price);
                        cname.add(customer);
                    }


                } while (!cus_order.equals("2"));

            }
        } while (!response.equals("2"));

        System.out.println("Closing\nReceipts");
        cus_output += customer_response;
        for (int c = 0; c < cname.size(); c++) {
            cus_output += "\n\t" + cname.get(c).getItem();
            cus_total += cname.get(c).getPrice();}
        cus_output += "\n\t\t" + cus_total+"\n";
        System.out.println(cus_output);


        System.out.println(" Inventory sold");
        String cus_output1 = "";
        double cus_total1 = 0.00;
        for (int c = 0; c < cname.size(); c++) {
            cus_output1 += "\n\t" + cname.get(c).getItem();
            cus_total1 += cname.get(c).getPrice();}
        cus_output1 += "\nGrand Total\t\t" + cus_total1+"\n";
        System.out.println(cus_output1);
        }

}

