package com.group07.buildabackend.backend.service.createUserService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.DTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.service.user.SystemUserService;

public abstract class CreateSystemUserService<T extends DTO, K extends SystemUser> extends SystemUserService {
    public abstract Response<K> createUser(T dto);

    public Response<K> create(T dto) {
        return createUser(dto);
    }
}
