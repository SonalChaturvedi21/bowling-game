package com.bowlinggame.bowlinggame.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="game")
public class Game {

	@Id
	@GeneratedValue
	private int gameId;
	private int countOfPlayers;
	
	@Transient
	private List<Player> players;
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getCountOfPlayers() {
		return countOfPlayers;
	}
	public void setCountOfPlayers(int countOfPlayers) {
		this.countOfPlayers = countOfPlayers;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}
