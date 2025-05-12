package org.example.oops.deepashallow;

public class ShallowDriver {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Pune", "India");
        User obj1 = new User("Rahul", 1, address);

        User obj2 = (User) obj1.clone();
        System.out.println(obj1);

        obj1.address.city = "Mumbai";
        System.out.println(obj1);
        System.out.println(obj2);
    }
}

