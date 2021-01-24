package com.xib.application.service;

import com.xib.application.repository.ManagerRepository;
import com.xib.application.model.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {
    private static final Logger logger = LoggerFactory.getLogger(AgentService.class);

    @Autowired
    ManagerRepository managerRepository;

    /**
     * This function will find a specific manager using an ID
     *
     * @param id the unique identifier for the manager on the database
     * @return a manager object
     */
    public Manager findManagerById(Long id) {
        return managerRepository.findById(id).get();
    }

    /**
     * This function will save a manager object to the database
     *
     * @param manager a created manager object
     */
    public void saveOrUpdate(Manager manager) {
        managerRepository.save(manager);
    }

    /**
     * This function will return all managers on the database
     *
     * @return a list of managers from the database
     */
    public List<Manager> findAllManagers() {
        List<Manager> managerList = new ArrayList<>();
        managerRepository.findAll().forEach(manager -> managerList.add(manager));

        if (!managerList.isEmpty()) {
            return managerList;
        } else {
            logger.info("There are no managers to load");
        }
        return new ArrayList<>();
    }
}
