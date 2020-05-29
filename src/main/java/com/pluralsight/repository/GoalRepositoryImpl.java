package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Queue;

@Repository(value = "goalRepository")
public class GoalRepositoryImpl implements GoalRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Goal save(Goal goal) {
        em.persist(goal);
        em.flush();
        return goal;
    }

    @Override
    public List<Goal> loadAll() {
//        Query query = em.createQuery("select g from Goal g");
        TypedQuery<Goal> query = em.createNamedQuery(Goal.FINAL_ALL_GOALS, Goal.class);
        return query.getResultList();
    }

    @Override
    public List<GoalReport> findAllGoalReports() {
//        Query query = em.createQuery("select new com.pluralsight.model.GoalReport(g.minutes,e.minutes,e.activity) " +
//                "from Goal g, Exercise e where g.id=e.id");
        TypedQuery<GoalReport> query = em.createNamedQuery(Goal.FINAL_GOAL_REPORTS,GoalReport.class);
        return query.getResultList();
    }
}
