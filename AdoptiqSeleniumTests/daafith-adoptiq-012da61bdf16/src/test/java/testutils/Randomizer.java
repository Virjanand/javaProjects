package testutils;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
	
	public static int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(0, 99999999 + 1);
	}

	public static String getRandomString() {
		return UUID.randomUUID().toString();
	}

}
