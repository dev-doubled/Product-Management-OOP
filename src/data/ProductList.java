/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import tools.FileDAO;
import tools.Validation;

/**
 *
 * @author DevDD
 */
public class ProductList extends ArrayList<Product> {

    Scanner sc = new Scanner(System.in);
    List<Order> ordering = new ArrayList<Order>();
    List<Customer> customers = new ArrayList<Customer>();

    public ProductList() {
        List<Product> line = FileDAO.readFileProduct();
        for (Product p : line) {
            add(p);
        }
        FileDAO.writeFileProduct(this);
    }

    public void createProduct() {
        String snn = "";
        do {
            boolean flag = false;
            String id = "";
            while (!flag) {
                int check = 0;
                id = Validation.inputString("Product ID: ", "ID is invalid", "P[0-9]{3}");
                for (Product ppp : this) {
                    if (ppp.getProductID().equals(id)) {
                        flag = false;
                        check = 1;
                    }
                }
                if (check == 1) {
                    System.out.println("ID is already exist!");
                } else {
                    flag = true;
                }
            }
            flag = false;
            String name = "";
            while (!flag) {
                int check = 0;
                name = Validation.inputString("Product name: ", "Name is invalid", "[a-zA-Z]{5,100}");
                for (Product thi : this) {
                    if (thi.getProductName().equals(name)) {
                        flag = false;
                        check = 1;
                    }
                }
                if (check == 1) {
                    System.out.println("Product name cannot duplicate");
                } else {
                    flag = true;
                }
            }
            float unitPrice = Validation.inputIntNumber(0, 10000000, "Unit Price: ", "Price is invalid");
            int quantity = Validation.inputIntNumber(0, 1000, "Quantity: ", "Quantity is invalid");
            int saled = 0;
            String nsx = Validation.inputString("Date of manufacture: ", "Date not valid", "[0-9]{2}/[0-9]{2}/[0-9]{4}");
            String hsd = Validation.inputString("Expiry date: ", "Date not valid", "[0-9]{2}/[0-9]{2}/[0-9]{4}");
            String status = Validation.inputString("Status: ", "Status is invalid", "Available|Not Available");
            add(new Product(id, name, "" + unitPrice, "" + quantity, "" + saled, nsx, hsd, status));
            sc = new Scanner(System.in);
            System.out.print("Do you want to add more[yes/no]? --> ");
            snn = sc.nextLine();
        } while (snn.equalsIgnoreCase("yes"));

        FileDAO.writeFileProduct(this);
    }

    public void checkExist() {
        System.out.println("Enter Product name you want to check");
        String name = Validation.inputString("Product name: ", "Name is invalid", "[a-zA-Z]{5,100}");
        for (Product p : this) {
            if (p.getProductName().equals(name)) {
                System.out.println("Exist Product!");
                break;
            } else {
                System.out.println("No Product Found!");
                break;
            }
        }
    }

