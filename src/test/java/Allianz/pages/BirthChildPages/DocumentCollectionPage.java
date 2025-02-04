package Allianz.pages.BirthChildPages;

import Allianz.DTO.PersonalDataDTO;
import Allianz.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

import java.nio.file.Paths;
@Getter
public class DocumentCollectionPage extends BasePage {


    private Locator documentCollectionMessage;
    private Locator identityCardInputFile;
    private Locator copyOfBirthCertificateInputFile;
    private Locator timeUnlimitCheckbox;
    private Locator identityCardNumberInput;
    private Locator birthCertificateNumberInput;
    private Locator bottomNextButton;
    public DocumentCollectionPage(Page page){
        super(page);
        this.identityCardInputFile = page.locator("input[type=file]").first();
        this.copyOfBirthCertificateInputFile = page.locator("input[type=file]").last();
        this.documentCollectionMessage = page.getByText("Dodaj dokumenty obowiązkowe");
        this.timeUnlimitCheckbox = page.locator("#nx-checkbox-250-label span");
        this.birthCertificateNumberInput = page.getByLabel("numer aktu urodzenia");
        this.bottomNextButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dalej"));
        this.identityCardNumberInput = page.getByLabel("numer dowodu osobistego");
    }

    private DocumentCollectionPage uploadIdentityCard(){
        identityCardInputFile.setInputFiles(Paths.get("uploads/Identity Card.pdf"));
        return this;
    }

    private DocumentCollectionPage uploadCopyOfBirthCertificate(){
        copyOfBirthCertificateInputFile.setInputFiles(Paths.get("uploads/Copy of Birth Certificate.pdf"));
        return this;
    }

    private DocumentCollectionPage clickUnlimitedCheckbox(){
        timeUnlimitCheckbox.click();
        return this;
    }

    private DocumentCollectionPage fillIdentityCardNumber(String idCardNumber){
        identityCardNumberInput.fill(idCardNumber);
        return this;
    }

    public ConsentsCollectionPage clickNextButton(){
        bottomNextButton.click();
        return new ConsentsCollectionPage(page);
    }

    private DocumentCollectionPage fillBirthCertificatenumber(String certificateNumber){
        birthCertificateNumberInput.fill(certificateNumber);
        page.keyboard().press("Escape");
        page.waitForTimeout(5000);
        return this;
    }

    public DocumentCollectionPage fillDocumentCollectionForm(){
        uploadIdentityCard()
                .uploadCopyOfBirthCertificate()
                .clickUnlimitedCheckbox()
                .fillIdentityCardNumber(PersonalDataDTO.getDeafaultPersonalDataDTO().getIdentityCardNumber())
                .fillBirthCertificatenumber(PersonalDataDTO.getDeafaultPersonalDataDTO().getBirthCertificateNumber());
        return this;
    }

}
