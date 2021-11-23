package com.j2ee.tdspring.repositories;

import com.j2ee.tdspring.entities.Exit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExitRepository extends JpaRepository<Exit, Integer> { }
