package org.example.oops.enumdemo;

/**
 *
 */
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public void display() {
        System.out.println("Today is " + this.name());
    }
}
