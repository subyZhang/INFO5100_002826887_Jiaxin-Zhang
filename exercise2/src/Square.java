public class Square extends Shape {
    private Double width;
    public Square(Double width){
        this.width=width;
    }
    @Override
    public Double calculateArea() {
        return width*width;
    }

    @Override
    public Double calculatePerimeter() {
        return width*4;
    }
}
