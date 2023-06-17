/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.List;
import java.util.Scanner;
import mng.Menu;
import tools.FileDAO;

/**
 *
 * @author DevDD
 */
public class ProductManager {

    private ProductList productList;
    private Menu menu;
    Scanner sc = new Scanner(System.in);
    int choice = 0;

    public ProductManager() {
        productList = new ProductList();
        menu = new Menu();
    }

    public void productTask() {;
        menu.add("+-------------------------------------------------------------------+");
        menu.add("|                   1. Create a Product                             |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   2. Check exits Product                          |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   3. Search Product’ information by Name          |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   4. Search Product’ information by ID            |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   5. Search Product’ information by Price         |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   6. Sort Product’ information by Name            |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   7. Sort Product’ information by ID              |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   8. Sort Product’ information by Price           |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   9. Update Product                               |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   10. Delete Product                              |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   11. Check Date of manufacture                   |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   12. Check Date of expiry                        |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   13. Print Product list                          |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   14. Buy Product                                 |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   15. Print Customer list                         |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   16. Print Top Seller                            |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   17. Save Products to file                       |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   18. Print list Products from the file           |");
        menu.add("|-------------------------------------------------------------------|");
        menu.add("|                   19. Exit!                                       |");
        menu.add("+-------------------------------------------------------------------+");
        menu.showMenu();
        do {
            choice = menu.getChoice(19, "Enter your choice: ", "Error");
            switch (choice) {
                case 1:
                    productList.createProduct();
                    layout();
                    break;
                case 2:
                    productList.checkExist();
                    layout();
                    break;
                case 3:
                    productList.searchByName();
                    layout();
                    break;
                case 4:
                    productList.searchByID();
                    layout();
                    break;
                case 5:
                    System.out.println("+-----------------------------------------------+");
                    System.out.println("|   Select the price range you want to search   |");
                    System.out.println("+-----------------------------------------------+");
                    System.out.println("|       1. Under 5.000 VND                      |");
                    System.out.println("|       2. From 5.000 VND to 10.000 VND         |");
                    System.out.println("|       3. From 10.000 VND to 20.000VND         |");
                    System.out.println("|       4. Over 20.000 VND                      |");
                    System.out.println("+-----------------------------------------------+");
                    sc = new Scanner(System.in);
                    System.out.print("--> ");
                    int ccc = sc.nextInt();
                    switch (ccc) {
                        case 1:
                            productList.searchByPriceMin(5000);
                            layout();
                            break;
                        case 2:
                            productList.searchByPrice(5000, 10000);
                            layout();
                            break;
                        case 3:
                            productList.searchByPrice(10000, 20000);
                            layout();
                            break;
                        case 4:
                            productList.searchByPriceMax(20000);
                            layout();
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    productList.sortByName1();
                    layout();
                    break;
                case 7:
                    productList.sortByID1();
                    layout();
                    break;
                case 8:
                    productList.sortByPrice1();
                    layout();
                    break;
                case 9:
                    productList.updateProduct();
                    layout();
                    break;
                case 10:
                    productList.deleteProduct();
                    layout();
                    break;
                case 11:
                    productList.checkNSX();
                    layout();
                    break;
                case 12:
                    productList.checkHSD();
                    layout();
                    break;
                case 13:
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                    System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                    productList.sortByID();
                    productList.printListProduct();
                    layout();
                    break;
                case 14:
                    productList.buyProduct();
                    productList.exportBill();
                    layout();
                    break;
                case 15:
                    List<Customer> lineC = FileDAO.readFileCustomer();
                    System.out.println("+----------------------------------------------+");
                    System.out.format("|     %-8s    |    %-9s   |   %-5s   |\n", "CUS_NAME", "CUS_PHONE", "POINT");
                    System.out.println("+----------------------------------------------+");
                    for (Customer customer : lineC) {
                        System.out.format("|    %-12s |   %-11s  |   %-7d |\n", customer.getName(), customer.getPhoneNumber(), customer.getPoint());
                        System.out.println("+----------------------------------------------+");
                    }
                    layout();
                    break;
                case 16:
                    System.out.print("Enter top you want: ");
                    int top = sc.nextInt();
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                    System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                    productList.bestSeller(top);
                    layout();
                    break;
                case 17:
                    FileDAO.writeFileProduct(productList);
                    layout();
                    break;
                case 18:
                    productList.sortByPrice();
                    List<Product> line = FileDAO.readFileProduct();
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                    System.out.format("|   %-5s|     %-8s|  %-5s  |   %-8s   |  %-5s  |       %-3s       |       %-3s       |       %-6s      |\n", "ID", "NAME", "PRICE", "QUANTITY", "SALED", "NSX", "HSD", "STATUS");
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                    for (Product thi : line) {
                        System.out.format("|  %-5s |   %-8s  | %-7s |     %-5s    |   %-5s |   %-10s    |   %-10s    |   %-13s   |\n", thi.getProductID(), thi.getProductName(), thi.getUnitPrice(), thi.getQuantity(), thi.getSaled(), thi.getNSX(), thi.getHSD(), thi.getStatus());
                        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                    }
                    layout();
                    break;
                default:
                    System.out.println("Thank you and see you!");
                    break;
            }

        } while (choice > 0 && choice <= 18);
    }

    public void layout() {
        sc = new Scanner(System.in);
        System.out.println("DO YOU WANT TO GO BACK TO THE MAIN MENU [yes/no]?");
        System.out.print("--> ");
        String c = sc.nextLine();
        switch (c) {
            case "yes":
                menu.showMenu();
                break;
            default:
                System.out.println("GOOD BYE AND SEE YOU AGAIN!!!");
                choice = 19;
                break;
        }
    }
}
