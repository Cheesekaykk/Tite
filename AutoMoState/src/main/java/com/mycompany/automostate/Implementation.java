/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.automostate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jp Miravalles
 */
public class Implementation {
    
    static final String FILENAME = "information.txt";
    static String fname = null;
    static String lname = null;
    static String add = null;
    static String email = null;
    static String contact = null;
    static String car = null;
    static String park = null;
    static String process = null;
    static String date = null;

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        Implementation.date = date;
    }

    public static ArrayList<String> getInfo() {
        return info;
    }

    public static void setInfo(ArrayList<String> info) {
        Implementation.info = info;
    }
    static ArrayList<String> info = new ArrayList<String>();

    public static String getFname() {
        return fname;
    }

    public static void setFname(String fname) {
        Implementation.fname = fname;
    }

    public static String getLname() {
        return lname;
    }

    public static void setLname(String lname) {
        Implementation.lname = lname;
    }

    public static String getAdd() {
        return add;
    }

    public static void setAdd(String add) {
        Implementation.add = add;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Implementation.email = email;
    }

    public static String getContact() {
        return contact;
    }

    public static void setContact(String contact) {
        Implementation.contact = contact;
    }

    public static String getCar() {
        return car;
    }

    public static void setCar(String car) {
        Implementation.car = car;
    }

    public static String getPark() {
        return park;
    }

    public static void setPark(String park) {
        Implementation.park = park;
    }
    
     public static String getProcess() {
         return process;
    }

    public static void setProcess(String process) {
        Implementation.process = process;
    }
    
    public void saveInfo(){
        info.add(Implementation.getFname());
        info.add(Implementation.getLname());
        info.add(Implementation.getAdd());
        info.add(Implementation.getEmail());
        info.add(Implementation.getContact());
        info.add(Implementation.getCar());
        info.add(Implementation.getPark());
        info.add(Implementation.getProcess());
        info.add(Implementation.getDate());
            
        try {
            FileWriter writer = new FileWriter(FILENAME,true);
            BufferedWriter bwriter = new BufferedWriter(writer);
            String joined = String.join(", ", info);
            bwriter.write(joined);
            bwriter.newLine();
            bwriter.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        } 
        info.clear();
    } 
    
    
    
    public static void readInfo( ) {
        try {
            Scanner scanner = new Scanner(new File(FILENAME));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(", ");
            fname = fields[0];
            lname = fields[1];
            add = fields[2];
            email = fields[3];
            contact = fields[4];
            car = fields[5];
            park = fields[6];
            process = fields[7];
            date = fields[8];
            String dataLine = fname + ", " + lname + ", " + add + ", " + email + ", " + contact + ", " + car + ", " + park + ", " + process + ", " + date;
            info.add(dataLine);
        }
        scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    public static void sortFname(ArrayList<String> info) {
        int n = info.size();
        for (int i = 1; i < n; i++) {
            String key = info.get(i);
            int j = i - 1;
            while (j >= 0 && compare(info.get(j), key) > 0) {
                info.set(j + 1, info.get(j));
                j--;
        }
        info.set(j + 1, key);
        }
        try {
            File file = new File("insert.txt");
            if (file.exists()) {
                file.delete();
            }
            FileWriter writer = new FileWriter(file);
            for (String line : info) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        info.clear();
    }
    private static int compare(String s1, String s2) {
        String[] fields1 = s1.split(", ");
        String[] fields2 = s2.split(", ");
        return fields1[0].compareTo(fields2[0]);
    }
    public static void sortLname(ArrayList<String> info) {
        int n = info.size();
        for (int i = 1; i < n; i++) {
            String key = info.get(i);
            int j = i - 1;
            while (j >= 0 && compare2(info.get(j), key) > 0) {
                info.set(j + 1, info.get(j));
                j--;
        }
        info.set(j + 1, key);
        }
        try {
            File file = new File("insert2.txt");
            if (file.exists()) {
                file.delete();
            }
            FileWriter writer = new FileWriter(file);
            for (String line : info) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        info.clear();
    }
    private static int compare2(String s1, String s2) {
        String[] fields1 = s1.split(", ");
        String[] fields2 = s2.split(", ");
        return fields1[1].compareTo(fields2[1]);
    }
    public static void sortAdd(ArrayList<String> info) {
        int n = info.size();
        for (int i = 1; i < n; i++) {
            String key = info.get(i);
            int j = i - 1;
            while (j >= 0 && compare3(info.get(j), key) > 0) {
                info.set(j + 1, info.get(j));
                j--;
        }
        info.set(j + 1, key);
        }
        try {
            File file = new File("insert3.txt");
            if (file.exists()) {
                file.delete();
            }
            FileWriter writer = new FileWriter(file);
            for (String line : info) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        info.clear();
    }
    private static int compare3(String s1, String s2) {
        String[] fields1 = s1.split(", ");
        String[] fields2 = s2.split(", ");
        return fields1[5].compareTo(fields2[5]);
}
    public static void sortCar(ArrayList<String> info) {
        int n = info.size();
        for (int i = 1; i < n; i++) {
            String key = info.get(i);
            int j = i - 1;
            while (j >= 0 && compare4(info.get(j), key) > 0) {
                info.set(j + 1, info.get(j));
                j--;
        }
        info.set(j + 1, key);
        }
        try {
            File file = new File("insert4.txt");
            if (file.exists()) {
                file.delete();
            }
            FileWriter writer = new FileWriter(file);
            for (String line : info) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        info.clear();
    }
    private static int compare4(String s1, String s2) {
        String[] fields1 = s1.split(", ");
        String[] fields2 = s2.split(", ");
        return fields1[6].compareTo(fields2[6]);
}
    
    public static void sortDate(ArrayList<String> info) {
        int n = info.size();
        for (int i = 1; i < n; i++) {
            String key = info.get(i);
            int j = i - 1;
            while (j >= 0 && compare5(info.get(j), key) > 0) {
                info.set(j + 1, info.get(j));
                j--;
        }
        info.set(j + 1, key);
        }
        try {
            File file = new File("insert5.txt");
            if (file.exists()) {
                file.delete();
            }
            FileWriter writer = new FileWriter(file);
            for (String line : info) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        info.clear();
    }
    private static int compare5(String s1, String s2) {
        String[] fields1 = s1.split(", ");
        String[] fields2 = s2.split(", ");
        return fields1[7].compareTo(fields2[7]);
}
}
