package com.xib.application.service;

import com.xib.application.model.Agent;
import com.xib.application.repository.AgentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentService {
    private static final Logger logger = LoggerFactory.getLogger(AgentService.class);

    @Autowired
    AgentRepository agentRepository;

    /**
     * This function will find a specific agent using an ID
     *
     * @param id the unique identifier for the agent on the database
     * @return an agent object
     */
    public Agent findAgentById(Long id) {
        return agentRepository.findById(id).get();
    }

    /**
     * This function will save an agent object to the database
     *
     * @param agent a created agent object
     */
    public void saveOrUpdate(Agent agent) {
        agentRepository.save(agent);
    }

    /**
     * This function will return all agents on the database
     *
     * @return a list of agents from the database
     */
    public List<Agent> findAllAgents() {
        List<Agent> agentList = new ArrayList<>();
        agentRepository.findAll().forEach(agent -> agentList.add(agent));

        if (!agentList.isEmpty()) {
            return agentList;
        } else {
            logger.info("There are no agents to load");
        }
        return new ArrayList<>();
    }

    /**
     * This function will return a paginated list of agents from the database
     *
     * @param pageNo the number of the page to return
     * @param pageSize the number of records to return per page
     * @param sortBy the field used to sort the records
     * @return a list of paginated records
     */
    public List<Agent> findAllAgents(int pageNo, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        List<Agent> updatedList = new ArrayList<>();
        List<Agent> agentList = new ArrayList<>();
        Page<Agent> pagedResult = agentRepository.findAll(paging);
        if (!pagedResult.isEmpty()) {
            agentList = pagedResult.getContent();
        }

        if (pagedResult.hasContent()) {
            for (Agent agent : agentList) {
                Agent updatedAgent = new Agent();
                updatedAgent.setId(agent.getId());
                updatedAgent.setFirstName(agent.getFirstName());
                updatedAgent.setLastName(agent.getLastName());
                updatedAgent.setTeam(agent.getTeam());
                updatedList.add(updatedAgent);
            }
            Page<Agent> updatedResult = new PageImpl<>(updatedList, PageRequest.of(pageNo, pageSize), updatedList.size());
            return updatedResult.getContent();
        } else {
            logger.info("The list is empty");
            return new ArrayList<>();
        }
    }
}
