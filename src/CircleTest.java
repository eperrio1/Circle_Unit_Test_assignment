import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    private double[] rad = {0.0, 10.0, 100.0, 1000.0, -10.0};

    private double[] update_rad = {4.0, 7.6, 8.5, 6.9, -90.0};


    private double[] area = {0.0, 314.1592653589793, 31415.926535897932, 3141592.653589793, 0.0};

    private double[] cir = {0.0, 62.83185307179586, 628.3185307179587, 6283.185307179586, 0.0};

    private ArrayList<Circle> circleList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Do I need to add an assert?
        //assert (rad.length == rad.length);

        circleList = new ArrayList<>();

        for (int ndx = 0; ndx < rad.length; ndx++){
            Circle ba = new Circle(rad[ndx]);
            circleList.add(ba);
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        circleList = null;
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        for (Circle circle: circleList){
            System.out.println(circle);
        }
    }


    @org.junit.jupiter.api.Test
    void testEquals() {
        assert(circleList.size() == rad.length);

        // test line 23 in circle
        for(Circle circle: circleList){
            assertEquals(circle, circle);
        }
        for(Circle circle : circleList){
            Circle shallowcopy = circle;
            assertEquals(circle, shallowcopy);

            // check line 24 in circle
            Circle nullPointer = null;
            assertFalse(circle.equals(nullPointer));
            assertFalse(circle.equals("not a radius"));
        }

        // test line 31-36 in circle
        for(int ndx = 0; ndx < rad.length; ndx++){
            // makes new circle, with the same info from other circles
            Circle other_circle = new Circle(rad[ndx]);
            assertNotSame(other_circle, circleList.get(ndx));
            assertEquals(other_circle, circleList.get(ndx));

            // make a circle with a diff rad
            double unequal_rad = rad[ndx] + 5;
            Circle unequal_circle = new Circle(unequal_rad);
            // System.out.println("unequal circle" + unequal_circle);
            if(unequal_rad > 0){
                assertNotEquals(unequal_circle, circleList.get(ndx));
            }


        }
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        assert(circleList.size() == rad.length);

        for(int ndx = 0; ndx < rad.length; ndx++){
            Circle ba = circleList.get(ndx);
            Circle other_ba = new Circle(rad[ndx]);
            assertNotSame(other_ba, ba);
            assertEquals(other_ba.hashCode(), ba.hashCode());
        }
    }

    @org.junit.jupiter.api.Test
    void getRadius() {
        assert(circleList.size() == rad.length);
        for (int ndx = 0; ndx < circleList.size(); ndx++){
            Double the_rad = circleList.get(ndx).getRadius();
            Double exp_rad = rad[ndx] >= 0 ? rad[ndx] : 0;
            assertEquals(exp_rad, the_rad);
        }
    }


    @Test
    void setRadius() {
        assert (circleList.size() == update_rad.length);

        for (int ndx = 0; ndx < circleList.size(); ndx++){
            circleList.get(ndx).setRadius(update_rad[ndx]);
            double current_rad = circleList.get(ndx).getRadius();
            double expected_rad = update_rad[ndx] >= 0 ? update_rad[ndx] : 0 ;
            // Circle updated_rad = new Circle(new_rad);
            assertEquals(expected_rad, current_rad);

        }

    }

    @org.junit.jupiter.api.Test
    void getCircumference() {
        assert(circleList.size() == cir.length);
        for (int ndx = 0; ndx < circleList.size(); ndx++){
            double the_circum = circleList.get(ndx).getCircumference();
            double exp_circum = cir[ndx] > 0 ? cir[ndx] :0;
            assertEquals(exp_circum, the_circum);
        }
    }

    @org.junit.jupiter.api.Test
    void getArea() {
        assert(circleList.size() == area.length);
        for (int ndx = 0; ndx < circleList.size(); ndx++){
            double the_area = circleList.get(ndx).getArea();
            double exp_area = area[ndx] > 0 ? area[ndx]: 0;
            assertEquals(exp_area, the_area);
        }
    }
}