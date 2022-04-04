package com.fis.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.project.entity.Storage;

@Repository
public interface StorageRepo extends JpaRepository<Storage, Long> {

}
