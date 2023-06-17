/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;

import data.Customer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import tools.Validation;

/**
 *
 * @author DevDD
 */
public class Tester {

    public static void main(String[] args) {
//        System.out.println("+------------------------------------------------------------------+");
//        System.out.println("|                            Bill of sale                          |");
//        
//        Random rd = new Random();
//        int id = rd.nextInt(10000) + 1;
//        System.out.println("| Bill ID: " + id + "\t\t\t\t\t\t\t   |");
//        Date date = new Date();
//        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        System.out.println("| Date: " + f.format(date) + "\t\t\t\t\t   |");
//        System.out.println("+------------------------------------------------------------------+");
//        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-5s   |    %-12s  |\n", "ID", "NAME", "PRICE", "QUANTITY", "TOTAL PRICE");
//        System.out.println("+------------------------------------------------------------------+");
//        System.out.format("|  %-5s |   %-8s  |   %-5s |      %-5s   |      %-12s|\n", "P005", "MiTom", "200", 200, Validation.isCurrency(20000, '.'));
//        System.out.println("+------------------------------------------------------------------+");
//        System.out.format("|    Total payment:                                %8d VND    |\n", 20000);
//        System.out.println("+------------------------------------------------------------------+");

//        System.out.println("+----------------------------------------------+");
//        System.out.format("|     %-8s    |    %-9s   |   %-5s   |\n", "CUS_NAME", "CUS_PHONE", "POINT");
//        System.out.println("+----------------------------------------------+");
//        System.out.format("|    %-12s |   %-11s  |   %-7d |\n", "Chi Duong", "0912345678", 10000);
//        System.out.println("+----------------------------------------------+");
//        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
//        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
//        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
//        System.out.format("|  %-5s |   %-8s  |   %-5s |     %-5s    |   %-5s |   %-10s    |   %-10s    |   %-13s   |\n", "P005", "KemChuoi", "200", "500", "100", "22/04/2022", "22/10/2022", "Not Available");
//        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
//        System.out.println("+-------------------------------------------------------------------------------------+");
//        System.out.format("|   %-5s|     %-8s|   %-5s  |   %-8s   |       %-3s       |       %-6s     |\n", "ID", "NAME", "PRICE", "QUANTITY", "HSD", "STATUS");
//        System.out.println("+-------------------------------------------------------------------------------------+");
//        System.out.format("|  %-5s |     %-8s|   %-5s  |    %-8s  |      %-5s      |       %-6s     |\n", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
//        System.out.println("+-------------------------------------------------------------------------------------+");
//        System.out.println("+-----------------------------------------------+");
//        System.out.println("|   Select the price range you want to search   |");
//        System.out.println("+-----------------------------------------------+");
//        System.out.println("|       1. Under 5.000 VND                      |");
//        System.out.println("|       2. From 5.000 VND to 10.000 VND         |");
//        System.out.println("|       3. From 10.000 VND to 20.000VND         |");
//        System.out.println("|       4. Over 20.000 VND                      |");
//        System.out.println("+-----------------------------------------------+");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.format("|  %-5s |    %-8s |  %-5s  |     %-5s    |  %-5s  |      %-5s      |      %-5s      |       %-5s       |\n", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        
    }
}
