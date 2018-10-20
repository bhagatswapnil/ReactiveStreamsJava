package model;

public class Player {

	private int id;
	private String name;
	private String role;
	private String team;
	private String bestHero;
	private long mmr;
	
	public Player(int id, String name, String role, String team, String bestHero, long mmr) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.team = team;
		this.bestHero = bestHero;
		this.mmr = mmr;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getBestHero() {
		return bestHero;
	}

	public void setBestHero(String bestHero) {
		this.bestHero = bestHero;
	}

	public long getMmr() {
		return mmr;
	}

	public void setMmr(long mmr) {
		this.mmr = mmr;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", role=" + role + ", team=" + team + ", bestHero=" + bestHero
				+ ", mmr=" + mmr + "]";
	}
	
}
