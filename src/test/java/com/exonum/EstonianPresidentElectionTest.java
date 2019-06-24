package com.exonum;

import lombok.extern.java.Log;
import org.testng.annotations.*;
import base.BaseTest;
import pages.MainPage;

@Log
public class EstonianPresidentElectionTest extends BaseTest {

    @Test
    public void eikiNestorTest() {
        MainPage mainPage = openWebApp();
    }

}
