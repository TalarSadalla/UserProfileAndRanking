package repositoryImpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.userProfileAndRanking.model.Challenge;
import com.example.userProfileAndRanking.model.Game;
import com.example.userProfileAndRanking.repository.ChallengeRepositoryImpl;

import com.example.userProfileAndRanking.enums.GameType;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = ChallengeRepositoryImpl.class)
public class ChallengeRepositoryImplTest {

	@Test
	public void initializeDataTest() {

		// given
		ChallengeRepositoryImpl challengeRepositoryImpl = new ChallengeRepositoryImpl();
		List<Challenge> challengeList = new ArrayList<>();

		// when
		challengeRepositoryImpl.initialize();
		challengeList = challengeRepositoryImpl.getChallengeList();

		// then
		assertEquals(4, challengeList.size());

	}

	@Test
	public void setGameWinnerTest() {

		// given
		ChallengeRepositoryImpl challengeRepositoryImpl = new ChallengeRepositoryImpl();
		List<Challenge> challengeList = new ArrayList<>();

		// when
		challengeRepositoryImpl.initialize();
		challengeList = challengeRepositoryImpl.getChallengeList();
		challengeRepositoryImpl.setGameWinner((long) 2, challengeList.get(1));

		// then
		assertEquals(2, challengeRepositoryImpl.getGameWinner(challengeList.get(1)));
	}

	@Test
	public void getChallengeTest() {
		// given
		ChallengeRepositoryImpl challengeRepositoryImpl = new ChallengeRepositoryImpl();
		List<Challenge> challengeList = new ArrayList<>();

		// when
		challengeRepositoryImpl.initialize();
		Challenge challenge = challengeRepositoryImpl
				.getChallenge(new Game("Monopoly", GameType.WORKER_PLACEMENT, 2, 8, 1.5, true));

		// then
		assertEquals(4, challenge.getUsersList().size());
		assertEquals("Monopoly", challenge.getGame().getGameName());
		assertEquals(GameType.WORKER_PLACEMENT, challenge.getGame().getGameType());
	}

	@Test
	public void getChallengeListTest() {
		// given
		ChallengeRepositoryImpl challengeRepositoryImpl = new ChallengeRepositoryImpl();

		// when
		challengeRepositoryImpl.initialize();
		List<Challenge> challengeList = challengeRepositoryImpl.getChallengeList();

		// then
		assertEquals(4, challengeList.size());
	}

}
