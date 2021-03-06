package com.example.wanderapp.model;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trails")
public class Trail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String trailName;

	@Column
	private String trailLength;

	@Column
	private String trailDifficulty;

	@Column
	private String trailElevation;

	@Column
	private int trailRating;

	@Column(length = 1000)
	private String trailDataPoints;

	@Column(length = 1000)
	private String trailHeadLocation;

	@Column(length = 1000)
	private String trailLat;

	@Column(length = 1000)
	private String trailLong;

	@Column(length = 10000)
	private String trailDescription;




	public Trail(Trail copy) {
		id = copy.id;
		trailName = copy.trailName;
		trailLength = copy.trailLength;
		trailDifficulty = copy.trailDifficulty;
		trailElevation = copy.trailElevation;
		trailRating = copy.trailRating;
		trailDataPoints = copy.trailDataPoints;
		trailHeadLocation = copy.trailHeadLocation;
		trailLat = copy.trailLat;
		trailLong = copy.trailLong;
		trailDescription = copy.trailDescription;
	}

	public Trail() {}

	@ManyToMany(mappedBy = "trails")
	private List<User> users;

	@ManyToMany
	@JoinTable(
			name="trails_saved_trails_bridge",
			joinColumns = {@JoinColumn(name = "trails_id")},
			inverseJoinColumns = {@JoinColumn(name = "saved_trails_id")}
	)
	private List<CompletedTrail> completedTrail;

	@ManyToMany
	@JoinTable(
			name = "trails_trail_picture_bridge",
			joinColumns = {@JoinColumn(name = "trails_id")},
			inverseJoinColumns = {@JoinColumn(name = "trail_picture_id")}
	)
	private List<TrailPicture> trailPicture;

	@ManyToMany
	@JoinTable(
			name = "trails_trail_map_bridge",
			joinColumns = {@JoinColumn(name = "trails_id")},
			inverseJoinColumns = {@JoinColumn(name = "trail_map_id")}
	)
	private List<Map> trailMap;

	@ManyToMany
	@JoinTable(
			name = "trails_favorite_plants_bridge",
			joinColumns = {@JoinColumn(name = "trails_id")},
			inverseJoinColumns = {@JoinColumn(name = "favorite_plants_id")}
	)
	private List<FavoritePlants> favoritePlants;

	@ManyToMany
	@JoinTable(
			name = "trails_favorite_animals_bridge",
			joinColumns = {@JoinColumn(name = "trails_id")},
			inverseJoinColumns = {@JoinColumn(name = "favorite_animals_id")}
	)
	private List<FavoriteAnimals> favoriteAnimals;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<FavoriteAnimals> getFavoriteAnimals() {
		return favoriteAnimals;
	}

	public void setFavoriteAnimals(List<FavoriteAnimals> favoriteAnimals) {
		this.favoriteAnimals = favoriteAnimals;
	}

	public List<FavoritePlants> getFavoritePlants() {
		return favoritePlants;
	}

	public void setFavoritePlants(List<FavoritePlants> favoritePlants) {
		this.favoritePlants = favoritePlants;
	}

	public List<Map> getTrailMap() {
		return trailMap;
	}

	public void setTrailMap(List<Map> trailMap) {
		this.trailMap = trailMap;
	}

	public List<CompletedTrail> getCompletedTrail() {
		return completedTrail;
	}

	public void setCompletedTrail(List<CompletedTrail> completedTrail) {
		this.completedTrail = completedTrail;
	}

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

	public String getTrailElevation() {
		return trailElevation;
	}

	public void setTrailElevation(String trailElevation) {
		this.trailElevation = trailElevation;
	}

	public String getTrailDifficulty() {
		return trailDifficulty;
	}

	public void setTrailDifficulty(String trailDifficulty) {
		this.trailDifficulty = trailDifficulty;
	}

	public String getTrailLength() {
		return trailLength;
	}

	public void setTrailLength(String trailLength) {
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

	public List<Map> getMap() {
		return trailMap;
	}

	public void setMap(List<Map> map) {
		this.trailMap = map;
	}

	public List<TrailPicture> getTrailPicture() {
		return trailPicture;
	}

	public void setTrailPicture(List<TrailPicture> trailPicture) {
		this.trailPicture = trailPicture;
	}

	public String getTrailLat() {
		return trailLat;
	}

	public void setTrailLat(String trailLat) {
		this.trailLat = trailLat;
	}

	public String getTrailLong() {
		return trailLong;
	}

	public void setTrailLong(String trailLong) {
		this.trailLong = trailLong;
	}

	public String getTrailDescription() {
		return trailDescription;
	}

	public void setTrailDescription(String trailDescription) {
		this.trailDescription = trailDescription;
	}

}
