package testdata;

import com.github.javafaker.Faker;
import utils.RandomStateCity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {
    static Faker faker = new Faker(new Locale("en-NG"));

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userNumber = faker.number().digits(10);
    public static String currentAddress = faker.address().fullAddress();
    public static String userEmail = faker.internet().safeEmailAddress();;
    public static String permanentAddress = faker.address().fullAddress();
    public static String fullName = firstName + " " + lastName;;
    public static String successForm = "Thanks for submitting the form";
    public static String gender = faker.options().option("Male", "Female", "Other");
    public static String subjects = faker.options().option("Math", "Arts");
    public static String hobbies = faker.options().option("Sports", "Reading", "Music");
    public static String picturePath = "img/test.jpg";
    public static final String pictureName = "test.jpg";
    public static String state = RandomStateCity.getRandomState();
    public static String city = RandomStateCity.getRandomCity(state);

    //birthday
    static Date birthday = faker.date().birthday();

    public static String dayOfBirth = new SimpleDateFormat("dd").format(birthday);
    public static String monthOfBirth = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(birthday);
    public static String yearOfBirth  = new SimpleDateFormat("yyyy").format(birthday);   // "1965"

    public static String fullDateOfBirth =
            Integer.parseInt(dayOfBirth) + " " + monthOfBirth + "," + yearOfBirth;
}

