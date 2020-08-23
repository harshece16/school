package com.hg.sba.school.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hg.sba.school.dao.SchoolDao;
import com.hg.sba.school.model.School;

@Service
public class servicesImpl implements Services{
	 private SchoolDao schoolDao;

	    public servicesImpl(SchoolDao schoolDao) {
	        this.schoolDao = schoolDao;
	    }

	    @Override
	    @Transactional
	    public Iterable<School> getDetails() {
	        return schoolDao.findAll();
	    }

	    @Override
	    @Transactional
	    public School createSchool(School school) {
	        return schoolDao.save(school);
	    }

	    @Override
	    @Transactional
	    public Optional<School> findBySchoolId(Integer schoolId) {
	        return schoolDao.findById(schoolId);
	    }

}
