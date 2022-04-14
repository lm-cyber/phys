package testbed;

import library.dynamics.Settings;
import testbed.demo.tests.*;

import java.awt.*;

public class DemoText {
    public static Double time=0D;
    public static void draw(Graphics2D g, ColourSettings paintSettings, int demo, double dt) {
        if (!paintSettings.getDrawText()) {
            return;
        }
        g.setColor(Color.white);
        g.setFont(new Font("Calibri", Font.PLAIN, 20));
        switch (demo) {
            case 0 -> drawArray(Chains.text, g, dt);
            case 1 -> drawArray(LineOfSight.text, g, dt);
            case 2 -> drawArray(ParticleExplosionTest.text, g, dt);
            case 3 -> drawArray(ProximityExplosionTest.text, g, dt);
            case 4 -> drawArray(RaycastExplosionTest.text, g, dt);
            case 5 -> drawArray(Raycast.text, g, dt);
            case 6 -> drawArray(Trebuchet.text, g, dt);
            case 7 -> drawArray(SliceObjects.text, g, dt);
            case 8 -> drawArray(BouncingBall.text, g, dt);
            case 9 -> drawArray(MixedShapes.text, g, dt);
            case 10 -> drawArray(NewtonsCradle.text, g, dt);
            case 11 -> drawArray(WreckingBall.text, g, dt);
            case 12 -> drawArray(Friction.text, g, dt);
            case 13 -> drawArray(Drag.text, g, dt);
            case 14 -> drawArray(Restitution.text, g, dt);
            case 15 -> drawArray(StackedObjects.text, g, dt);
            case 16 -> drawArray(Ball.text, g, dt);
        }
    }

    public static void drawArray(String[] lines, Graphics2D g, double dt) {
        drawArray(lines,g);
        time+=dt;

        g.drawString("Time: " + time.toString(),5,120);
    }
    public static void drawArray(String[] lines, Graphics2D g) {
        int y = 20;
        for (String line : lines) {
            g.drawString(line, 5, y);
            y += 20;
        }
        g.drawString("Right click: moves the camera position", 5, y);
        g.drawString("Space: pauses demo", 5, y += 20);
        g.drawString("R: restart current demo", 5, y += 20);
        g.drawString("Hertz: " + Settings.HERTZ, 5, y += 20);
        if (LineOfSight.active) {
            LineOfSight.drawInfo(g, 5, y+=20);
        }
    }
}
