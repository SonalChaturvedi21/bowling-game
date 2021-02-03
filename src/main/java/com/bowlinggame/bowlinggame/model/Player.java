package com.bowlinggame.bowlinggame.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.*;

/*
 * Player Entity to map Player details to the H2 database Player table
 * */

@Entity
@Table(name="player")
public class Player {

	@Id
	@GeneratedValue
	private int id;
	private String playerName;
	private int playerLane;
	private String rollString;
	private int spareCount;
	private int strikeCount;
	private int missCount;
	private int gameId;
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	public Player(int id, String playerName, int playerLane, String rollString, int spareCount, int strikeCount,
			int missCount, int gameId, int score) {
		super();
		this.id = id;
		this.playerName = playerName;
		this.playerLane = playerLane;
		this.rollString = rollString;
		this.spareCount = spareCount;
		this.strikeCount = strikeCount;
		this.missCount = missCount;
		this.gameId = gameId;
		this.score = score;
	}
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSpareCount() {
		return spareCount;
	}
	public void setSpareCount(int spareCount) {
		this.spareCount = spareCount;
	}
	public int getStrikeCount() {
		return strikeCount;
	}
	public void setStrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}
	public int getMissCount() {
		return missCount;
	}
	public void setMissCount(int missCount) {
		this.missCount = missCount;
	}
	public String getRollString() {
		return rollString;
	}
	public void setRollString(String rollString) {
		this.rollString = rollString;
	}
	private int score;
	
	public int getId() {
		return id;
	}
	public void setId(int playerId) {
		this.id = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerLane() {
		return playerLane;
	}
	public void setPlayerLane(int playerLane) {
		this.playerLane = playerLane;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + ", playerLane=" + playerLane + ", rollString="
				+ rollString + ", spareCount=" + spareCount + ", strikeCount=" + strikeCount + ", missCount="
				+ missCount + ", gameId=" + gameId + ", score=" + score + "]";
	}
	
	
}