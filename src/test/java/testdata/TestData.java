package testdata;

import com.github.javafaker.Faker;
import utils.RandomStateCity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en-NG"));

    public  String firstName = faker.name().firstName();
    public  String lastName = faker.name().lastName();
    public  String userNumber =  faker.phoneNumber().subscriberNumber(Integer.parseInt("10"));
    public  String currentAddress = faker.address().fullAddress();
    public String userEmail = faker.internet().safeEmailAddress();;
    public  String permanentAddress = faker.address().fullAddress();
    public  String fullName = firstName + " " + lastName;;
    public  String successForm = "Thanks for submitting the form";
    public  String gender = faker.options().option("Male", "Female", "Other");
    public  String subjects = faker.options().option("Math", "Arts");
    public  String hobbies = faker.options().option("Sports", "Reading", "Music");
    public  String picturePath = "img/test.jpg";
    public  final String pictureName = "test.jpg";
    public  String state = RandomStateCity.getRandomState();
    public  String city = RandomStateCity.getRandomCity(state);

    //birthday
     Date birthday = faker.date().birthday();

    public  String dayOfBirth = new SimpleDateFormat("dd").format(birthday);
    public  String monthOfBirth = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(birthday);
    public  String yearOfBirth  = new SimpleDateFormat("yyyy").format(birthday);   // "1965"

    public  String fullDateOfBirth =
            Integer.parseInt(dayOfBirth) + " " + monthOfBirth + "," + yearOfBirth;
}