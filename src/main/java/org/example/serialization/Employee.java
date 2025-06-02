package org.example.serialization;

import java.io.*;

public class Employee implements Externalizable {

    private String name;
    private int age;

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name=(String)in.readObject();
        age=-1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee e1=new Employee("Deepak", 30);

        //serialize
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("emp.ser"));
        oos.writeObject(e1);
        oos.close();

        //deserialize
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("emp.ser"));
        Employee e2=(Employee) ois.readObject();
        ois.close();
        System.out.println(e2);
    }
}
