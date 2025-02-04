package Allianz.tests;

import Allianz.DTO.PersonalDataDTO;
import Allianz.pages.BirthChildPages.*;
import Allianz.pages.BirthChildPages.DataCollectionPage;
import Allianz.pages.BirthChildPages.DocumentCollectionPage;
import Allianz.pages.BirthChildPages.TicketSummaryPage;
import Allianz.pages.HomePage;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

class UrodzenieDzieckaTest extends BaseTest{

    @Test
    void should_register_child_birth_test(){

        HomePage homePage = new HomePage(page);

        homePage.chooseBirthChild();
        DataCollectionPage dataCollectionPage = homePage.clickNextButton();
        assertThat(dataCollectionPage.getInsuredPersonQuestionMessage()).isVisible();

        dataCollectionPage.fillDataCollectionForm(PersonalDataDTO.getDeafaultPersonalDataDTO());
        DocumentCollectionPage documentCollectionPage = dataCollectionPage.clickNextButton();
        PlaywrightAssertions.assertThat(documentCollectionPage.getDocumentCollectionMessage()).isVisible();

        documentCollectionPage.fillDocumentCollectionForm();
        ConsentsCollectionPage consentsCollectionPage = documentCollectionPage.clickNextButton();
        PlaywrightAssertions.assertThat(consentsCollectionPage.getConsentsCollectionMessage()).isVisible();

        consentsCollectionPage.fillConsetnsForm();
        TicketSummaryPage ticketSummaryPage = consentsCollectionPage.clickNextButton();


    }
}
