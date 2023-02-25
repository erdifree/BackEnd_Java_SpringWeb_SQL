package com.ggCom.Art.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ggCom.Art.entity.Character;

public interface ChRep extends JpaRepository<Character, Integer> {

}
