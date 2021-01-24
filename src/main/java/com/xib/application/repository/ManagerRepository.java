package com.xib.application.repository;

import com.xib.application.model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long> {
}
