package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.repository.PolicyOwnerRepository;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.backend.repository.CredentialsRepository;
import com.group07.buildabackend.backend.service.Service;

public abstract class SystemUserService extends Service {
    static final SystemUserRepository systemUserRepository = new SystemUserRepository();
    static final PolicyOwnerRepository policyOwnerRepository = new PolicyOwnerRepository();
    static final CredentialsRepository credentialsRepository = new CredentialsRepository();
}
