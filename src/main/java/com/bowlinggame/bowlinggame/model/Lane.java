package com.bowlinggame.bowlinggame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lane")
public class Lane {
	
	@Id
	@GeneratedValue
	private int laneId;
	private int countOfPlayers;
	private String laneName;
	public int getLaneId() {
		return laneId;
	}
	public void setLaneId(int laneId) {
		this.laneId = laneId;
	}
	public int getCountOfPlayers() {
		return countOfPlayers;
	}
	public void setCountOfPlayers(int countOfPlayers) {
		this.countOfPlayers = countOfPlayers;
	}
	public String getLaneName() {
		return laneName;
	}
	public void setLaneName(String laneName) {
		this.laneName = laneName;
	}

}
