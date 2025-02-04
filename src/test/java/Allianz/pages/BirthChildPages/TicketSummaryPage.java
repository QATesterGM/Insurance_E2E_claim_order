package Allianz.pages.BirthChildPages;

import Allianz.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TicketSummaryPage extends BasePage {

    private Locator ticketSummaryMessage;
    private Locator bottonNextButton;
    public TicketSummaryPage(Page page){
        super(page);
        this.ticketSummaryMessage = page.getByText("Twoje potwierdzenie zgłoszenia");
        this.bottonNextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("dalej"));
    }

    public TicketSummaryPage clickNextButton(){
        bottonNextButton.click();
        return new TicketSummaryPage(page);
    }
}
