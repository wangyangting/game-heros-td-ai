package com.github.wangyangting;

import com.github.wangyangting.util.HeroTdRobotUtil;
import com.github.wangyangting.util.ImageUtil;
import com.github.wangyangting.util.RobotUtil;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RobotUtilTest {

    @Test
    public void captureFullScreenImageSaveToFileTest() throws IOException {
        RobotUtil.captureFullScreenSaveToFile("test/full-a-1.jpg");
    }

    @Test
    public void captureSubScreenImageSaveToFileTest() throws IOException {
        RobotUtil.captureSubScreenSaveToFile("test/prompt-see-video.jpg", 49, 378, 440, 285);
    }

    @Test
    public void captureHeroBirthImageSaveToFileTest() throws IOException {
        BufferedImage image = HeroTdRobotUtil.captureBirthHeroImage();
        String filePath = "test/hero-birth-slz-jjbk.jpg";
        ImageUtil.saveImageToFile(image, filePath);;
    }

    @Test
    public void mouseLeftClickTest() {
        RobotUtil.mouseMoveAndClick(290, 258, 500);
    }

}
