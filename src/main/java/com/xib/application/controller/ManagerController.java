package com.xib.application.controller;

import com.xib.application.model.Manager;
import com.xib.application.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @GetMapping(value = "manager/{id}")
    @ResponseBody
    public Manager findAgentById(@PathVariable("id") Long id) {
        return managerService.findManagerById(id);
    }

    @PostMapping(value = "/manager")
    public Long saveAgent(@RequestBody Manager manager) {
        managerService.saveOrUpdate(manager);
        return manager.getId();
    }

    @GetMapping(value = "/managers")
    public List<Manager> findAllAgents() {
        return managerService.findAllManagers();
    }
}
