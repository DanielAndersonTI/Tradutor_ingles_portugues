package com.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TranslationTests {
    private com.testes.ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testValidWord1() {
        driver.get("http://localhost:8080/Tradutor_ingles_portugues/index.jsp");
        WebElement input = driver.findElement(By.id("word"));
        input.sendKeys("hello");
        driver.findElement(By.tagName("button")).click();
        WebElement result = driver.findElement(By.tagName("strong"));
        assertEquals("olá", result.getText());
    }

    @Test
    public void testValidWord2() {
        driver.get("http://localhost:8080/Tradutor_ingles_portugues/index.jsp");
        WebElement input = driver.findElement(By.id("word"));
        input.sendKeys("world");
        driver.findElement(By.tagName("button")).click();
        WebElement result = driver.findElement(By.tagName("strong"));
        assertEquals("mundo", result.getText());
    }
}
