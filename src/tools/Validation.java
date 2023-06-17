package tools;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {

    public static int inputIntNumber(int min, int max, String msg, String errMsg) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print(msg);
                sc = new Scanner(System.in);
                n = sc.nextInt();
                boolean isValid = (n >= min) && (n <= max);
                if (!isValid) {
                    throw new Exception();
                }
                flag = true;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
        return n;
    }

    public static float inputFloatNumber(float min, float max, String msg, String errMsg) {
        Scanner sc = new Scanner(System.in);
        float n = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print(msg);
                sc = new Scanner(System.in);
                n = sc.nextFloat();
                boolean isValid = (n >= min) && (n <= max);
                if (!isValid) {
                    throw new Exception();
                }
                flag = true;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
        return n;
    }

    public static String inputString(String msg, String errMsg, String regex) {
        Scanner sc = new Scanner(System.in);
        String output = "";
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print(msg);
                sc = new Scanner(System.in);
                output = sc.nextLine();
                if (!output.matches(regex)) {
                    throw new Exception();
                }
                flag = true;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
        return output;
    }

    public static String isCurrency(long n, char c) {
        String check = "" + n;
        String result = "";
        int count = 0;
        String rs = "";
        for (int i = check.length() - 1; i >= 0; i--) {
            rs += check.charAt(i);
        }
        String cc = "";
        for (int i = 0; i < rs.length(); i++) {
            count++;
            if (count == 3 && i != rs.length() - 1) {
                cc += rs.charAt(i);
                cc += c;
                count = 0;
            } else {
                cc += rs.charAt(i);
            }
        }
        for (int i = cc.length() - 1; i >= 0; i--) {
            result += cc.charAt(i);
        }
        return result;
    }

    //Check so dao nguoc vs so ban dau
    public static boolean isSym(int n) {
        if (n < 10) {
            return false;
        }
        int n2 = n;
        int n3 = n;
        int count = 0;
        int tmp2 = 0;
        while (n3 > 0) {
            count++;
            n3 = n3 / 10;
        }
        count--;
        while (n > 0) {
            tmp2 += Math.pow(10, count) * (n % 10);
            count--;
            n = n / 10;
        }

        if (tmp2 == n2) {
            return true;
        } else {
            return false;
        }
    }

    //Check chu dao nguoc so voi chu ban dau
    public static boolean isPalin(String str) {
        String result = "";
        boolean ans = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        if (str.equals(result)) {
            ans = true;
        }
        return ans;
    }

    //Check so lap phuong hay khong
    public static boolean isCube(int n) {
        int check = 1;
        int m = (int) Math.round(Math.pow(n, 1.0 / 3.0));
        if (n == m * m * m) {
            check = 0;
        }
        if (check == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSquare(int n) {
        int check = 1;
        int var = (int) Math.sqrt(n);
        if (n == var * var) {
            check = 0;
        }
        if (check == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Check perfect square
    public static boolean isPer(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        if (sum == n) {
            return true;
        } else {
            return false;
        }
    }

    //Check fibo
    public static boolean isFibo(int n) {
        int a1 = 1;
        int a2 = 1;
        if (n == 1) {
            return true;
        }
        if (n < 1) {
            return false;
        }
        while (a2 < n) {
            int tmp = a1;
            a1 = a2;
            a2 = a1 + tmp;
        }
        if (n == a2) {
            return true;
        } else {
            return false;
        }
    }

    public static int compareDate(String date1, String date2) {
        String[] arr = date1.split("/");
        String[] arr1 = date2.split("/");
        if (arr[2].compareTo(arr1[2]) > 0) {
            return 1;
        } else if (arr[2].compareTo(arr1[2]) == 0) {
            if (arr[1].compareTo(arr1[1]) > 0) {
                return 1;
            } else if (arr[1].compareTo(arr1[1]) < 0) {
                return -1;
            } else if (arr[1].compareTo(arr1[1]) == 0) {
                if (arr[0].compareTo(arr1[0]) > 0) {
                    return 1;
                } else if (arr[0].compareTo(arr1[0]) < 0) {
                    return -1;
                }
            }
        }
        return -1;

    }
    
    public static String dateToString(Date date, String dateFormat)
    {
        SimpleDateFormat dff = new SimpleDateFormat();
        dff.applyPattern(dateFormat);
        String strDate = dff.format(date);
        return strDate;
    }
}
