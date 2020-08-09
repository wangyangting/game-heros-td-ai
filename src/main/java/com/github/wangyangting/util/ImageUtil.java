package com.github.wangyangting.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageUtil {
    public static Map<String, BufferedImage> buffMap = new HashMap<String, BufferedImage>();

    public static void saveImageToFile(BufferedImage image, String filePath) throws IOException {
        File file = new File(filePath);
        ImageIO.write(image, "jpg", file);
    }

    public static float compareSimilar(BufferedImage sourceImage, BufferedImage destImage) {
        return ImageSimilarityUtil.compareSimilarity(sourceImage, destImage);
    }

    public static BufferedImage readImageFile(String filePath) throws IOException {
        return ImageIO.read(new File(filePath));
    }

    public static BufferedImage readImageFileFirstCache(String filePath) throws IOException {
        BufferedImage image = buffMap.get(filePath);
        if (image == null) {
            image = ImageIO.read(new File(filePath));
            buffMap.put(filePath, image);
        }
        return image;
    }

    public static boolean isSimilar(BufferedImage sourceImage, BufferedImage destImage) {
        float ret = compareSimilar(sourceImage, destImage);
//        System.out.println("similar accuracy: " + ret);
        float accuracy = 0.95f;
        if (ret > accuracy) {
            return true;
        }
        return false;
    }
}
