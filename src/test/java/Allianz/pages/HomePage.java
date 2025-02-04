package Allianz.pages;

import Allianz.pages.BirthChildPages.DataCollectionPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import java.util.regex.Pattern;



@Getter
public class HomePage extends BasePage {

    private final Locator homePageMessage;
    private final Locator urodzenieDzieckaButton;
    private final Locator dzieckoButton;
    private Locator urodzenieButton;
    private Locator dalejButton;


    public HomePage(Page page) {
        super(page);
        this.homePageMessage = page.getByAltText("Czego dotyczy Twoje zgłoszenie?");
        this.urodzenieDzieckaButton = page.locator("span").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Urodzenie dziecka$")));
        this.dzieckoButton = page.locator("span").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Dziecko$")));
        this.urodzenieButton = page.locator("span").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Urodzenie$")));
        this.dalejButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dalej"));
    }

    private HomePage clickBirthChildCategory() {
        urodzenieDzieckaButton.click();
        return this;
    }

    private HomePage clickChildButton() {
        dzieckoButton.click();
        return this;
    }

    private void clickBirthButton() {
        urodzenieButton.click();
    }

    public DataCollectionPage clickNextButton() {
        dalejButton.click();
        return new DataCollectionPage(page);
    }
public HomePage chooseBirthChild() {
        clickBirthChildCategory()
        .clickChildButton()
        .clickBirthButton();
        return this;
    }
}
