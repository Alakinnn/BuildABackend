package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.repository.SysUserRepository;
import com.group07.buildabackend.backend.service.Service;

public abstract class SysUserService extends Service {
    static final SysUserRepository sysUserRepository = new SysUserRepository();
}
