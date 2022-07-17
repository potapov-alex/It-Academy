package by.itacademy.selenium.patterns.open_closed;

public class Circle implements Shape {
    public double radius;

    public double calculateArea() {
        return (22 / 7) * radius * radius;
    }
}

