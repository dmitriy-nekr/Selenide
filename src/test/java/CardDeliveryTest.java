import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {


    @Test
    public void shouldCorrectWorkTest() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Новосибирск");
        $("[data-test-id=date] input").sendKeys(Keys.CONTROL + "A");
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue("23.02.2023");
        $x("//*[@data-test-id='name']//input").setValue("Петров Василий");
        $x("//*[@data-test-id='phone']//input").setValue("+79184582645");
        $("[data-test-id=agreement]").click();
        $x("//*[contains(text(),'Забронировать')]").click();
        $x("//div[@data-test-id='notification']").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }
}
