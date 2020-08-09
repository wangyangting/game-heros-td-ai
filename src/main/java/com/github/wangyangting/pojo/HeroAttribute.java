package com.github.wangyangting.pojo;

/**
 * @author wangyangting
 * @date 2020-08-02
 */
public class HeroAttribute {
    private int centerX;
    private int centerY;
    private int rebirthX;
    private int rebirthY;

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRebirthX() {
        return rebirthX;
    }

    public void setRebirthX(int rebirthX) {
        this.rebirthX = rebirthX;
    }

    public int getRebirthY() {
        return rebirthY;
    }

    public void setRebirthY(int rebirthY) {
        this.rebirthY = rebirthY;
    }

    @Override
    public String toString() {
        return "HeroAttribute{" +
                "centerX=" + centerX +
                ", centerY=" + centerY +
                ", rebirthY=" + rebirthY +
                ", rebirthY=" + rebirthY +
                '}';
    }
}
