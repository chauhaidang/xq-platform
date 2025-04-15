package com.xq.accounts.service;

import com.xq.accounts.dto.ListRequirementsDto;
import com.xq.accounts.dto.RequirementsDto;

public interface IRequirementsService {
    String createRequirement(RequirementsDto requirementsDto);
    RequirementsDto fetchRequirement(String uuid);
    boolean updateRequirement(String uuid, RequirementsDto requirementsDto);
    boolean deleteRequirement(String uuid);
    boolean deleteAllRequirements(String key);
    ListRequirementsDto getAllRequirements();
}
