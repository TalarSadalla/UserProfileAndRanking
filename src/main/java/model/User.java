package model;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import enums.Level;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private AtomicLong uniqueId;

	private long userId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String liveMotto;
	private Level level;
	private List<Game> userGamesList;

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.password = builder.password;
		this.email = builder.email;
		this.liveMotto = builder.liveMotto;
	}

	public User(String firstName, String lastName, String password, String email, String liveMotto) {
		super();
		this.userId = uniqueId.incrementAndGet();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.liveMotto = liveMotto;
	}

	public long getId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLiveMotto() {
		return liveMotto;
	}

	public void setLiveMotto(String liveMotto) {
		this.liveMotto = liveMotto;
	}

	public Level getLevel() {
		return level;
	}

	public List<Game> getUserGamesList() {
		return userGamesList;
	}

	public void setUserGamesList(List<Game> userGamesList) {
		this.userGamesList = userGamesList;
	}

	public static class UserBuilder {
		private final String firstName;
		private final String lastName;
		private final String password;
		private String email;
		private String liveMotto;
		private Level level;

		public UserBuilder(String firstName, String lastName, String password, String email) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.email = email;
			this.level = Level.NEWBIE;
		}

		public UserBuilder liveMotto(String liveMotto) {
			this.liveMotto = liveMotto;
			return this;
		}

		public User build() {
			return new User(this);
		}

	}

}
