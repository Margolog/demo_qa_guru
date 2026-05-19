package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxPage {

    //Elements
    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement permanentAddressInput = $("#permanentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $("#output");

    //Actions
    @Step("Открыть text box")
    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    @Step("Заполнить имя \"{value}\"")
    public TextBoxPage typeUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    @Step("Заполнить email \"{value}\"")
    public TextBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Заполнить текущий адресс \"{value}\"")
    public TextBoxPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Заполнить временный адресс \"{value}\"")
    public TextBoxPage typePermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    @Step("Нажать на кнопку submit")
    public TextBoxPage clickSubmitForm() {
        submitButton.click();
        return this;
    }

    @Step("Проверить результат регистрации \"{key}\" и \"{value}\"")
    public TextBoxPage checkField(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));
        return this;
    }

    @Step("Проверить что форма не отображается")
    public TextBoxPage checkFieldNotExist(String key) {
        outputResults.$(byId(key)).shouldNot(exist);
        return this;
    }
}
