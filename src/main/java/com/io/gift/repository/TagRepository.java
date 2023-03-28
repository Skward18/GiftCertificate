package com.io.gift.repository;

import com.io.gift.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    boolean existsByName(String name);

    List<Tag> findAllByNameIn(List<String> name);
}