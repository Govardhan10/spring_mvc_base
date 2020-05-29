package com.pluralsight.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "goals")
@NamedQueries({
		@NamedQuery(name = Goal.FINAL_GOAL_REPORTS, query = "select new com.pluralsight.model.GoalReport(g.minutes,e.minutes,e.activity)" +
				"from Goal g, Exercise e where g.id=e.id"),
		@NamedQuery(name = Goal.FINAL_ALL_GOALS, query = "select g from Goal g")
})
public class Goal {

	public static final String FINAL_GOAL_REPORTS = "findGoalReports";
	public static final String FINAL_ALL_GOALS = "findAllGoals";

	@Id
	@GeneratedValue
	@Column(name = "GOAL_ID")
	private Long id;

	@Range(min = 1, max = 120)
	@Column(name = "MINUTES")
	private int minutes;

	@OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Exercise> exercises;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
}
