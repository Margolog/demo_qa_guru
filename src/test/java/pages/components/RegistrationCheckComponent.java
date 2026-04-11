package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationCheckComponent {
    private SelenideElement outputResults = $(".table-responsive tr");

    public RegistrationCheckComponent checkFormResults(String key, String value) {
        outputResults
                .find(String.valueOf(Condition.text(key)))
                .find(String.valueOf(Condition.text(value)));
        return this;
    }
}
