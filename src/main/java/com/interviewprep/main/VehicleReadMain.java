package com.interviewprep.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class VehicleReadMain {
    public static void main(String[] args) {
        try(FileInputStream fin = new FileInputStream("vehicle.txt");
            ObjectInputStream oin = new ObjectInputStream(fin);
        ) {
            Vehicle v = (Vehicle) oin.readObject();
           System.out.println(v);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
