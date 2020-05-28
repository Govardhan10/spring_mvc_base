package com.pluralsight.controller;

import javax.validation.Valid;

import com.pluralsight.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.pluralsight.model.Goal;

import java.util.List;

@Controller
@SessionAttributes("goal")
public class GoalController {

	private GoalService goalService;

	@Autowired
	public void setGoalService(GoalService goalService) {
		this.goalService = goalService;
	}


	@RequestMapping(value = "addGoal", method = RequestMethod.GET)
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);
		
		return "addGoal";
	}
	
	@RequestMapping(value = "addGoal", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {
		
		System.out.println("result has errors: " + result.hasErrors());
		
		System.out.println("Goal set: " + goal.getMinutes());
		
		if(result.hasErrors()) {
			return "addGoal";
		} else {
			goalService.save(goal);
		}
		
		return "redirect:index.jsp";
	}

	@GetMapping(value = "getGoals")
	public String getGoals(Model model) {
		List<Goal> goalList = goalService.findAllGoals();
		model.addAttribute("goals",goalList);
		return "addGoals";
	}
	
}
