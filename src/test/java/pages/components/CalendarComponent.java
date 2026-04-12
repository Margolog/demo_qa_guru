package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setData(String day, String month, String year) {
        String formattedDay = String.format("%03d", Integer.parseInt(day));
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--" + formattedDay + ":not(.react-datepicker__day--outside-month)").click();
        $("#dateOfBirthInput").pressTab();
    }
}