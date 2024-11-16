package com.interviewprep.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class VehicleWriteMain {
    public static void main(String[] args) {
        Vehicle v1= new Vehicle("Tata", 2024, 10);
        try(FileOutputStream fout = new FileOutputStream("vehicle.txt");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            ) {
            oout.writeObject(v1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
