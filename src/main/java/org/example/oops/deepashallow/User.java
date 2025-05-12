package org.example.oops.deepashallow;

public class User implements Cloneable{
    public String name;
    public int rollNo;
    public Address address;

    public User(String name, int rollNo, Address address) {
        this.name = name;
        this.rollNo = rollNo;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", address=" + address +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      return super.clone();
    }
}
