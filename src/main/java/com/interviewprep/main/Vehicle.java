package com.interviewprep.main;

import java.io.*;
import java.util.Objects;

public class Vehicle implements Externalizable {

    @Serial
    private static final long serialVersionUID = 142L;

    private String name;
    private int modelYear;
    private int mileage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Vehicle(String name, int modelYear, int mileage) {
        this.name = name;
        this.modelYear = modelYear;
        this.mileage = mileage;
    }

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return modelYear == vehicle.modelYear && mileage == vehicle.mileage && Objects.equals(name, vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, modelYear, mileage);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name.toUpperCase());
        out.write(modelYear);
        out.write(mileage);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        modelYear = in.read();
        mileage = in.read();
    }
}
