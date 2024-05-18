package com.group07.buildabackend.backend.cloudinary;

/**
 * @author Group_7
 */

import com.cloudinary.*;
import io.github.cdimascio.dotenv.Dotenv;

public class CloudinaryConnectionManager {
    private static Cloudinary cloudinary;

    public static Cloudinary getCloudinary() {
        if (cloudinary == null) {
            cloudinary = new Cloudinary("cloudinary://799347643284176:YsdI4sZ6ULhp5A1P_KI8Biz6bqg@dhfh7z051");
            cloudinary.config.secure = true;
        }
        return cloudinary;
    }
}
