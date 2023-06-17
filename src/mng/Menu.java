/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DevDD
 */
public class Menu {
    List<String> menu = new ArrayList<String>();
     public void add(String item)
     {
         menu.add(item);
     }
    public void showMenu() 
    {
        for(String o : menu) 
        {
            System.out.println(o);
        }
    }
    
    public int getChoice(int soluong, String message, String err)
    {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {            
            System.out.print(message);
            choice = sc.nextInt();
            if (choice <= soluong && choice > 0)
            {
                break;
            }else System.out.println(err);
        } while (choice > soluong || choice <= 0);
        return choice;
    }
}
