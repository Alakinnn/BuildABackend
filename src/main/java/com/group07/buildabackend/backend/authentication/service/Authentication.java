package com.group07.buildabackend.backend.authentication.service;

import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.backend.service.Service;

public abstract class Authentication extends Service {
     static final SystemUserRepository SYSTEM_USER_REPOSITORY = new SystemUserRepository();


}
