package com.example.wanderapp.model;



import javax.persistence.*;

@Entity
@Table(name = "trails")
public class Trail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String trailName;

	@Column
	private double trailLength;

	@Column
	private float trailDifficulty;

	@Column
	private float trailElevation;

	@Column
	private int trailRating;

	@Column(length = 10000)
	private String trailDataPoints;

	@Column(length = 1000)
	private String trailHeadLocation;

	public String getTrailHeadLocation() {
		return trailHeadLocation;
	}

	public void setTrailHeadLocation(String trailHeadLocation) {
		this.trailHeadLocation = trailHeadLocation;
	}

	public String getTrailDataPoints() {
		return trailDataPoints;
	}

	public void setTrailDataPoints(String trailDataPoints) {
		this.trailDataPoints = trailDataPoints;
	}

	public int getTrailRating() {
		return trailRating;
	}

	public void setTrailRating(int trailRating) {
		this.trailRating = trailRating;
	}

	public float getTrailElevation() {
		return trailElevation;
	}

	public void setTrailElevation(float trailElevation) {
		this.trailElevation = trailElevation;
	}

	public float getTrailDifficulty() {
		return trailDifficulty;
	}

	public void setTrailDifficulty(float trailDifficulty) {
		this.trailDifficulty = trailDifficulty;
	}

	public double getTrailLength() {
		return trailLength;
	}

	public void setTrailLength(double trailLength) {
		this.trailLength = trailLength;
	}

	public String getTrailName() {
		return trailName;
	}

	public void setTrailName(String trailName) {
		this.trailName = trailName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
