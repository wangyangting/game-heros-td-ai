package com.github.wangyangting.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author wangyangting
 * @date 2020-08-02
 */
public class RobotUtil {
    public static Robot robot;
    public static int DELAY = 500;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void captureFullScreenSaveToFile(String filePath) throws IOException {
        BufferedImage image = captureFullScreen();
        File file = new File(filePath);
        ImageIO.write(image, "jpg", file);
    }

    public static void captureSubScreenSaveToFile(String filePath, int ltX, int ltY, int rbX, int rbY) throws IOException {
        BufferedImage image = captureSubScreen(ltX, ltY, rbX, rbY);
        File file = new File(filePath);
        ImageIO.write(image, "jpg", file);
    }

    public static BufferedImage captureSubScreen(int ltX,int ltY, int rbX, int rbY) throws IOException {
        BufferedImage fullImage = captureFullScreen();
        BufferedImage subImage = fullImage.getSubimage(ltX, ltY, rbX, rbY);
        return subImage;
    }

    public static BufferedImage captureFullScreen() throws IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        return robot.createScreenCapture(screenRectangle);
    }

    public static void mouseLeftClick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void mouseMoveAndClick(int x, int y, int delay) {
        mouseMove(x, y);
        robot.delay(delay);
        mouseLeftClick();
    }

    public static void keyPress(int keyCode) {
        robot.keyPress(keyCode);
        robot.delay(DELAY);
    }

    public static void keyRelease(int keyCode) {
        robot.keyRelease(keyCode);
        robot.delay(DELAY);
    }

    public static void mousePress(int keyCode) {
        robot.mousePress(keyCode);
    }

    public static void mouseMove(int x, int y) {
        robot.mouseMove(x, y);
        robot.delay(DELAY);
    }

    public static void mouseRelease(int keyCode) {
        robot.mouseRelease(keyCode);
        robot.delay(DELAY);
    }

}
