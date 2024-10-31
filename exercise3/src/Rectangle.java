 public class Rectangle extends Shape{
    private Double width;
    private Double height;
public Rectangle(Double width,Double height){
    this.width=width;
    this.height=height;
}
     @Override
     public Double calculateArea() {
         return this.width*this.height;
     }

     @Override
     public Double calculatePerimeter() {
         return (this.width+this.height)*2;
     }
 }
