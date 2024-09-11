package org.example.Repository;

import org.example.Entity.RecordE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordERepository extends JpaRepository<RecordE, Integer> {
    List<RecordE> findByMatchId(int matchId);
}
