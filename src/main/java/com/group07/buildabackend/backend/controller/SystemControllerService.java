package com.group07.buildabackend.backend.controller;

import com.group07.buildabackend.backend.service.createUserService.CreateDependentService;
import com.group07.buildabackend.backend.service.createUserService.CreatePolicyHolderService;

public abstract class SystemControllerService extends Controller {
    CreateDependentService createDependentService = new CreateDependentService();
    CreatePolicyHolderService createPolicyHolderService = new CreatePolicyHolderService();
}
