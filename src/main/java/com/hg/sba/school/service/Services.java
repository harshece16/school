package com.hg.sba.school.service;

import java.util.Optional;

import com.hg.sba.school.model.School;

public interface Services {
	public Iterable<School> getDetails();
    public School createSchool(School school);
    public Optional<School> findBySchoolId(Integer schoolId);
}
