package com.xib.application.controller;

import com.xib.application.model.Agent;
import com.xib.application.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController {
    @Autowired
    AgentService agentService;

    @GetMapping(value = "agent/{id}")
    @ResponseBody
    public Agent findAgentById(@PathVariable("id") Long id) {
        return agentService.findAgentById(id);
    }

    @PostMapping(value = "/agent")
    public Long saveAgent(@RequestBody Agent agent) {
        agentService.saveOrUpdate(agent);
        return agent.getId();
    }

    @GetMapping(value = "/agents")
    public List<Agent> findAllAgents() {
        return agentService.findAllAgents();
    }

    @GetMapping(value = "/agent/findAll")
    public List<Agent> findAllAgents(@RequestParam(defaultValue = "0") int pageNo,
                                     @RequestParam(defaultValue = "10") int pageSize,
                                     @RequestParam(defaultValue = "id") String sortBy) {
        return agentService.findAllAgents(pageNo, pageSize, sortBy);
    }
}
