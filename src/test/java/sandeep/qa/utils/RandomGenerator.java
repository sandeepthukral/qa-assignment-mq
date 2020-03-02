package sandeep.qa.utils;

import org.apache.commons.lang.RandomStringUtils;

public class RandomGenerator {

    public static String getRandomName() {
        return "Test SST " + RandomStringUtils.randomAlphabetic(6);
    }

    public static String getRandomEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@no-email.address";
    }
}
