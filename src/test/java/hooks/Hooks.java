package hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.List;

public class Hooks {
    protected Playwright playwright;
    protected com.microsoft.playwright.Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected static final String URL = "http://www.uitestingplayground.com/";

    @Before
    public void setUp() {
        playwright = Playwright.create();
        page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                        .setArgs(List.of("--start-maximized")))
                .newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();
        page.navigate(URL);
    }

    @After
    public void tearDown(){
            page.close();
            playwright.close();
    }
    public Page getPage() {
        return page;
    }
}
