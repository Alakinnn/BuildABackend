package com.group07.buildabackend.backend.cloudinary;

/**
 * @author Group_7
 */

import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;

import java.util.Map;

public abstract class CloudinaryUploader {
    protected static final Uploader uploader = CloudinaryConnectionManager.getCloudinary().uploader();
    private static Map configurations = ObjectUtils.asMap(
            "use_filename", true,
            "unique_filename", false,
            "overwrite", true
    );

    public static Map getConfigurations() {
        return configurations;
    }
}
