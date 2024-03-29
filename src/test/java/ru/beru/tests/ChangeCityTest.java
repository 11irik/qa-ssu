package ru.beru.tests;

import org.testng.annotations.Test;
import ru.beru.dataProviders.ChangeCityTestDataProvider;
import ru.beru.WebDriverSettings;
import ru.beru.pages.HomePage;
import ru.beru.pages.PassportPage;
import ru.beru.pages.SettingsPage;


public class ChangeCityTest extends WebDriverSettings {

    @Test(dataProvider = "Cities-provider", dataProviderClass = ChangeCityTestDataProvider.class)
    public void changeCity(String defaultCity, String cityName) {
        String login = "lukashintest";
        String password = "Parol1234";
        String buttonText = "Мой профиль";
        //testtest
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.checkCity(defaultCity);
        homePage.changeCity(cityName);
        homePage.checkCity(cityName);
        homePage.openPassportPage();

        PassportPage passportPage = new PassportPage(driver);
        passportPage.fillLoginAndEnter(login);
        passportPage.fillPasswordAndEnter(password);
        homePage.checkSignInButtonText(buttonText);
        homePage.openSettings();

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.checkCityMatches();
    }
}
