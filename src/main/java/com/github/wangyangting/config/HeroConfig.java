package com.github.wangyangting.config;

import com.github.wangyangting.pojo.HeroAttribute;

/**
 * @author wangyangting
 * @date 2020-08-02
 */
public class HeroConfig {
    // 英雄位置编号，内圈，从左上往右下，依次编号为 A1 A2 B1 B2 C1 C2 C3 C4 D1 D2 D3 D4
    /**
     * 英雄重生的 X
     */
    public static int HERO_GLOBAL_REBIRTH_X = 162;
    /**
     * 英雄重生的 Y
     */
    public static int HERO_GLOBAL_REBIRTH_Y = 786;
    /**
     * C1 的中心点 X
     */
    public static int HERO_C1_CENTER_X = 230;
    /**
     * C1 中心点 Y
     */
    public static int HERO_C1_CENTER_Y = 529;
    /**
     * A1 的中心点 X
     */
    public static int HERO_A1_CENTER_X = 305;
    /**
     * A1 的中心点 Y
     */
    public static int HERO_A1_CENTER_Y = 290;
    /**
     * A1 的重生按钮的左上角 X
     */
    public static int HERO_A1_REBIRTH_BUTTON_LT_X = 349;
    /**
     * A1 的重生按钮的左上角 Y
     */
    public static int HERO_A1_REBIRTH_BUTTON_LT_Y = 217;
    /**
     * A1 的重生按钮的右下角的偏移量 X
     */
    public static int HERO_A1_REBIRTH_BUTTON_RB_OFFSET_X = 45;
    /**
     * A1 的重生按钮的右下角的偏移量 Y
     */
    public static int HERO_A1_REBIRTH_BUTTON_RB_OFFSET_Y = 47;
    /**
     * C1 的重生按钮的左上角 X
     */
    public static int HERO_C1_REBIRTH_BUTTON_LT_X = 270;
    /**
     * C1 的重生按钮的左上角 Y
     */
    public static int HERO_C1_REBIRTH_BUTTON_LT_Y = 463;
    /**
     * C1 的重生按钮的右下角的偏移量 X
     */
    public static int HERO_C1_REBIRTH_BUTTON_RB_OFFSET_X = 45;
    /**
     * AC1 的重生按钮的右下角的偏移量 Y
     */
    public static int HERO_C1_REBIRTH_BUTTON_RB_OFFSET_Y = 47;
    /**
     * C1 的左上角 X
     */
    public static int HERO_C1_LT_X = 226;
    /**
     * C1 的左上角 Y
     */
    public static int HERO_C1_LT_Y = 490;
    /**
     * C1 的右下角的偏移量 X
     */
    public static int HERO_C1_RB_OFFSET_X = 40;
    /**
     * C1 的右下角的偏移量 Y
     */
    public static int HERO_C1_RB_OFFSET_Y = 55;
    /**
     * 英雄解封的 X
     */
    public static int HERO_DEBLOCKING_CENTER_X = 157;
    /**
     * 英雄解封的 Y
     */
    public static int HERO_DEBLOCKING_CENTER_Y = 493;
    /**
     * 英雄重置的 X
     */
    public static int HERO_RESET_CENTER_X = 294;
    /**
     * 英雄重置的 Y
     */
    public static int HERO_RESET_CENTER_Y = 484;
    /**
     * 提示: 观看视频的 X
     */
    public static int HERO_PROMPT_SEE_VIDEO_CENTER_X = 289;
    /**
     * 提示: 观看视频的 Y
     */
    public static int HERO_PROMPT_SEE_VIDEO_CENTER_Y = 628;
    /**
     * 提示: 使用的 X
     */
    public static int HERO_PROMPT_USE_CENTER_X = 456;
    /**
     * 提示: 使用的 Y
     */
    public static int HERO_PROMPT_USE_CENTER_Y = 623;

    public static HeroAttribute getHeroAttribute(String heroId) {
        HeroAttribute attribute = new HeroAttribute();
        switch (heroId) {
            case "A1":
                attribute.setCenterX(HERO_A1_CENTER_X);
                attribute.setCenterY(HERO_A1_CENTER_Y);
                attribute.setRebirthX(355);
                attribute.setRebirthY(231);
                break;
            case "C1":
                attribute.setCenterX(HERO_C1_CENTER_X);
                attribute.setCenterY(HERO_C1_CENTER_Y);
                attribute.setRebirthX(150);
                attribute.setRebirthY(461);
                break;
            default:
                ;
        }
        return attribute;
    }
}
