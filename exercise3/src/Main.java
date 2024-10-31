
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Shape re = new Rectangle(2.0,5.0);
        Shape    ci = new Circle(3.0);
        Shape    sq = new Square(7.0);
        Shape  tr = new Triangle(10.0,15.0);

        System.out.println("area:"+re.calculateArea());
        System.out.println("Perimeter:"+re.calculatePerimeter());
        System.out.println("area:"+ci.calculateArea());
        System.out.println("Perimeter:"+ci.calculatePerimeter());
        System.out.println("area:"+sq.calculateArea());
        System.out.println("Perimeter:"+sq.calculatePerimeter());
        System.out.println("area:"+tr.calculateArea());
        System.out.println("Perimeter:"+tr.calculatePerimeter());

        Rectangle.color = "red";
        System.out.println(Shape.color);
        Triangle.color = "blue";
        System.out.println(Rectangle.color);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("circle.ser"));
        oos.writeObject(ci);
        System.out.println("circle serialization ");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("circle.ser"));
        Circle circle=(Circle)ois.readObject();
        System.out.println("circle deserialization:"+circle);
        System.out.println("circle calculate area:"+circle.calculateArea());

    }
}
