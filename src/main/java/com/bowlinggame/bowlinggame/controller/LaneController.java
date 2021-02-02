package com.bowlinggame.bowlinggame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bowlinggame.bowlinggame.model.Lane;
import com.bowlinggame.bowlinggame.service.LaneService;

/*
 * Lane Contoller to provide APIs for get and post calls for a Lane(id, name, lane allotted)
 * 
 * */

@RestController
@RequestMapping("/api")
public class LaneController {
	
		@Autowired
	    LaneService laneService;

	    @GetMapping("/lanes")
	    private List<Lane> getAllLanes() {
	    	System.out.println("------ \n\n\n lanes controller");
	        return laneService.getAllLanes();
	    }

	    @GetMapping("/lanes/{id}")
	    private Lane getLane(@PathVariable("id") int id) {
	        return laneService.getLaneById(id);
	    }
    
}