    public boolean isContain(String a1, String a2) {
        boolean flag = false;
        for (int i = 0; i < a1.length(); i++) {
            String txt = "";
            if (a1.charAt(i) == a2.charAt(0)) {
                txt += a2.charAt(0);
                for (int j = 1; j < a2.length(); j++) {
                    if (i + j < a1.length()) {
                        txt += a1.charAt(i + j);
                    }
                }
                if (txt.equals(a2)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void searchByName() {
        System.out.print("Enter name product you want to search: ");
        String sName = sc.nextLine();
        String result = sName.toUpperCase();
        sortByName();
        System.out.println("+------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-5s   |      %-12s|\n", "ID", "NAME", "PRICE", "QUANTITY", "STATUS");
        System.out.println("+------------------------------------------------------------------+");
        for (Product thi : this) {
            if (isContain(thi.getProductName().toUpperCase(), result)) {
                System.out.format("|  %-5s |   %-8s  |   %-5s |      %-5s   |   %-13s  |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getStatus());
                System.out.println("+------------------------------------------------------------------+");
            }
        }
    }

    public void searchByID() {
        sc = new Scanner(System.in);
        System.out.print("Enter ID product you want to search: ");
        String sID = sc.nextLine();
        int check = 0;
        System.out.println("+------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-5s   |      %-12s|\n", "ID", "NAME", "PRICE", "QUANTITY", "STATUS");
        System.out.println("+------------------------------------------------------------------+");
        for (Product s : this) {

            if (s.getProductID().equals(sID)) {

                System.out.format("|  %-5s |   %-8s  |   %-5s |      %-5s   |   %-13s  |\n", s.getProductID(), s.getProductName(), s.getUnitPrice(), s.getQuantity(), s.getStatus());
                System.out.println("+------------------------------------------------------------------+");
                check = 1;
            }
        }
        if (check == 0) {
            System.out.println("Product not exits!");
        }
    }

    public void sortByName() {
        Collections.sort(this);
        FileDAO.writeFileProduct(this);
    }

    public void sortByName1() {
        Collections.sort(this);
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        for (Product thi : this) {
            System.out.format("|  %-5s |   %-8s  |   %-5s |     %-5s    |   %-5s |   %-10s    |   %-10s    |   %-13s   |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getSaled(), thi.getNSX(), thi.getHSD(), thi.getStatus());
            System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        }
    }

    public void sortByPrice1() {
        sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.parseInt(o1.getUnitPrice()) - Integer.parseInt(o2.getUnitPrice());
            }
        });
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        for (Product thi : this) {
            System.out.format("|  %-5s |   %-8s  |   %-5s |     %-5s    |   %-5s |   %-10s    |   %-10s    |   %-13s   |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getSaled(), thi.getNSX(), thi.getHSD(), thi.getStatus());
            System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        }
    }

    public void sortByPrice() {
        sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.parseInt(o1.getUnitPrice()) - Integer.parseInt(o2.getUnitPrice());
            }
        });

        FileDAO.writeFileProduct(this);
    }

    public void sortByID() {
        sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.parseInt(o1.getProductID().substring(1)) - Integer.parseInt(o2.getProductID().substring(1));
            }
        });

        FileDAO.writeFileProduct(this);
    }

    public void sortByID1() {
        sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.parseInt(o1.getProductID().substring(1)) - Integer.parseInt(o2.getProductID().substring(1));
            }
        });
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        for (Product thi : this) {
            System.out.format("|  %-5s |   %-8s  |   %-5s |     %-5s    |   %-5s |   %-10s    |   %-10s    |   %-13s   |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getSaled(), thi.getNSX(), thi.getHSD(), thi.getStatus());
            System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        }
    }

    public void sortBySaled() {
        sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return -Integer.parseInt(o1.getSaled()) + Integer.parseInt(o2.getSaled());
            }
        });
    }

    public void sortBySaled1() {
        sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return -Integer.parseInt(o1.getSaled()) + Integer.parseInt(o2.getSaled());
            }
        });
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        for (Product thi : this) {
            System.out.format("|  %-5s |   %-8s  |   %-5s |     %-5s    |   %-5s |   %-10s    |   %-10s    |   %-13s   |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getSaled(), thi.getNSX(), thi.getHSD(), thi.getStatus());
            System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        }
    }

    public void updateProduct() {
        String uID = Validation.inputString("Enter ID product you want to update: ", "ID is invalid", "P[0-9]{3}");
        Product tmp = null;
        for (Product oProduct : this) {
            if (oProduct.getProductID().equals(uID)) {
                tmp = oProduct;
            }
        }
        if (tmp != null) {
            System.out.println("What information do you want to update?");
            System.out.println("1. Price");
            System.out.println("2. Quantity");
            System.out.println("3. Status");
            System.out.print("Enter your choice: ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    int newPrice = Validation.inputIntNumber(0, 10000, "Enter new price: ", "Price is invalid");
                    tmp.setUnitPrice("" + newPrice);
                    break;
                case 2:
                    int newQ = Validation.inputIntNumber(0, 1000, "Enter new quantity: ", "Quantity is invalid");
                    tmp.setQuantity("" + newQ);
                    break;
                case 3:
                    String newS = Validation.inputString("Enter new status: ", "Status is invalid", "Available|Not Available");
                    tmp.setStatus(newS);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Product ID does not exis!");
        }
        System.out.println("+------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-5s   |      %-12s|\n", "ID", "NAME", "PRICE", "QUANTITY", "STATUS");
        System.out.println("+------------------------------------------------------------------+");
        for (Product thi : this) {
            System.out.format("|  %-5s |   %-8s  |   %-5s |      %-5s   |   %-13s  |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getStatus());
            System.out.println("+------------------------------------------------------------------+");
        }
        FileDAO.writeFileProduct(this);
    }

    public void deleteProduct() {
        String deleID = Validation.inputString("Enter ID product you want to delete: ", "ID is invalid", "P[0-9]{3}");
        Product tmp = null;
        for (Product deleProduct : this) {
            if (deleProduct.getProductID().equals(deleID)) {
                tmp = deleProduct;
            }
        }
        if (tmp != null) {
            remove(tmp);
        } else {
            System.out.println("Product ID does not exis!");
        }
        System.out.println("+------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-5s   |      %-12s|\n", "ID", "NAME", "PRICE", "QUANTITY", "STATUS");
        System.out.println("+------------------------------------------------------------------+");
        for (Product thi : this) {
            System.out.format("|  %-5s |   %-8s  |   %-5s |      %-5s   |   %-13s  |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getStatus());
            System.out.println("+------------------------------------------------------------------+");

        }
        FileDAO.writeFileProduct(this);
    }

    public void buyProduct() {
        String sll = "";
        do {
            String idPro = Validation.inputString("Product ID: ", "ID is invalid", "P[0-9]{3}");
            int quantityPro = Validation.inputIntNumber(0, 1000, "Quantity: ", "Quantity is invalid");
            Product tmp = null;
            for (Product thi : this) {
                if (thi.getProductID().equals(idPro) && thi.getStatus().equalsIgnoreCase("Available")) {
                    tmp = thi;
                }
            }
            if (tmp != null) {
                if (Integer.parseInt(tmp.getQuantity()) >= quantityPro) {
                    tmp.setQuantity("" + (Integer.parseInt(tmp.getQuantity()) - quantityPro));
                    tmp.setSaled("" + (Integer.parseInt(tmp.getSaled()) + quantityPro));
                    ordering.add(new Order(idPro, tmp.getProductName(), tmp.getUnitPrice(), quantityPro, (Integer.parseInt(tmp.getUnitPrice()) * quantityPro)));
                } else {
                    System.out.println("Quantity is exhausted, this product only have " + tmp.getQuantity());
                }
            } else {
                System.out.println("This product don't have in store or Not Available to buy");
            }
            sc = new Scanner(System.in);
            System.out.print("Do you want to buy more product [yes/no]? --> ");
            sll = sc.nextLine();
        } while (sll.equalsIgnoreCase("yes"));
        FileDAO.writeFileProduct(this);
    }

    public void exportBill() {
        int sum = 0;
        for (Order order : ordering) {
            sum += order.getTotalPrice();
        }
        Customer tmpC = null;
        List<Customer> line = FileDAO.readFileCustomer();
        System.out.print("Do you want to earn point [yes/no] ? --> ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            String phoneNum = Validation.inputString("What is your phone number? ", "Incorrect phone number", "0[0-9]{9}");
            for (Customer cus : line) {
                if (cus.getPhoneNumber().equals(phoneNum)) {
                    tmpC = cus;
                }
            }
            if (tmpC != null) {
                tmpC.setPoint(tmpC.getPoint() + (sum / 1000));
                System.out.println("Add point successful.");
                useDiscount(tmpC);
                FileDAO.writeFileCustomer(line);
            } else {
                System.out.println("This is new customer");
                String newNameCus = Validation.inputString("What is your name? ", "Name is invalid", ".{1,}");
                int point = sum / 1000;
                Customer tmpCustomer = new Customer(newNameCus, phoneNum, point);
                customers.add(tmpCustomer);
                useDiscount(tmpCustomer);
                FileDAO.writeFileCustomer(customers);
            }

        } else {
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("|                            Bill of sale                          |");
            Random rd = new Random();
            int id = rd.nextInt(10000) + 1;
            System.out.println("| Bill ID: " + id + "\t\t\t\t\t\t\t   |");
            Date date = new Date();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            System.out.println("| Date: " + f.format(date) + "\t\t\t\t\t   |");
            System.out.println("+------------------------------------------------------------------+");
            System.out.format("|   %-5s|     %-8s|  %-5s  |   %-5s   |    %-12s  |\n", "ID", "NAME", "PRICE", "QUANTITY", "TOTAL PRICE");
            System.out.println("+------------------------------------------------------------------+");
            for (Order order : ordering) {
                System.out.format("|  %-5s |   %-8s  |   %-5s |      %-5s   |      %-12s|\n", order.getProID(), order.getProName(), order.getProPrice(), order.getProQuantity(), order.getTotalPrice());
                System.out.println("+------------------------------------------------------------------+");
            }
            System.out.format("|    Total payment:                                %8s VND    |\n", Validation.isCurrency(sum, '.'));
            System.out.println("+------------------------------------------------------------------+");
        }

    }

    public void useDiscount(Customer aCustomer) {
        int sum = 0;
        for (Order order : ordering) {
            sum += order.getTotalPrice();
        }
        if (aCustomer.getPoint() >= 1000) {
            System.out.println("Your have enough point to use discount Mr/Mrs " + aCustomer.getName());
            System.out.println("Your point: " + aCustomer.getPoint());
            System.out.print("Do you want to use discount [yes/no] ? --> ");
            String cc = sc.nextLine();
            if (cc.equalsIgnoreCase("yes")) {
                System.out.print("How many point you want to use? --> ");
                int p = sc.nextInt();
                aCustomer.setPoint(aCustomer.getPoint() - p);
                FileDAO.writeFileCustomer(customers);
                System.out.println("+------------------------------------------------------------------+");
                System.out.println("|                            Bill of sale                          |");
                Random rd = new Random();
                int id = rd.nextInt(10000) + 1;
                System.out.println("| Bill ID: " + id + "\t\t\t\t\t\t\t   |");
                Date date = new Date();
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                System.out.println("| Date: " + f.format(date) + "\t\t\t\t\t   |");
                System.out.println("+------------------------------------------------------------------+");
                System.out.format("|   %-5s|     %-8s|  %-5s  |   %-5s   |    %-12s  |\n", "ID", "NAME", "PRICE", "QUANTITY", "TOTAL PRICE");
                System.out.println("+------------------------------------------------------------------+");
                for (Order order : ordering) {
                    System.out.format("|  %-5s |   %-8s  |   %-5s |      %-5s   |      %-12s|\n", order.getProID(), order.getProName(), order.getProPrice(), order.getProQuantity(), order.getTotalPrice());
                    System.out.println("+------------------------------------------------------------------+");
                }
                System.out.format("|    Total payment:                                %8s VND    |\n", Validation.isCurrency(sum - p, '.'));
                System.out.println("+------------------------------------------------------------------+");

            } else {
                System.out.println("+------------------------------------------------------------------+");
                System.out.println("|                            Bill of sale                          |");
                Random rd = new Random();
                int id = rd.nextInt(10000) + 1;
                System.out.println("| Bill ID: " + id + "\t\t\t\t\t\t\t   |");
                Date date = new Date();
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                System.out.println("| Date: " + f.format(date) + "\t\t\t\t\t   |");
                System.out.println("+------------------------------------------------------------------+");
                System.out.format("|   %-5s|     %-8s|  %-5s  |   %-5s   |    %-12s  |\n", "ID", "NAME", "PRICE", "QUANTITY", "TOTAL PRICE");
                System.out.println("+------------------------------------------------------------------+");
                for (Order order : ordering) {
                    System.out.format("|  %-5s |   %-8s  |   %-5s |      %-5s   |      %-12s|\n", order.getProID(), order.getProName(), order.getProPrice(), order.getProQuantity(), order.getTotalPrice());
                    System.out.println("+------------------------------------------------------------------+");
                }
                System.out.format("|    Total payment:                                %8s VND    |\n", Validation.isCurrency(sum, '.'));
                System.out.println("+------------------------------------------------------------------+");
            }

        } else {
            System.out.println("Your don't have enough point to use discount Mr/Mrs " + aCustomer.getName());
            System.out.println("Your point: " + aCustomer.getPoint());
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("|                            Bill of sale                          |");
            Random rd = new Random();
            int id = rd.nextInt(10000) + 1;
            System.out.println("| Bill ID: " + id + "\t\t\t\t\t\t\t   |");
            Date date = new Date();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            System.out.println("| Date: " + f.format(date) + "\t\t\t\t\t   |");
            System.out.println("+------------------------------------------------------------------+");
            System.out.format("|   %-5s|     %-8s|  %-5s  |   %-5s   |    %-12s  |\n", "ID", "NAME", "PRICE", "QUANTITY", "TOTAL PRICE");
            System.out.println("+------------------------------------------------------------------+");
            for (Order order : ordering) {
                System.out.format("|  %-5s |   %-8s  |   %-5s |      %-5s   |      %-12s|\n", order.getProID(), order.getProName(), order.getProPrice(), order.getProQuantity(), order.getTotalPrice());
                System.out.println("+------------------------------------------------------------------+");
            }
            System.out.format("|    Total payment:                                %8s VND    |\n", Validation.isCurrency(sum, '.'));
            System.out.println("+------------------------------------------------------------------+");
        }
    }

    public void checkNSX() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date of manufacture: " + f.format(date));
        String schoice = "";
        String nsxCheck = Validation.dateToString(date, "dd/MM/yyyy");
        System.out.print("Less than or grater than check date? --> ");
        schoice = sc.nextLine();
        if (schoice.equalsIgnoreCase("Less")) {
            System.out.println("+-------------------------------------------------------------------------------------+");
            System.out.format("|   %-5s|     %-8s|   %-5s  |   %-8s   |       %-3s       |       %-6s     |\n", "ID", "NAME", "PRICE", "QUANTITY", "NSX", "STATUS");
            System.out.println("+-------------------------------------------------------------------------------------+");
            Product tmp = null;
            for (Product thi : this) {
                if (Validation.compareDate(nsxCheck, thi.getNSX()) == 1) {
                    System.out.format("|  %-5s |     %-8s|   %-5s  |      %-5s   |    %-10s   |   %-13s  |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getNSX(), thi.getStatus());
                    System.out.println("+-------------------------------------------------------------------------------------+");
                    tmp = thi;

                }
            }
            if (tmp != null) {
                System.out.println("DATA ACCEPT");
            } else {

                System.out.format("|  %-5s |     %-8s|   %-5s  |    %-8s  |      %-5s      |       %-6s     |\n", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                System.out.println("+-------------------------------------------------------------------------------------+");
                System.out.println("DON'T HAVE DATA!");
            }
        } else {
            System.out.println("+-------------------------------------------------------------------------------------+");
            System.out.format("|   %-5s|     %-8s|   %-5s  |   %-8s   |       %-3s       |       %-6s     |\n", "ID", "NAME", "PRICE", "QUANTITY", "NSX", "STATUS");
            System.out.println("+-------------------------------------------------------------------------------------+");
            Product tmp = null;
            for (Product thi : this) {
                if (Validation.compareDate(nsxCheck, thi.getNSX()) == -1) {
                    System.out.format("|  %-5s |  %-8s   |   %-5s  |      %-5s   |    %-10s   |   %-13s  |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getNSX(), thi.getStatus());
                    System.out.println("+-------------------------------------------------------------------------------------+");
                    tmp = thi;
                }
            }
            if (tmp != null) {
                System.out.println("DATA ACCEPT");
            } else {
                System.out.format("|  %-5s |     %-8s|   %-5s  |    %-8s  |      %-5s      |       %-6s     |\n", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                System.out.println("+-------------------------------------------------------------------------------------+");
                System.out.println("DON'T HAVE DATA!");
            }
        }
    }

    public void checkHSD() {
        String nChoice = "";
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Expiry date: " + f.format(date));
        String nweHsd = Validation.dateToString(date, "dd/MM/yyyy");
        System.out.print("Less than or grater than check date? --> ");
        nChoice = sc.nextLine();
        if (nChoice.equalsIgnoreCase("Less")) {
            System.out.println("+-------------------------------------------------------------------------------------+");
            System.out.format("|   %-5s|     %-8s|   %-5s  |   %-8s   |       %-3s       |       %-6s     |\n", "ID", "NAME", "PRICE", "QUANTITY", "HSD", "STATUS");
            System.out.println("+-------------------------------------------------------------------------------------+");
            Product tmp = null;
            for (Product thi : this) {
                if (Validation.compareDate(nweHsd, thi.getHSD()) == 1) {
                    System.out.format("|  %-5s |     %-8s|   %-5s  |      %-5s   |    %-10s   |   %-13s  |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getHSD(), thi.getStatus());
                    System.out.println("+-------------------------------------------------------------------------------------+");
                    tmp = thi;

                }
            }
            if (tmp != null) {
                System.out.println("DATA ACCEPT");
            } else {

                System.out.format("|  %-5s |     %-8s|   %-5s  |    %-8s  |      %-5s      |       %-6s     |\n", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                System.out.println("+-------------------------------------------------------------------------------------+");
                System.out.println("DON'T HAVE DATA!");
            }

        } else {
            System.out.println("+-------------------------------------------------------------------------------------+");
            System.out.format("|   %-5s|     %-8s|   %-5s  |   %-8s   |       %-3s       |       %-6s     |\n", "ID", "NAME", "PRICE", "QUANTITY", "HSD", "STATUS");
            System.out.println("+-------------------------------------------------------------------------------------+");
            Product tmp = null;
            for (Product thi : this) {
                if (Validation.compareDate(nweHsd, thi.getHSD()) == -1) {
                    System.out.format("|  %-5s |     %-8s|   %-5s  |      %-5s   |    %-10s   |   %-13s  |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getHSD(), thi.getStatus());
                    System.out.println("+-------------------------------------------------------------------------------------+");
                    tmp = thi;

                }
            }
            if (tmp != null) {
                System.out.println("DATA ACCEPT");
            } else {
                System.out.format("|  %-5s |     %-8s|   %-5s  |    %-8s  |      %-5s      |       %-6s     |\n", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
                System.out.println("+-------------------------------------------------------------------------------------+");
                System.out.println("DON'T HAVE DATA!");
            }

        }
    }

    public void bestSeller(int top) {
        int count = 0;
        sortBySaled();;
        for (Product thi : this) {
            count++;
        }
        count = top;
        for (int i = 0; i < count; i++) {
            this.get(i).output();
        }
    }

    public void searchByPrice(float min, float max) {
        Product tmp = null;
        int count = 0;
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        for (Product thi : this) {
            if (Float.parseFloat(thi.getUnitPrice()) > min && Float.parseFloat(thi.getUnitPrice()) < max) {
                System.out.format("|  %-5s |   %-8s  |  %-7s |     %-5s    |   %-5s |   %-10s    |   %-10s    |   %-13s  |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getSaled(), thi.getNSX(), thi.getHSD(), thi.getStatus());
                System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                tmp = thi;
                count++;
            }
        }
        if (tmp != null) {
            System.out.println("Search results -> There are " + count + " products that meet your needs");
        } else {
            System.out.format("|  %-5s |    %-8s |  %-5s  |     %-5s    |  %-5s  |      %-5s      |      %-5s      |       %-5s       |\n", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
            System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
            System.out.println("Search results -> There are no products in your search");
        }
    }

    public void searchByPriceMin(float min) {
        Product tmp = null;
        int count = 0;
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        for (Product thi : this) {
            if (Float.parseFloat(thi.getUnitPrice()) <= min) {
                tmp = thi;
                System.out.format("|  %-5s |   %-8s  |  %-7s |     %-5s    |   %-5s |   %-10s    |   %-10s    |   %-13s  |\n", tmp.getProductID(), tmp.getProductName(), tmp.getUnitPrice(), tmp.getQuantity(), tmp.getSaled(), tmp.getNSX(), tmp.getHSD(), tmp.getStatus());
                System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                count++;
            }
        }
        if (tmp != null) {
            System.out.println("Search results -> There are " + count + " products that meet your needs");
        } else {
            System.out.format("|  %-5s |    %-8s |  %-5s  |     %-5s    |  %-5s  |      %-5s      |      %-5s      |       %-5s       |\n", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
            System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
            System.out.println("Search results -> There are no products in your search");
        }
    }

    public void searchByPriceMax(float max) {
        Product tmp = null;
        int count = 0;
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        for (Product thi : this) {
            if (Float.parseFloat(thi.getUnitPrice()) >= max) {
                tmp = thi;
                System.out.format("|  %-5s |   %-8s  |  %-7s |     %-5s    |   %-5s |   %-10s    |   %-10s    |   %-13s  |\n", tmp.getProductID(), tmp.getProductName(), tmp.getUnitPrice(), tmp.getQuantity(), tmp.getSaled(), tmp.getNSX(), tmp.getHSD(), tmp.getStatus());
                System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                count++;
            }
        }
        if (tmp != null) {
            System.out.println("Search results -> There are " + count + " products that meet your needs");
        } else {
            System.out.format("|  %-5s |    %-8s |  %-5s  |     %-5s    |  %-5s  |      %-5s      |      %-5s      |       %-5s       |\n", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY");
            System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
            System.out.println("Search results -> There are no products in your search");
        }
    }

    public void printListProduct() {
        List<Product> list = FileDAO.readFileProduct();
        int count = -1;
        for (Product p : list) {
            count++;
        }
        for (int i = 0; i <= count; i++) {
            list.get(i).output();
        }
    }
}
