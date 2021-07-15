import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int shift) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate currentDate = LocalDate.now();
        return currentDate.plusDays(shift).format(dateFormat);
    }

    public static String generateCity() {
        String[] cities = {"Москва", "Санкт-Петербург","Казань","Пенза","Самара","Владивосток"};
        return cities[new Random().nextInt(cities.length)];

    }

    public static String generateName() {
        return faker.name().lastName().replace("ё","е") + " " +faker.name().firstName().replace("ё","е");
    }

    public static String generatePhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser() {


            return new UserInfo(generateCity(), generateName(), generatePhone());
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }
}