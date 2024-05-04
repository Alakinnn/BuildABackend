package com.group07.buildabackend.backend.cloudinary;

import com.cloudinary.*;
import io.github.cdimascio.dotenv.Dotenv;

public class CloudinaryConnectionManager {
    protected static final Dotenv dotenv = Dotenv.load();
    private static Cloudinary cloudinary;

    public static Cloudinary getCloudinary() {
        if (cloudinary == null) {
            cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));
            cloudinary.config.secure = true;
        }
        return cloudinary;
    }
}
