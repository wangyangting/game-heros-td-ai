package com.github.wangyangting;

import com.github.wangyangting.util.HeroTdRobotUtil;
import com.github.wangyangting.util.ImageUtil;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

public class ImageUtilTest {

    @Test
    public void test1() throws Exception {
        BufferedImage sourceImage = ImageUtil.readImageFile("data/image/hero-birth-slz-jjbk.jpg.bak");
        BufferedImage destImage = ImageUtil.readImageFile("data/image/hero-birth-1.jpg");
        float ret = ImageUtil.compareSimilar(sourceImage, destImage);
        System.out.println(ret);
    }

    @Test
    public void test2() throws Exception {
        BufferedImage sourceImage = ImageUtil.readImageFile("data/image/hero-birth-slz-jjbk.jpg.bak");
        BufferedImage destImage = HeroTdRobotUtil.captureBirthHeroImage();
        float ret = ImageUtil.compareSimilar(sourceImage, destImage);
        System.out.println(ret);
    }

}
