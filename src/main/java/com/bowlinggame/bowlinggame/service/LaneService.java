package com.bowlinggame.bowlinggame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bowlinggame.bowlinggame.model.Lane;
import com.bowlinggame.bowlinggame.repository.LaneRepository;

/*
 * Service class to provide/store lane details directed from the controller to repository
 * */

@Service
public class LaneService {
	
	@Autowired
	LaneRepository laneRepository;
	
	 public List<Lane> getAllLanes() {
	        List<Lane> lanes = new ArrayList<Lane>();
	        laneRepository.findAll().forEach(lane -> lanes.add(lane));
	        return lanes;
	    }

	    public Lane getLaneById(int id) {
	        return laneRepository.findById(id);
	    }

}
