package com.hg.sba.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hg.sba.school.model.School;

@Repository
public interface SchoolDao extends JpaRepository<School, Integer>{

}
