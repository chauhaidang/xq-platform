package com.xq.accounts.repository;

import com.xq.accounts.entity.LinkedRequirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkedRequirementsRepository extends JpaRepository<LinkedRequirements, Long> {
    List<LinkedRequirements> findByReqAId(Long reqAId);
    List<LinkedRequirements> findByReqBId(Long reqBId);
}
