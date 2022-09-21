import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    private double[] rad = {0.0, 10.0, 100.0, 1000.0, -10.0};

    private double[] update_rad = {4.0, 7.6, 8.5, 6.9, -90.0};


    private double[] area = {0.0, 314.1592653589793, 31415.926535897932, 3141592.653589793, 0.0};

    private double[] cir = {0.0, 62.83185307179586, 628.3185307179587, 6283.185307179586, 0.0};

    private ArrayList<Circle> baList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Do I need to add an assert?
        assert (rad.length == rad.length);

        baList = new ArrayList<>();

        for (int ndx = 0; ndx < rad.length; ndx++){
            Circle ba = new Circle(rad[ndx]);
            baList.add(ba);
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        baList = null;
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        for (Circle circle: baList){
            System.out.println(circle);
        }
    }


    @org.junit.jupiter.api.Test
    void testEquals() {
        assert(baList.size() == rad.length);

        for(Circle circle: baList){
            assertEquals(circle, circle);
        }
        for(Circle circle : baList){
            Circle shallowcopy = circle;
            assertEquals(circle, shallowcopy);
            Circle nullPointer = null;
            assertFalse(circle.equals(nullPointer));
            assertFalse(circle.equals("not a radius"));
        }
        for(int ndx = 0; ndx < rad.length; ndx++){
            Circle other_ba = new Circle(rad[ndx]);
            assertNotSame(other_ba, baList.get(ndx));

            Circle unequal_ba = new Circle(rad[ndx]);
            assertNotSame(unequal_ba, baList.get(ndx));

        }
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        assert(baList.size() == rad.length);

        for(int ndx = 0; ndx < rad.length; ndx++){
            Circle ba = baList.get(ndx);
            Circle other_ba = new Circle(rad[ndx]);
            assertNotSame(other_ba, ba);
            assertEquals(other_ba.hashCode(), ba.hashCode());
        }
    }

    @org.junit.jupiter.api.Test
    void getRadius() {
        for (int ndx = 0; ndx < baList.size(); ndx++){
            Double the_rad = baList.get(ndx).getRadius();
            Double exp_rad = rad[ndx] > 0 ? rad[ndx] : 0;
            assertEquals(exp_rad, the_rad);
        }
    }


    @Test
    void setRadius() {
        assert (baList.size() == update_rad.length);

        for (int ndx = 0; ndx < baList.size(); ndx++){
            double current_rad = baList.get(ndx).getRadius();
            double new_rad = update_rad[ndx];
            Circle updated_rad = new Circle(new_rad);
            assertNotSame(updated_rad.getRadius(), current_rad);

        }

    }

    @org.junit.jupiter.api.Test
    void getCircumference() {
        for (int ndx = 0; ndx < baList.size(); ndx++){
            double the_circum = baList.get(ndx).getCircumference();
            double exp_circum = cir[ndx] > 0 ? cir[ndx] :0;
            assertEquals(exp_circum, the_circum);
        }
    }

    @org.junit.jupiter.api.Test
    void getArea() {
        for (int ndx = 0; ndx < baList.size(); ndx++){
            double the_area = baList.get(ndx).getArea();
            double exp_area = area[ndx] > 0 ? area[ndx]: 0;
            assertEquals(exp_area, the_area);
        }
    }
}