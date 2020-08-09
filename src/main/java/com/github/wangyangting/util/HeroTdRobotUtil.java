package com.github.wangyangting.util;

import com.github.wangyangting.config.HeroConfig;
import com.github.wangyangting.pojo.HeroAttribute;

import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author wangyangting
 * @date 2020-08-02
 */
public class HeroTdRobotUtil {
    public static int DELAY = 300;
    // 英雄位置编号，内圈，从左上往右下，依次编号为 A1 A2 B1 B2 C1 C2 C3 C4 D1 D2 D3 D4

    public static void clickHeroA1() {
        HeroAttribute attribute = HeroUtil.getHeroAttribute("A1");
        RobotUtil.mouseMoveAndClick(attribute.getCenterX(), attribute.getCenterY(), DELAY);
    }

    public static void clickHeroA1Rebirth() {
        HeroAttribute attribute = HeroUtil.getHeroAttribute("A1");
        RobotUtil.mouseMoveAndClick(attribute.getRebirthX(), attribute.getRebirthY(), DELAY);
    }

    public static void clickHeroC1() {
        HeroAttribute attribute = HeroUtil.getHeroAttribute("C1");
        RobotUtil.mouseMoveAndClick(attribute.getCenterX(), attribute.getCenterY(), DELAY);
    }

    public static void clickHeroC1Rebirth() {
        HeroAttribute attribute = HeroUtil.getHeroAttribute("C1");
        RobotUtil.mouseMoveAndClick(attribute.getRebirthX(), attribute.getRebirthY(), DELAY);
    }

    public static void clickHeroRebirth() {
        RobotUtil.mouseMoveAndClick(HeroConfig.HERO_GLOBAL_REBIRTH_X, HeroConfig.HERO_GLOBAL_REBIRTH_Y, DELAY - 200);
    }

    public static void clickHeroC1Deblocking() {
        RobotUtil.mouseMoveAndClick(HeroConfig.HERO_DEBLOCKING_CENTER_X, HeroConfig.HERO_DEBLOCKING_CENTER_Y, DELAY);
    }

    public static void clickHeroC1Reset() {
        RobotUtil.mouseMoveAndClick(HeroConfig.HERO_RESET_CENTER_X, HeroConfig.HERO_RESET_CENTER_Y, DELAY - 200);
    }

    public static void clickPromptSeeVideo() {
        RobotUtil.mouseMoveAndClick(HeroConfig.HERO_PROMPT_SEE_VIDEO_CENTER_X, HeroConfig.HERO_PROMPT_SEE_VIDEO_CENTER_Y, DELAY * 6);
    }

    public static void clickPromptUse() {
        RobotUtil.mouseMoveAndClick(HeroConfig.HERO_PROMPT_USE_CENTER_X, HeroConfig.HERO_PROMPT_USE_CENTER_Y, DELAY - 200);
    }

    public static BufferedImage captureBirthHeroImage() throws IOException {
        return RobotUtil.captureSubScreen(HeroConfig.HERO_C1_LT_X, HeroConfig.HERO_C1_LT_Y, HeroConfig.HERO_C1_RB_OFFSET_X, HeroConfig.HERO_C1_RB_OFFSET_Y);
    }

    public static BufferedImage captureHeroA1RebirthButtonImage() throws IOException {
        return RobotUtil.captureSubScreen(HeroConfig.HERO_A1_REBIRTH_BUTTON_LT_X, HeroConfig.HERO_A1_REBIRTH_BUTTON_LT_Y, HeroConfig.HERO_A1_REBIRTH_BUTTON_RB_OFFSET_X, HeroConfig.HERO_A1_REBIRTH_BUTTON_RB_OFFSET_Y);
    }

    public static BufferedImage captureHeroC1RebirthButtonImage() throws IOException {
        return RobotUtil.captureSubScreen(HeroConfig.HERO_C1_REBIRTH_BUTTON_LT_X, HeroConfig.HERO_C1_REBIRTH_BUTTON_LT_Y, HeroConfig.HERO_C1_REBIRTH_BUTTON_RB_OFFSET_X, HeroConfig.HERO_C1_REBIRTH_BUTTON_RB_OFFSET_Y);
    }

    public static void moveRebirthHeroToA1() throws InterruptedException {
        // 移动到 C1
        RobotUtil.mouseMove(HeroConfig.HERO_C1_CENTER_X, HeroConfig.HERO_C1_CENTER_Y);
//        Thread.sleep(1000);
        // 按下鼠标左键
        RobotUtil.mousePress(InputEvent.BUTTON1_MASK);
//        Thread.sleep(1000);
        // 移动鼠标到 A1
        RobotUtil.mouseMove(307, 313);
//        Thread.sleep(1000);
        // 释放鼠标左键
        RobotUtil.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(1000);
    }

    public static void moveRebirthHeroToA1Repeat(int num) throws InterruptedException {
        for (int i=0; i<num; i++) {
            moveRebirthHeroToA1();
        }
    }

    public static BufferedImage capturePromptSeeVideoImage() throws IOException {
        return RobotUtil.captureSubScreen(200, 600, 175, 54);
    }
}
