package com.github.wangyangting;

import com.github.wangyangting.util.HeroTdRobotUtil;
import org.junit.jupiter.api.Test;

public class HeroTdFlowTest {

    @Test
    public void testClickA1AndRebirth() {
        HeroTdRobotUtil.clickHeroA1();
        HeroTdRobotUtil.clickHeroA1Rebirth();
        HeroTdRobotUtil.clickHeroRebirth();
    }


    @Test
    public void testClickBirth() {
        HeroTdRobotUtil.clickHeroC1();
        HeroTdRobotUtil.clickHeroC1Rebirth();
    }

}
