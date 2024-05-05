package com.group07.buildabackend.backend.cloudinary.uploadController;

import com.group07.buildabackend.backend.cloudinary.CloudinaryUploader;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.validation.customExceptions.BadFormatException;

import java.util.Map;

public class PdfUploadController extends CloudinaryUploader {

    public static Response<Map> uploadPdf(String filePath) {
        Response<Map> response = new Response<>(null);
        try {
            Map result = uploader.upload(filePath, CloudinaryUploader.getConfigurations());
            if (result.get("format").equals("jpg")) {
                throw new BadFormatException("Please upload a PDF file!", 400);
            }

            response.setData(result);
            response.setResponseMsg("Successfully uploaded file");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setData(null);
            response.setResponseMsg(e.getMessage());
            response.setStatusCode(400);
        }

        return response;
    }
}
