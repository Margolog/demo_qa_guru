package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationCheckComponent {

    public RegistrationCheckComponent checkFormResults(String key, String value) {
        $$("tbody tr")
                .findBy(text(key))
                .$$("td")
                .get(1)
                .shouldHave(text(value));
        return this;
    }
}
