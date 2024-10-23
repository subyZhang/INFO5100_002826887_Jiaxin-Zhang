public class Triangle extends Shape{
    private Double baseLength;
    private Double height;
    public Triangle(Double baseLength,Double height){
        this.baseLength=baseLength;
        this.height=height;
    }
    @Override
    public Double calculateArea() {
        return this.baseLength*this.height/2;
    }

    @Override
    public Double calculatePerimeter() {
        double halfBase = this.baseLength / 2;
        double sideLength = Math.sqrt(Math.pow(halfBase, 2) + Math.pow(height, 2));
        return this.baseLength + 2 * sideLength;
    }
}
