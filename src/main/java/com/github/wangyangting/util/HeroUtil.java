package com.github.wangyangting.util;

import com.github.wangyangting.config.HeroConfig;
import com.github.wangyangting.pojo.HeroAttribute;

/**
 * @author wangyangting
 * @date 2020-08-02
 */
public class HeroUtil {

    public static HeroAttribute getHeroAttribute(String heroId) {
        return HeroConfig.getHeroAttribute(heroId);
    }

}
