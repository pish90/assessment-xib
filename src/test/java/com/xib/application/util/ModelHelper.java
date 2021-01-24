package com.xib.application.util;

import com.xib.application.model.Manager;
import com.xib.application.model.Agent;
import com.xib.application.model.Team;

import java.util.ArrayList;
import java.util.List;

public class ModelHelper {

    public Manager buildManager() {
        Manager manager = new Manager();
        manager.setId(1L);
        manager.setFirstName("Sipho");
        manager.setLastName("Ng");
        manager.setIdNumber("1122334455667");
        manager.setTeam(buildTeam());

        return manager;
    }

    public List<Manager> buildManagerList() {
        List<Manager> managerList = new ArrayList<>();
        Manager manager1 = new Manager();
        manager1.setId(1L);
        manager1.setFirstName("Cliff");
        manager1.setLastName("Richards");
        manager1.setIdNumber("4455664455665");
        manager1.setTeam(buildTeam());

        Manager manager2 = new Manager();
        manager2.setId(2L);
        manager2.setFirstName("Michael");
        manager2.setLastName("Jackson");
        manager2.setIdNumber("4455664455887");
        manager2.setTeam(buildTeam());

        managerList.add(manager1);
        managerList.add(manager2);

        return managerList;
    }

    public Team buildTeam() {
        Team team = new Team();
        team.setId(1L);
        team.setName("Cougar");
        team.setAgentId(1L);
        team.setManagerId(1L);

        return team;
    }

    public List<Team> buildTeamList() {
        List<Team> teamList = new ArrayList<>();
        Team team1 = new Team();
        team1.setId(1L);
        team1.setName("Power");
        team1.setAgentId(1L);
        team1.setManagerId(1L);

        Team team2 = new Team();
        team2.setId(2L);
        team2.setName("Zeus");
        team2.setAgentId(2L);
        team2.setManagerId(2L);

        teamList.add(team1);
        teamList.add(team2);

        return teamList;
    }

    public Agent buildAgent() {
        Agent agent = new Agent();
        agent.setId(1L);
        agent.setFirstName("Alex");
        agent.setLastName("Cross");
        agent.setIdNumber("1234567890123");
        agent.setTeam(buildTeam());
        agent.setManager(buildManager());

        return agent;
    }

    public List<Agent> buildAgentList() {
        List<Agent> agentList = new ArrayList<>();
        Agent agent1 = new Agent();
        agent1.setId(1L);
        agent1.setFirstName("Hillary");
        agent1.setLastName("Cl");
        agent1.setIdNumber("4455887744558");
        agent1.setTeam(buildTeam());
        agent1.setManager(buildManager());

        Agent agent2 = new Agent();
        agent2.setId(1L);
        agent2.setFirstName("William");
        agent2.setLastName("Cl");
        agent2.setIdNumber("4455887711558");
        agent2.setTeam(buildTeam());
        agent2.setManager(buildManager());

        agentList.add(agent1);
        agentList.add(agent2);

        return agentList;
    }
}
