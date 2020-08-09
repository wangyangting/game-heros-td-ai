package com.github.wangyangting;

import com.github.wangyangting.util.HeroTdRobotUtil;
import com.github.wangyangting.util.ImageUtil;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class HeroTdRobotUtilTest {

    @Test
    public void testClickHeroA1() {
        HeroTdRobotUtil.clickHeroA1();
    }

    @Test
    public void testIsSlz() throws IOException {
        BufferedImage heroBirthImage = HeroTdRobotUtil.captureBirthHeroImage();
        BufferedImage heroSlzJjbkImage = ImageUtil.readImageFile("data/image/hero-birth-slz-jjbk.jpg");
        // 3.2 比较是否是射手英雄 狩猎者-加加比克
        boolean isSlzJjbk = ImageUtil.isSimilar(heroBirthImage, heroSlzJjbkImage);
        System.out.println(isSlzJjbk);
    }

    @Test
    public void testMoveC1ToA1() throws InterruptedException {
        HeroTdRobotUtil.moveRebirthHeroToA1();
    }

}
