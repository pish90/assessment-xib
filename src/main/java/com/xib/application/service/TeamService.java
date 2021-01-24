package com.xib.application.service;

import com.xib.application.model.Agent;
import com.xib.application.model.Team;
import com.xib.application.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    TeamRepository teamRepository;

    /**
     * This function will find a specific team using an ID
     *
     * @param id the unique identifier for the team on the database
     * @return a team object
     */
    public Team findTeamById(Long id) {
        return teamRepository.findById(id).get();
    }

    /**
     * This function will save a team object to the database
     *
     * @param team a created team object
     */
    public void saveOrUpdate(Team team) {
        teamRepository.save(team);
    }

    /**
     * This function will return all teams on the database
     *
     * @return a list of teams from the database
     */
    public List<Team> findAllTeams() {
        List<Team> teamList = new ArrayList<>();
        teamRepository.findAll().forEach(team -> teamList.add(team));
        return teamList;
    }

    /**
     * This function will assign an agent to a team
     *
     * @param id the id of the team
     * @param agent the agent to be assigned to a team
     */
    public void assignAgentToTeam(Long id, Agent agent) {
        Team team = findTeamById(id);
        if (team.getManagerId().equals(agent.getManager().getId())) {
            team.setAgentId(agent.getId());
            teamRepository.save(team);
        } else {
            logger.error("Cannot assign agent to team with different manager");
        }
    }

    /**
     * This function will return a list of teams with no agents or managers
     *
     * @return a list if unassigned teams
     */
    public List<Team> unassignedTeams() {
        List<Team> teamList = findAllTeams();
        List<Team> unassignedTeamList = new ArrayList<>();
        for (Team team : teamList) {
            if (team.getAgentId() == null && team.getManagerId() == null) {
                unassignedTeamList.add(team);
            } else {
                logger.info("All teams are assigned agents and managers");
            }
        }
        return unassignedTeamList;
    }
}
