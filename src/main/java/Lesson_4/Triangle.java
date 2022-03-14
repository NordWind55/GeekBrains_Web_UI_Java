package Lesson_4;

public class Triangle {

    private int SideTriangle_A;
    private int SideTriangle_B;
    private int SideTriangle_C;

    public Triangle(int sideTriangle_A, int sideTriangle_B, int sideTriangle_C) {
        SideTriangle_A = sideTriangle_A;
        SideTriangle_B = sideTriangle_B;
        SideTriangle_C = sideTriangle_C;
    }

    public int getSideTriangle_A() {
        return SideTriangle_A;
    }

    public int getSideTriangle_B() {
        return SideTriangle_B;
    }

    public int getSideTriangle_C() {
        return SideTriangle_C;
    }

    public Double area()throws TriangleException {
        //Пороверка на ноль
        if(getSideTriangle_A()==0|getSideTriangle_B()==0|getSideTriangle_C()==0)
            throw new TriangleException("Ошибка! Как минимум одна из сторон равна нулю.");

        //Пороверка на отрицательное значение
        if(getSideTriangle_A()<0|getSideTriangle_B()<0|getSideTriangle_C()<0)
            throw new TriangleException("Ошибка! Как минимум одна из сторон меньше нуля.");

        //Пороверка на треугольник
        if(((getSideTriangle_A()+getSideTriangle_B())<=getSideTriangle_C())|(getSideTriangle_A()+getSideTriangle_C()<=getSideTriangle_B())|(getSideTriangle_B()+getSideTriangle_C()<=getSideTriangle_A()))
            throw new TriangleException("Ошибка! Сумма двух сторон меньше или равна третьей.");

        //Находим площадь треугольника
        Double P=(getSideTriangle_A()+getSideTriangle_B()+getSideTriangle_C())/2.0;
        Double S=(Math.sqrt(P*(P-getSideTriangle_A())*(P-getSideTriangle_B())*(P-getSideTriangle_C())))*100;
        S=(Math.ceil(S))/100;
//        System.out.println(S);
        return S;
    }
}
