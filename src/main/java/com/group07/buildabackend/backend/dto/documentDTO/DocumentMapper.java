package com.group07.buildabackend.backend.dto.documentDTO;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.insuranceClaim.Document;

public class DocumentMapper {
    public static Document toEntity(DocumentDTO dto) {
        Document entity = new Document();
        entity.setDocumentId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setUrl(dto.getUrl());
        return entity;
    }

    public static DocumentDTO toDTO(Document entity) {
        DocumentDTO dto = new DocumentDTO();
        dto.setId(entity.getDocumentId());
        dto.setTitle(entity.getTitle());
        dto.setUrl(entity.getUrl());
        return dto;
    }
}
