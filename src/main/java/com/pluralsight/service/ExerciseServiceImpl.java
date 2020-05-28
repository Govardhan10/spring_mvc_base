package com.pluralsight.service;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Exercise;
import com.pluralsight.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Activity;
import org.springframework.transaction.annotation.Transactional;


@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	private ExerciseRepository repository;

	@Autowired
	public void setRepository(ExerciseRepository repository) {
		this.repository = repository;
	}

	public List<Activity> findAllActivities() {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run = new Activity();
		run.setDesc("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setDesc("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setDesc("Swim");
		activities.add(swim);
		
		return activities;
	}

	@Override
	@Transactional
	public Exercise save(Exercise exercise) {
		repository.save(exercise);
		return exercise;
	}

}
