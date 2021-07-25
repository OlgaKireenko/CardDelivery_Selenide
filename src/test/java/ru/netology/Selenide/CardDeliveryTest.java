package ru.netology.Selenide;

import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.open;
import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class CardDeliveryTest {

    @Test
    public void shouldOrderDelivery() {
        LocalDate date = LocalDate.now();
        LocalDate date1 = date.plusDays(3);
        open("http://localhost:9999");
        $(".input__control").setValue("Москва");
        $(".input__inner").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[type='date']").setValue(String.valueOf(date1));
        $("[name='name']").setValue("Ольга Киреенко");
        $("[name='phone']").setValue("+79640000000");
        $(".checkbox__box").click();
        $(byText("Забронировать")).click();
        $(withText("Успешно")).shouldBe(visible, Duration.ofSeconds(15));

    }

    }

