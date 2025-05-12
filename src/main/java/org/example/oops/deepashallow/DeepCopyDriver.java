package org.example.oops.deepashallow;

public class DeepCopyDriver {
    public static void main(String[] args) throws CloneNotSupportedException{
        AddressDeep address = new AddressDeep("Pune", "India");
        UserDeep obj1 = new UserDeep("Rahul", 1, address);

        UserDeep obj2 = (UserDeep) obj1.clone();
        System.out.println(obj1);

        obj1.address.city = "Mumbai";
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
