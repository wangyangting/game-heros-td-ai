package com.github.wangyangting.ai;

import com.github.wangyangting.util.HeroTdRobotUtil;
import com.github.wangyangting.util.ImageUtil;
import com.github.wangyangting.util.RobotUtil;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangyangting
 * @date 2020-08-01
 */
public class AutoRebirthAi {
    public static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static int rebirthHeroCount = 0;
    public static int rebirthHeroSlzJjbkCount = 0;
    public static int currentRebirthCount  = 0;
    public static long startTime = 0;

    public static void main(String[] args) throws Exception {
        init();

        doForever();
    }

    private static void init() throws IOException {
        // 时间
        startTime = System.currentTimeMillis();

        // 1. A1 英雄重生按钮的 Image
//        ImageUtil.saveImageToFile(HeroTdRobotUtil.captureHeroA1RebirthButtonImage(), "data/image/hero-A1-rebirth-button.jpg");

        // 3. C1 英雄出生的 Image
//        ImageUtil.saveImageToFile(HeroTdRobotUtil.captureBirthHeroImage(), "data/image/hero-birth-slz-jjbk.jpg");


        // 4. 提示: 看视频的 Image
//        ImageUtil.saveImageToFile(HeroTdRobotUtil.capturePromptSeeVideoImage(), "data/image/prompt-see-video.jpg");



        /* 这个暂时用不到了
          // 2. C1 英雄重生按钮的 Image
//        ImageUtil.saveImageToFile(HeroTdRobotUtil.captureHeroC1RebirthButtonImage(), "data/image/hero-C1-rebirth-button.jpg");
*/
    }

    private static void doForever() throws Exception {
        while (true) {
            doRebirthAi();
            Thread.sleep(1000 * 3);
            doSpeedAndMan();
        }
    }

    private static void doRebirthAi() throws Exception {
        // 1. 多余的操作
        // 1.1 多点一次使用（可能会误触到小人）
        HeroTdRobotUtil.clickPromptUse();
        // 1.2 移动到左下角，取消点击
        RobotUtil.mouseMoveAndClick(170, 935, 300);

        // 2.2 A1 英雄的重生按钮判断
        // 点击英雄 A1
        HeroTdRobotUtil.clickHeroA1();
        // 这里需要睡久一点，不然可能截不到图
        Thread.sleep(5000);
        BufferedImage heroA1RebirthButtonImage = HeroTdRobotUtil.captureHeroA1RebirthButtonImage();
        BufferedImage tmpImage = ImageUtil.readImageFileFirstCache("data/image/hero-A1-rebirth-button.jpg");
        boolean isSimilar = ImageUtil.isSimilar(heroA1RebirthButtonImage, tmpImage);
        if (isSimilar) {
            // A1 有重生按钮
            // 让 A1 的英雄重生
            HeroTdRobotUtil.clickHeroA1Rebirth();
            // 判断是否有重生按钮
            HeroTdRobotUtil.clickHeroRebirth();
        } else {
            // A1 有没重生按钮
            // 3. 比较是否是射手英雄 狩猎者-加加比克
//            int currentRebirthCount  = 0;
            while (true) {
                // 当前重生次数 +1
                currentRebirthCount ++;
                // 重生次数 +1
                rebirthHeroCount += 1;
                // 移动到左下角，取消点击
                RobotUtil.mouseMoveAndClick(170, 935, 100);
                // 3.1 抓取英雄出生的图片
                BufferedImage heroBirthImage = HeroTdRobotUtil.captureBirthHeroImage();
                BufferedImage heroSlzJjbkImage = ImageUtil.readImageFileFirstCache("data/image/hero-birth-slz-jjbk.jpg");
                // 3.2 比较是否是射手英雄 狩猎者-加加比克
                boolean isSlzJjbk = ImageUtil.isSimilar(heroBirthImage, heroSlzJjbkImage);
                if (isSlzJjbk) {
                    currentRebirthCount = 0;
                    rebirthHeroSlzJjbkCount += 1;
                    long stopTime = System.currentTimeMillis();
                    long elapsedTime = stopTime - startTime;
                    System.out.println(format.format(new Date()) + " : ------> Congratulation !!! rebirth hero is 狩猎者-加加比克, and the count stat is ["+rebirthHeroSlzJjbkCount+"/"+rebirthHeroCount+"] --> " + currentRebirthCount + " | previous elapsedTime is " + (elapsedTime / 1000) + "s");
                    startTime = stopTime;
                    break;
                }
                System.out.println(format.format(new Date()) +" : rebirth hero is unexpected, and the count stat is ["+rebirthHeroSlzJjbkCount+"/"+rebirthHeroCount+"] --> " + currentRebirthCount);

                // 3.3 英雄重置
                HeroTdRobotUtil.clickHeroC1();
                // 点击重置（有时候可能直接成重生了）
                HeroTdRobotUtil.clickHeroC1Reset();
                // 多点击一次重生按钮
                HeroTdRobotUtil.clickHeroRebirth();

                // 是否出现提示: 观看视频（先点击一次加速）
                RobotUtil.mouseMoveAndClick(39, 910, 100);
                BufferedImage promptSeeVideoImage = ImageUtil.readImageFileFirstCache("data/image/prompt-see-video.jpg");
                BufferedImage tmpSeeImage = HeroTdRobotUtil.capturePromptSeeVideoImage();
                boolean isPromptSeeVideo = ImageUtil.isSimilar(promptSeeVideoImage, tmpSeeImage);
                if (isPromptSeeVideo) {
                    // 点击观看视频
                    HeroTdRobotUtil.clickPromptSeeVideo();
                    // 点击使用
                    HeroTdRobotUtil.clickPromptUse();
                }

                // 多点一次使用
                HeroTdRobotUtil.clickPromptUse();

                // 每 10 次做其它的事情
                if (currentRebirthCount % 10 == 0) {
                    // 每 10 次看一次广告
                    doSpeedAndMan();
                }

                // 每 20 次做移动一次英雄，并且直接结束
                if (currentRebirthCount % 20 == 0) {
                    HeroTdRobotUtil.moveRebirthHeroToA1Repeat(2);
                    return;
                }

                // 休息一下
//                Thread.sleep(1000);
            }

            // C1 英雄的解封
            HeroTdRobotUtil.clickHeroC1();
            HeroTdRobotUtil.clickHeroC1Deblocking();
            Thread.sleep(1000 * 10);

            // 英雄从 C1 移动到 A1
            HeroTdRobotUtil.moveRebirthHeroToA1Repeat(2);
        }
    }

    private static void doSpeedAndMan() {
        // 点击加速
        RobotUtil.mouseMoveAndClick(38,908, 100);
        // 点击小人 1
        RobotUtil.mouseMoveAndClick(220,451, 100);
        // 点击小人 2
        RobotUtil.mouseMoveAndClick(190,405, 100);
        // 点击小人 3
        RobotUtil.mouseMoveAndClick(149,318, 100);
        // 点击小人 3
        RobotUtil.mouseMoveAndClick(178,274, 100);
        // 点击小人 3
        RobotUtil.mouseMoveAndClick(508,350, 100);
        // 点击小人 3
        RobotUtil.mouseMoveAndClick(374,497, 100);
        // 点击看视频
        HeroTdRobotUtil.clickPromptSeeVideo();
        // 点击使用两次
        HeroTdRobotUtil.clickPromptUse();
        HeroTdRobotUtil.clickPromptUse();
    }

}
