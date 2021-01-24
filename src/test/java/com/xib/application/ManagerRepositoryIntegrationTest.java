package com.xib.application;

import com.xib.application.model.Manager;
import com.xib.application.service.ManagerService;
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
public class ManagerRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ManagerService managerService;

    private ModelHelper modelHelper;

    public ManagerRepositoryIntegrationTest() {
        this.managerService = new ManagerService();
        this.modelHelper = new ModelHelper();
    }

    @Test
    public void whenFindById_thenReturnManager() {
        // given
        Manager manager = modelHelper.buildManager();
        entityManager.merge(manager);
        entityManager.flush();

        // when
        Manager found = managerService.findManagerById(1L);

        // then
        assertThat(found.getId()).isEqualTo(manager.getId());
    }

    @Test
    public void whenFindAllManagers_thenReturnAllManagers() {
        // given
        List<Manager> managerList = modelHelper.buildManagerList();

        // when
        managerService.findAllManagers().forEach(manager -> managerList.add(manager));

        // then
        assertThat(managerList).isNotNull();
    }
}
