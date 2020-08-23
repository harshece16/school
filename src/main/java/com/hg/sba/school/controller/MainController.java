package com.hg.sba.school.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hg.sba.model.Notes;
import com.hg.sba.school.model.School;
import com.hg.sba.school.model.Student;
import com.hg.sba.school.service.Services;

@RestController
public class MainController {
	private Services service;

    @GetMapping("/schools/{schoolId}")
    public ResponseEntity<Iterable<Student>> getStudentBySchoolID(@PathVariable("schoolId") Integer schoolId)
    {
        Optional<School> school=service.findBySchoolId(schoolId);

        return ResponseEntity.ok().body(school.get().getStudents());
    }

    public MainController(Services service) {
        this.service = service;
    }
    @RequestMapping(value = "/schools", method = RequestMethod.POST,consumes = { "application/JSON"})
    public ResponseEntity<School> createSchool(@RequestBody School school)
    {

        return new ResponseEntity<>(service.createSchool(school), HttpStatus.CREATED);
    }
    @GetMapping("/schools")
	public ResponseEntity<List<School>> getAllNotes(@RequestParam(required = false) String title) {
	  try {
	    List<Notes> notes = new ArrayList<Notes>();

	    if (title == null)
	      notesRepo.findAll().forEach(notes::add);
	    if (notes.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(notes, HttpStatus.OK);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
}
