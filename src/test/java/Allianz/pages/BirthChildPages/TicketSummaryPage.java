package Allianz.pages.BirthChildPages;

import Allianz.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

public class TicketSummaryPage extends BasePage {

    @Getter
    private Locator ticketSummaryMessage;
    private Locator bottonNextButton;
    public TicketSummaryPage(Page page){
        super(page);
        this.ticketSummaryMessage = page.getByText("Twoje potwierdzenie zgłoszenia");
        this.bottonNextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("dalej"));
    }

    public TicketConfirmationPage clickNextButton(){
        bottonNextButton.click();
        return new TicketConfirmationPage(page);
    }
}
