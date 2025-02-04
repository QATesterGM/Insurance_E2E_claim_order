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
        this.allConsentsCheckbox = page.getByText("Zaznacz wszystkie zgody");
        this.pepCheckbox = page.locator("[id=\"nx-radio-3-0\\.h63soro5ice-label\"]").getByText("Nie");
        this.usaTaxpayerCheckbox = page.locator("[id=\"nx-radio-7-0\\.nnw7owqxor-label\"]").getByText("Nie");
        //this.usaTaxpayerCheckbox = page.locator("#nx-radio-7-0 label]").filter(new Locator.FilterOptions().setHasText("Nie"));
        this.bottomNextButton = page.locator("//button[@type='submit']");
    }

    private ConsentsCollectionPage clickAllConsentsCheckbox() {
        allConsentsCheckbox.click();
        return this;
    }

    private ConsentsCollectionPage clickPepCheckbox() {
        pepCheckbox.click();
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
        page.pause();
        clickAllConsentsCheckbox()
                .clickPepCheckbox()
                .clickUsaTaxpayerCheckbox();
        return this;
    }

}
