package com.interviewprep.main;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;

public class MapLearn {
    public static void main(String[] args) {
        HashMap<Person, Integer> map = new HashMap<Person, Integer>();
        for(int i=0;i<100;i++) {
            map.put(new Person("Jon"),1);
        }
        System.out.println(map.size());
        map.entrySet().forEach(m->{
            System.out.println("Hashcode: "+m.hashCode());
            System.out.println("Key: "+m.getKey());
            System.out.println("Value: "+m.getValue());
        });

        try {
            Field tableField = HashMap.class.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] table = (Object[]) tableField.get(map);
            System.out.println("Current Number of Buckets: "+(table == null ? 0 : table.length));
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}

class Person {
    public String name;
    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        Person p = (Person) obj;
        return Objects.equals(this.name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
