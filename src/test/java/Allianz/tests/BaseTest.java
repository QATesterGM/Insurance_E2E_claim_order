package Allianz.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.Properties;

public class BaseTest {
    private static Playwright pw;
    private static Browser browser;
    private BrowserContext context;
    protected Page page;

    @BeforeAll
    static void beforeAll(){
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(0)
                .setChannel("chrome"));
    }

    @BeforeEach
    void beforeEach(){
        context = browser.newContext();
        page = context.newPage();
        page.navigate(Properties.getProperty("webolc.url"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akceptuj pliki cookie")).click();

    }

    @AfterEach
    void afterEach(){
        context.close();
    }

    @AfterAll
    static void afterAll(){
        pw.close();
    }
}
