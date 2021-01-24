package com.xib.application.repository;

import com.xib.application.model.Agent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends PagingAndSortingRepository<Agent, Long> {
}
