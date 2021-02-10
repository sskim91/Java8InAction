package lambdasinaction.chap10;

import java.util.*;

public class Person {

    private Optional<Car> car;

    private int age;

    public Optional<Car> getCar() {
        return car;
    }

    public int getAge() {
        return age;
    }
}
