package Lesson_4;

public class AreaOfTriangle {

    public static void main(String[] args) throws TriangleException {
        Triangle triangle = new Triangle(4, 6, 8);
        System.out.println(triangle.area());
    }
}