

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTest {
    @Test
    public void shouldSubmitRequestWithNormalName() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id=name] input").setValue("Иванов Иван");
        form.$("[data-test-id=phone] input").setValue("+79091234567");
        form.$("[data-test-id=agreement").click();
        form.$("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    public void shouldSubmitRequestWithDoubleSurname() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id=name] input").setValue("Иванов-Сидоров Иван");
        form.$("[data-test-id=phone] input").setValue("+79091234567");
        form.$("[data-test-id=agreement").click();
        form.$("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}