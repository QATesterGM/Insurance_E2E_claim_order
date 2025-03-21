package Allianz.pages.BirthChildPages;

import Allianz.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

public class TicketConfirmationPage extends BasePage {

    @Getter
    private Locator ticketConfirmationMessage;
    @Getter
    private Locator wrongCodeMessage;
    private Locator firstPinNumber;
    private Locator secondPinNumber;
    private Locator thirdPinNumber;
    private Locator fourtPinNumber;
    public TicketConfirmationPage(Page page){
        super(page);
        this.ticketConfirmationMessage = page.getByText("Potwierdź zgłoszenie kodem SMS");
        this.wrongCodeMessage = page.getByText("Podany kod 1097 nie jest prawidłowy.");
        this.firstPinNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("1 of 4"));
        this.secondPinNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("2 of 4"));
        this.thirdPinNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("3 of 4"));
        this.fourtPinNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("4 of 4"));
    }

    public void fillPinNumberAndConfirm(){
        firstPinNumber.fill("1");
        secondPinNumber.fill("0");
        thirdPinNumber.fill("9");
        fourtPinNumber.fill("7");
        page.keyboard().press("Enter");
    }
}
