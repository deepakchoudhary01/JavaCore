package org.example.oops.deepashallow;

public class UserDeep implements Cloneable{
    public String name;
    public int rollNo;
    public AddressDeep address;

    public UserDeep(String name, int rollNo, AddressDeep address) {
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
        UserDeep cloned= (UserDeep) super.clone();
        cloned.address = (AddressDeep) this.address.clone();
        return cloned;
    }
}
