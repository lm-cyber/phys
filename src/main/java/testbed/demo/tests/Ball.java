package testbed.demo.tests;

import library.dynamics.Body;
import library.dynamics.World;
import library.geometry.Circle;
import library.joints.Joint;
import library.joints.JointToPoint;
import library.math.Vectors2D;
import testbed.demo.TestBedWindow;

public class Ball {
    public static  String[] text = {"Ball"};

    public static void load(TestBedWindow testBedWindow, Double g) {
        testBedWindow.setWorld(new World(new Vectors2D(0, -g)));
        World temp = testBedWindow.getWorld();
        testBedWindow.setCamera(new Vectors2D(0, -250), 1.7);

        {
            Body b2 = new Body(new Circle(10.0), -60, -500 );
            b2.setDensity(2);
            temp.addBody(b2);

            Joint j = new JointToPoint(new Vectors2D(0, 0), b2, 504, 100000 , 10, false, new Vectors2D());
            temp.addJoint(j);
        }
    }
}
