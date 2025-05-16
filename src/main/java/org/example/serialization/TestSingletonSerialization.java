package org.example.serialization;

import java.io.*;

class Singleton implements Serializable {

    private static final long serialVersionUID = 1L;

    // Step 1: Declare the private static instance for the singleton
    private static Singleton instance;

    // Step 2: Create a private constructor to prevent direct instantiation
    private Singleton() {}

    // Step 3: Provide a public static method to get the singleton instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Step 4: Implement readResolve to return the same instance during deserialization
    private Object readResolve() {
        return getInstance();
    }

    public void displayMessage(){
        System.out.println("Singleton instance: "+ instance);
    }
}

public class TestSingletonSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Step 1: Serialize the singleton object
        Singleton singleton = Singleton.getInstance();
        singleton.displayMessage();

        FileOutputStream fileOut=new FileOutputStream("singleton.ser");
        ObjectOutputStream out=new ObjectOutputStream(fileOut);
        out.writeObject(singleton);
        out.close();
        fileOut.close();

        // Step 2: Deserialize the singleton object
        Singleton singleton1=null;
        FileInputStream fileIn=new FileInputStream("singleton.ser");
        ObjectInputStream in=new ObjectInputStream(fileIn);
         singleton1=(Singleton) in.readObject();
        in.close();
        fileIn.close();
        singleton1.displayMessage();    //should show same instance as singleton

    }
}