package com.xib.application.controller;

import com.xib.application.model.Agent;
import com.xib.application.model.Team;
import com.xib.application.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping(value = "team/{id}")
    @ResponseBody
    public Team findAgentById(@PathVariable("id") Long id) {
        return teamService.findTeamById(id);
    }

    @PostMapping(value = "/team")
    public Long saveTeam(@RequestBody Team team) {
        teamService.saveOrUpdate(team);
        return team.getId();
    }

    @GetMapping(value = "/teams")
    public List<Team> findAllTeams() {
        return teamService.findAllTeams();
    }

    @PutMapping(value = "team/{id}/agent")
    public void assignAgentToTeam(@PathVariable Long id, @RequestBody Agent agent) {
        teamService.assignAgentToTeam(id, agent);
    }

    @GetMapping(value = "/unassignedTeams")
    public List<Team> unassignedTeams() {
        return teamService.unassignedTeams();
    }
}
