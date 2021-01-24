package com.xib.application;

import com.xib.application.model.Team;
import com.xib.application.service.TeamService;
import com.xib.application.util.ModelHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TeamRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TeamService teamService;

    private ModelHelper modelHelper;

    public TeamRepositoryIntegrationTest() {
        this.teamService = new TeamService();
        this.modelHelper = new ModelHelper();
    }

    @Test
    public void whenFindById_thenReturnTeam() {
        // given
        Team team = modelHelper.buildTeam();
        entityManager.merge(team);
        entityManager.flush();

        // when
        Team found = teamService.findTeamById(1L);

        // then
        assertThat(found.getId()).isEqualTo(team.getId());
    }

    @Test
    public void whenFindAllTeams_thenReturnAllTeams() {
        // given
        List<Team> teamList = modelHelper.buildTeamList();

        // when
        teamService.findAllTeams().forEach(team -> teamList.add(team));

        // then
        assertThat(teamList).isNotNull();
    }
}
