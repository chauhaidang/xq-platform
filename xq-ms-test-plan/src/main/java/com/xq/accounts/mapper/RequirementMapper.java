package com.xq.accounts.mapper;

import com.xq.accounts.dto.RequirementsDto;
import com.xq.accounts.entity.Requirements;

public class RequirementMapper {
    public static RequirementsDto mapToRequirementDto(Requirements requirements, RequirementsDto requirementsDto) {
        requirementsDto.setTitle(requirements.getTitle());
        requirementsDto.setDescription(requirements.getDescription());
        requirementsDto.setScopes(requirements.getScopes());
        requirementsDto.setTags(requirements.getTags());
        requirementsDto.setReferences(requirements.getReferences());
        return requirementsDto;
    }

    public static Requirements mapToRequirement(RequirementsDto requirementsDto, Requirements requirements) {
        requirements.setTitle(requirementsDto.getTitle());
        requirements.setDescription(requirementsDto.getDescription());
        requirements.setScopes(requirementsDto.getScopes());
        requirements.setTags(requirementsDto.getTags());
        requirements.setReferences(requirementsDto.getReferences());
        return requirements;
    }
}
