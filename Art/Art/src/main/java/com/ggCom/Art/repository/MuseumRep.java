package com.ggCom.Art.repository;

import com.ggCom.Art.entity.Artist;
import com.ggCom.Art.entity.Museum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.config.Task;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MuseumRep extends JpaRepository<Museum, Integer> {

  List <Museum> findByNameEqualsIgnoreCase(String keyword);

}
