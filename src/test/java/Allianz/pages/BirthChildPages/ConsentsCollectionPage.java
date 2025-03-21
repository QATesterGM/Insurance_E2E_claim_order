package Allianz.pages.BirthChildPages;

import Allianz.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

public class ConsentsCollectionPage extends BasePage {

    @Getter
    private Locator ConsentsCollectionMessage;
    private Locator allConsentsCheckbox;
    private Locator pepCheckbox;
    private Locator usaTaxpayerCheckbox;
    private Locator bottomNextButton;

    public ConsentsCollectionPage(Page page) {
        super(page);
        this.ConsentsCollectionMessage = page.getByText("Przeczytaj i podaj nam dodatkowe informacje");
        this.allConsentsCheckbox = page.locator("#nx-checkbox-251-label");
        this.pepCheckbox = page.locator("span[class=nx-radio__label--text]").filter(new Locator.FilterOptions().setHasText("Nie")).first();
        this.usaTaxpayerCheckbox = page.locator("span[class=nx-radio__label--text]").filter(new Locator.FilterOptions().setHasText("Nie")).last();
        this.bottomNextButton = page.locator("//button[@type='submit']");
    }

    private ConsentsCollectionPage clickAllConsentsCheckbox() {
        allConsentsCheckbox.click();
        return this;
    }

    private ConsentsCollectionPage clickPepCheckbox() {
        pepCheckbox.check();
        return this;
    }

    private ConsentsCollectionPage clickUsaTaxpayerCheckbox() {
        usaTaxpayerCheckbox.click();
        page.waitForTimeout(1500);
        return this;
    }

    public TicketSummaryPage clickNextButton() {
        bottomNextButton.click();
        return new TicketSummaryPage(page);
    }

    public ConsentsCollectionPage fillConsetnsForm() {
        clickAllConsentsCheckbox()
                .clickPepCheckbox()
                .clickUsaTaxpayerCheckbox();
        return this;
    }

}
