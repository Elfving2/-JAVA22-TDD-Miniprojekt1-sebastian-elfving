package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import triangle.Triangle;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {
    @ParameterizedTest
    @CsvSource(
            {
                    "19;10;27",
                    "20;4;22",
                    "30;21;50"
            }
    )
    @DisplayName("Examples of correct input for a Scalene")
    void correctTypeSCALENE(String list) {
        String[] split = list.split(";");
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));

        System.out.println(Arrays.toString(split));
        System.out.println("list ->" + list);
        System.out.println(triangle.getCurrent_type());
        boolean correct = triangle.getCurrent_type() == Triangle.TYPE.SCALENE;
        assertTrue(correct);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "3;3;3",
                    "2;2;2",
                    "10;10;10"
            }
    )
    @DisplayName("Examples of correct input for a Equilateral")
    void CorrectTypeEQUILATERAL (String list) {
        String[] split = list.split(";");
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));

        System.out.println(Arrays.toString(split));
        System.out.println("list ->" + list);

        boolean correct = triangle.getCurrent_type() == Triangle.TYPE.EQUILATERAL;
       assertTrue(correct);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "3;3;5",
                    "10;10;12",
                    "6;6;8"
            }
    )
    @DisplayName("Examples of correct input for a Isosceles")
    void correctTypeISOSCELES(String list) {
        String[] split = list.split(";");
        Triangle triangle = new Triangle();
        triangle.setCurrent_type(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));

        System.out.println(Arrays.toString(split));
        System.out.println("list ->" + list);

        boolean correct = triangle.getCurrent_type() == Triangle.TYPE.ISOSCELES;
        assertTrue(correct);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "-3;-3;-5",
                    "2;4;20",
                    "1;2;3"
            }
    )
    @DisplayName("Inputs with incorrect values that will set triangleType to null ")
    void inputErrorIntegers(String input) {
        String[] split = input.split(";");
        Triangle triangle = new Triangle();

        triangle.setCurrent_type(Integer.parseInt(split[0]),Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        assertNull(triangle.getCurrent_type());
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "a;b;c",
                    "hej;pre;see",
                    "-;<;>",
                    "3.2;1.4;hej"
            }
    )
    @DisplayName("catches an error if incorrect data type ")
    void inputErrorNonIntegers(String input) {
        String[] split = input.split(";");
        Triangle triangle = new Triangle();
        assertThrows(NumberFormatException.class, () -> {
            triangle.setCurrent_type(Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[2]));

        });
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "a;b;c",
                    "hej;pre;see",
                    "-;<;>",
                    "3.2;1.4;hej"
            }
    )
    @DisplayName("catches wrong input to constructor will set type to null")
    void wrongInputToConstructor(String input) {
        String[] split = input.split(";");
        Triangle triangle = new Triangle(split);
        assertEquals("0, 0, 0, This is not a triangle", triangle.toString());
    }
}