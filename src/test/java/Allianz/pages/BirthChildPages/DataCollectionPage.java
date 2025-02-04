package Allianz.pages.BirthChildPages;

import Allianz.pages.BasePage;
import Allianz.DTO.PersonalDataDTO;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

import java.util.regex.Pattern;

import static com.microsoft.playwright.options.AriaRole.*;
import static java.util.regex.Pattern.*;

@Getter
public class DataCollectionPage extends BasePage {
    private final Locator insuredPersonYesButton;
    private final Locator insuredPersonQuestionMessage;
    private final Locator imieInput;
    private final Locator nazwiskoInput;
    private final Locator peselInput;
    private final Locator emailInput;
    private final Locator confirmMailInput;
    private final Locator countryOfResidenceCombobox;
    private final Locator countryOfBirthCombobox;
    private final Locator citizenshipCombobox;
    private final Locator phoneNumberInput;
    private final Locator childNameInput;
    private final Locator childSurnameInput;
    private final Locator childPESELInput;
    private final Locator bankAccountNumberInput;
    private final Locator bottomNextButton;

    public DataCollectionPage(Page page) {
        super(page);
        this.insuredPersonYesButton = page.locator("#nx-circle-toggle-group-6-button-31-label div").getByText("Tak");
        this.insuredPersonQuestionMessage = page.getByText("Czy jesteś osobą ubezpieczoną?");
        this.imieInput = page.locator("#nx-input-21");
        this.nazwiskoInput = page.locator("#nx-input-22");
        this.peselInput = page.getByLabel("numer PESEL", new Page.GetByLabelOptions().setExact(true)).first();
        this.emailInput = page.getByLabel("adres e-mail", new Page.GetByLabelOptions().setExact(true));
        this.confirmMailInput = page.getByLabel("powtórz adres e-mail");
        this.countryOfResidenceCombobox = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("kraj zamieszkania *"));//.locator("div").first();
        this.citizenshipCombobox = page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^obywatelstwa, które posiadasz$"))).first();
        this.phoneNumberInput = page.getByText("numer telefonu komórkowego");
        this.countryOfBirthCombobox = page.getByRole(COMBOBOX, new Page.GetByRoleOptions().setName("kraj urodzenia *"));
        this.childNameInput = page.locator("#nx-input-28");
        this.childSurnameInput = page.locator("#nx-input-29");
        this.childPESELInput = page.getByLabel("numer PESEL").last();
        this.bankAccountNumberInput = page.getByLabel("numer polskiego rachunku bankowego");
        this.bottomNextButton = page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Dalej"));
    }

    private DataCollectionPage selectCountryOfResidence(String countryOfResidence) {
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("kraj zamieszkania *")).locator("div").first().click();
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("kraj zamieszkania *")).locator("div").first().click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Polska")).click();
        return this;
    }

    private DataCollectionPage selectCountryOfBirth(String countryOfBirth) {
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("kraj urodzenia *")).click();
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("kraj urodzenia *")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Algieria")).click();
        return this;
    }

    private DataCollectionPage selectCitizenship(String citizenship) {
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("obywatelstwa, które posiadasz *")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Albania")).click();
        page.keyboard().press("Escape");
        return this;
    }

    private DataCollectionPage fillName(String name) {
        imieInput.fill(name);
        return this;
    }

    private DataCollectionPage fillSurname(String surname) {
        nazwiskoInput.fill(surname);
        return this;
    }

    private DataCollectionPage fillEmail(String email) {
        emailInput.fill(email);
        confirmMailInput.fill(email);
        return this;
    }

    private DataCollectionPage fillPesel(String pesel) {
        peselInput.fill(pesel);
        return this;
    }

    private DataCollectionPage fillPhoneNumber(String phoneNumber) {
        phoneNumberInput.fill(phoneNumber);
        return this;
    }

    private DataCollectionPage clickInsuredPersonYesButton() {
        insuredPersonYesButton.click();
        return this;
    }

    private DataCollectionPage fillChildName(String childName) {
        childNameInput.fill(childName);
        return this;
    }

    private DataCollectionPage fillChildSurname(String childSurname) {
        childSurnameInput.fill(childSurname);
        return this;
    }

    private DataCollectionPage fillChildPesel(String childPesel) {
        childPESELInput.fill(childPesel);
        return this;
    }

    private DataCollectionPage fillBankAccountNumber(String accountNumber) {
        bankAccountNumberInput.fill(accountNumber);
        return this;
    }

    public DocumentCollectionPage clickNextButton() {
        bottomNextButton.click();
        return new DocumentCollectionPage(page);
    }

    public DataCollectionPage fillDataCollectionForm(PersonalDataDTO personalDataDTO) {
        clickInsuredPersonYesButton()
                .fillName(PersonalDataDTO.getDeafaultPersonalDataDTO().getName())
                .fillSurname(PersonalDataDTO.getDeafaultPersonalDataDTO().getSurname())
                .fillEmail(PersonalDataDTO.getDeafaultPersonalDataDTO().getEmail())
                .fillPesel(PersonalDataDTO.getDeafaultPersonalDataDTO().getPesel())
                .selectCountryOfResidence(PersonalDataDTO.getDeafaultPersonalDataDTO().getCountryOfResidence())
                .fillPhoneNumber(PersonalDataDTO.getDeafaultPersonalDataDTO().getPhoneNumber())
                .selectCountryOfBirth(PersonalDataDTO.getDeafaultPersonalDataDTO().getCountryOfBirth())
                .fillChildName(PersonalDataDTO.getDeafaultPersonalDataDTO().getChildName())
                .fillChildSurname(PersonalDataDTO.getDeafaultPersonalDataDTO().getChildSurname())
                .selectCitizenship(PersonalDataDTO.getDeafaultPersonalDataDTO().getCitizenship())
                .fillChildPesel(PersonalDataDTO.getDeafaultPersonalDataDTO().getChildPesel())
                .fillBankAccountNumber(PersonalDataDTO.getDeafaultPersonalDataDTO().getAccountNumber());

        return this;
    }

}
