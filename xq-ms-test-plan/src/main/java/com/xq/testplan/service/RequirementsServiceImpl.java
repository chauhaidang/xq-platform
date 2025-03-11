package com.xq.testplan.service;

import com.xq.testplan.dto.RequirementsDto;
import com.xq.testplan.entity.Requirements;
import com.xq.testplan.exception.RequirementAlreadyExistsException;
import com.xq.testplan.exception.ResourceNotFoundException;
import com.xq.testplan.mapper.RequirementMapper;
import com.xq.testplan.repository.RequirementsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class RequirementsServiceImpl implements IRequirementsService {
    private RequirementsRepository requirementsRepository;

    @Override
    public String createRequirement(RequirementsDto requirementsDto) {
        log.info("Creating requirement for {}", requirementsDto);
        Optional<Requirements> requirement = requirementsRepository.findByTitle(requirementsDto.getTitle());
        if (requirement.isPresent()) {
            throw new RequirementAlreadyExistsException(String.format(
                    "Requirement already exist: %s", requirementsDto.getTitle()));
        }
        Requirements requirements = RequirementMapper.mapToRequirement(requirementsDto, new Requirements());
        requirements.setUuid(UUID.randomUUID().toString());
        requirements = requirementsRepository.save(requirements);
        return requirements.getUuid();
    }

    @Override
    public RequirementsDto fetchRequirement(String uuid) {
        Requirements requirement = requirementsRepository.findByUuid(uuid).orElseThrow(
                () -> new ResourceNotFoundException("Requirement", "uuid", uuid)
        );
        return RequirementMapper.mapToRequirementDto(requirement, new RequirementsDto());
    }

    @Override
    public boolean updateRequirement(String uuid, RequirementsDto requirementsDto) {
        Requirements requirement = requirementsRepository.findByUuid(uuid).orElseThrow(
                () -> new ResourceNotFoundException("Requirement", "uuid", uuid)
        );
        RequirementMapper.mapToRequirement(requirementsDto, requirement);
        return true;
    }

    @Override
    public boolean deleteRequirement(String uuid) {
        Requirements requirement = requirementsRepository.findByUuid(uuid).orElseThrow(
                () -> new ResourceNotFoundException("Requirement", "uuid", uuid)
        );
        requirementsRepository.deleteById(requirement.getReqId());
        return true;
    }
}
