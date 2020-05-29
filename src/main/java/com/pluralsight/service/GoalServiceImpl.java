package com.pluralsight.service;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import com.pluralsight.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("goalService")
public class GoalServiceImpl implements GoalService{

    private GoalRepository repository;

    @Autowired
    public void setRepository(GoalRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Goal save(Goal goal) {
        return repository.save(goal);
    }

    @Override
    public List<Goal> findAllGoals() {
        return repository.loadAll();
    }

    @Override
    public List<GoalReport> findAllGoalReports() {
        return repository.findAllGoalReports();
    }


}
