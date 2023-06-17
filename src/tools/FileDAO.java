/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import data.Customer;
import data.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DevDD
 */
public class FileDAO {

    public static void writeFile(String filename, List<String> list) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String o : list) {
                bw.write(o);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //read file
    public static List<String> readFile(String filename) {
        List<String> list = new ArrayList<String>();
        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (br.ready()) {
                    list.add(br.readLine());
                }
                br.close();
                fr.close();
            } catch (Exception e) {
            }
            return (List<String>) list;
        }
        return null;

    }

    public static void writeFileProduct(List<Product> list) {
        try {
            FileWriter fw = new FileWriter("products.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Product p : list) {
                bw.write(p.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    //Read file Account
    public static List<Product> readFileProduct() {
        List<Product> list = new ArrayList<Product>();
        File file = new File("products.txt");
        if (file.exists() && file.isFile()) {
            try {
                FileReader fr = new FileReader("products.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (br.ready()) {
                    line = br.readLine();
                    if(line.isBlank())
                    {
                        continue;
                    }
                    String[] tmp = line.split(",");
                    Product ppp = new Product(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], tmp[6], tmp[7]);
                    list.add(ppp);
                }
                br.close();
                fr.close();
            } catch (Exception e) {
            }
            return list;
        }
        return null;
    }
    //file customer
    public static void writeFileCustomer(List<Customer> list) {
        try {
            FileWriter fw = new FileWriter("customer.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Customer c : list) {
                bw.write(c.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    //Read file Customer
    public static List<Customer> readFileCustomer() {
        List<Customer> list = new ArrayList<Customer>();
        File file = new File("customer.txt");
        if (file.exists() && file.isFile()) {
            try {
                FileReader fr = new FileReader("customer.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (br.ready()) {
                    line = br.readLine();
                    if(line.isBlank())
                    {
                        continue;
                    }
                    String[] tmp = line.split(",");
                    Customer ccc = new Customer(tmp[0], tmp[1], Integer.parseInt(tmp[2]));
                    list.add(ccc);
                }
                br.close();
                fr.close();
            } catch (Exception e) {
            }
            return list;
        }
        return null;
    }
}
