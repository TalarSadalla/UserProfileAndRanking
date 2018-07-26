package model;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private static AtomicLong uniqueId = new AtomicLong(1);

	private long userId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String liveMotto;
	private List<Game> userGamesList;

	public User() {
		super();
	}

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.password = builder.password;
		this.email = builder.email;
		this.liveMotto = builder.liveMotto;
	}

	public User(String firstName, String lastName, String password, String email, String liveMotto,
			List<Game> userGamesList) {
		super();
		this.userId = incrementId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.liveMotto = liveMotto;
		this.userGamesList = userGamesList;
	}

	public long getId() {
		return userId;
	}

	private static long incrementId() {
		return uniqueId.getAndIncrement();
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

	public List<Game> getUserGamesList() {
		return userGamesList;
	}

	public void setUserGamesList(List<Game> userGamesList) {
		this.userGamesList = userGamesList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", email=" + email + ", liveMotto=" + liveMotto + "]";
	}

	public static class UserBuilder {
		private final String firstName;
		private final String lastName;
		private final String password;
		private String email;
		private String liveMotto;

		public UserBuilder(String firstName, String lastName, String password, String email) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.email = email;
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
