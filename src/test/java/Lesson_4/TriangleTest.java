package Lesson_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Positive test_1-Checking the correctness of the data")
    void areaPositiveTest() throws TriangleException {
        logger.info("Positive test_1");
        Triangle triangle = new Triangle(4, 6, 8);
        triangle.area();
        Assertions.assertEquals(11.62, triangle.area());
    }

    @Test
    @DisplayName("Negative test_1-Checking for negative numbers.")
    void areaFirstExceptionTest() {
        logger.info("Negative test_1");
        Assertions.assertThrows(TriangleException.class, () -> areaSecondNegativeTest(), "Исключения отсутствуют");
    }

    private void areaFirstNegativeTest() throws TriangleException {
        Triangle triangle = new Triangle(4, 6, -8);
        triangle.area();
        System.out.println("Negative test_1 - failed");
    }

    @Test
    @DisplayName("Negative test_2-Checking for zero.")
    void areaSecondExceptionTest() {
        logger.info("Negative test_2");
        Assertions.assertThrows(TriangleException.class, () -> areaFirstNegativeTest(), "Исключения отсутствуют");
    }

    private void areaSecondNegativeTest() throws TriangleException {
        Triangle triangle = new Triangle(4, 6, 0);
        triangle.area();
        System.out.println("Negative test_2 - failed");
    }

    @Test
    @DisplayName("Negative test_3-Checking the correctness of the data")
    void areaThirdExceptionTest() {
        logger.info("Negative test_3");
        Assertions.assertThrows(TriangleException.class, () -> areaThirdNegativeTest(), "Исключения отсутствуют");
    }

    private void areaThirdNegativeTest() throws TriangleException {
        Triangle triangle = new Triangle(4, 6, 20);
        triangle.area();
        System.out.println("Negative test_3 - failed");
    }
}