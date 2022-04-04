package com.fis.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.project.entity.TrackEntry;

@Repository
public interface TrackEntryRepo extends JpaRepository<TrackEntry, Long> {

}
