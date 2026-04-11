package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationCheckComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    RegistrationCheckComponent registrationCheck = new RegistrationCheckComponent();

    //Elements
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderInput = $("#genterWrapper");
    private SelenideElement numberInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesInput = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateInput = $("#state input");
    private SelenideElement cityInput = $("#city input");
    private SelenideElement submitButton = $("#submit");

    //Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setData(day, month, year);
        return this;
    }


    public RegistrationPage typeSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        ;
        return this;
    }

    public RegistrationPage typeHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        ;
        return this;
    }

    public RegistrationPage uploadPhoto(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage typeState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage typeCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage clickSubmitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationPage registrationCheck(String key, String value) {
        registrationCheck.checkTitle("Thanks for submitting the form");
        registrationCheck.checkField(key, value);
        return this;
    }
}
