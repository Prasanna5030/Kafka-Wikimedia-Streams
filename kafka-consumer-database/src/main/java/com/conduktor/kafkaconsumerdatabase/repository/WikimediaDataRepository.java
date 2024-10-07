package com.conduktor.kafkaconsumerdatabase.repository;

import com.conduktor.kafkaconsumerdatabase.model.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
