package com.group07.buildabackend.backend.utils.fileUtils;

import com.group07.buildabackend.backend.cloudinary.uploadController.PdfUploadController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.documentDTO.DocumentDTO;
import com.group07.buildabackend.backend.dto.documentDTO.DocumentMapper;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileListMapper {
    static byte[] readFileToByteArray(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Document> mapToDocumentList(List<File> documents) throws Exception {
        // Uploads a List of Files to cloud provider and return a List of Documents

        List<Document> documentEntityList = new ArrayList<>();
        for (int i = 0; i < documents.toArray().length; i++) {
            File document = documents.get(i);
            String documentAbsPath = document.getAbsolutePath();

            Response<Map> response = PdfUploadController.uploadPdf(documentAbsPath);

            if (response.getData() == null) {
                // Something went wrong with the upload process
                throw new Exception(response.getResponseMsg());
            }

            DocumentDTO documentDTO = new DocumentDTO();
            documentDTO.setTitle((String) response.getData().get("original_filename"));
            documentDTO.setUrl((String) response.getData().get("url"));

            Document documentEntity = DocumentMapper.toEntity(documentDTO);
            documentEntityList.add(documentEntity);
        }

        return documentEntityList;
    }
}
