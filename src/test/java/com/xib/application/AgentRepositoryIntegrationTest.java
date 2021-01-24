package com.xib.application;

import com.xib.application.model.Agent;
import com.xib.application.service.AgentService;
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
public class AgentRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AgentService agentService;

    private ModelHelper modelHelper;

    public AgentRepositoryIntegrationTest() {
        this.agentService = new AgentService();
        this.modelHelper = new ModelHelper();
    }

    @Test
    public void whenFindById_thenReturnAgent() {
        // given
        Agent agent = modelHelper.buildAgent();

        // when
        Agent found = agentService.findAgentById(1L);

        // then
        assertThat(found.getId()).isEqualTo(agent.getId());
    }

    @Test
    public void whenFindAllAgents_thenReturnAllAgents() {
        // given
        List<Agent> agentList = modelHelper.buildAgentList();

        // when
        agentService.findAllAgents().forEach(agent -> agentList.add(agent));

        // then
        assertThat(agentList).isNotNull();
    }
}
