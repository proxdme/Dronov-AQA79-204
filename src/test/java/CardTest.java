import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardTest {
    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void shouldTest() {
        open("http://localhost:9999");

        $("[data-test-id=name] input.input__control").setValue("Петров Иван");
        $("[data-test-id=phone] input.input__control").setValue("+79261234567");
        $("[data-test-id=agreement]").click();
        $("button.button.button_view_extra.button_size_m.button_theme_alfa-on-white > span.button__content > span.button__text\n").click();
        $("[data-test-id=order-success").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}

