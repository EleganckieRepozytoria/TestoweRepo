package com.company;

import java.awt.AWTException;
    import java.awt.Dimension;
    import java.awt.Rectangle;
    import java.awt.Robot;
    import java.awt.Toolkit;
    import java.awt.event.KeyEvent;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;

    import javax.imageio.ImageIO;

    public class RobotTest {
        Robot robot;

        public RobotTest() {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                System.err.println("Co ten robot wyprawia?!");
                e.printStackTrace();
            }
        }

        /*
         * Metoda drukuje tekst "Elegancko"
         * TU ZOSTAWCIE KURSOR PRZED URUCHOMIENIEM !!!
         * testowy
         *  tekst
         *   od
         *    madzi
         */
        public void printText() {
            String to_print = "testowy \n tekst \n od \n Madzi";
            for(int i=0; i<to_print.length(); i++)
            {
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(to_print.charAt(i)));
                robot.delay(200);
            }
        }

        /*
         * Metoda robi screenshot ekranu i zapisuje go na dysku
         */
        public void screenCapture() {
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rectangle = new Rectangle(dimension);
            //screenshot
            BufferedImage screen = robot.createScreenCapture(rectangle);
            try {
                ImageIO.write(screen, "jpg", new File("screenshot.jpg"));
            } catch (IOException e) {
                System.err.println("Błąd zapisu obrazu");
                e.printStackTrace();
            }
        }

        /**
         * Test!
         */
        public static void main(String[] args) {
            RobotTest test = new RobotTest();
            test.robot.delay(3000);
            test.printText();
            test.screenCapture();
        }
    }