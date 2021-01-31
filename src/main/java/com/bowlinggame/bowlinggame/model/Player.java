package com.bowlinggame.bowlinggame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Player Entity to map Player details to the H2 database Player table
 * */

@Entity
@Table(name="player")
public class Player {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String lane;
	//private Score score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	
}