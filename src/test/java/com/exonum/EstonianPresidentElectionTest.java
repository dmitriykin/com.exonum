package com.exonum;

import base.BaseTest;
import components.CandidateDetailsPopup;
import components.PinComponent;
import enums.ActionButton;
import enums.TableEntry;
import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.assertEquals;

@Log
public class EstonianPresidentElectionTest extends BaseTest {


    @Test
    public void eikiNestorTest() {
        MainPage mainPage = openWebApp();

        ElectionsPage electionsPage = mainPage.clickVoteInElections();
        CandidatesPage candidatesPage = electionsPage.selectListRowAndClick(TableEntry.ESTONIA);
        assertEquals(candidatesPage.getListSize(), 4,
                "Candidates of Election page doesn't have expected number of candidates");

        candidatesPage.selectListRow(TableEntry.EIKI_NESTOR);
        assertEquals(sendPostToWikiAndParseResponse(candidatesPage),
                candidatesPage.getWikiInfo(),
                TableEntry.EIKI_NESTOR.getLabel() + "'s information doesn't correspond to official page");

        BallotDetailsPage ballotDetailsPage = candidatesPage.voteInElection(BallotDetailsPage.class);
        PinComponent pinComponent = ballotDetailsPage.clickButton(PinComponent.class, ActionButton.SIGN);
        SignedPage signedPage = pinComponent.clickPinButtons(Arrays.asList(1,2,3,4), SignedPage.class);

    }

    private <T extends CandidatesPage> String sendPostToWikiAndParseResponse(T page) {
        String pageContent = Jsoup.parse(HttpRequest.executePost(page.getWikiLink())).text();
        final String paragraphStartStr = "2015 ";
        pageContent = pageContent.substring(pageContent.indexOf(paragraphStartStr) + paragraphStartStr.length());
        int dotCounter = 0;
        int index = -1;
        char[] charArray = pageContent.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (dotCounter == 2) {
                index = i;
                break;
            }
            if (charArray[i] == '.') dotCounter++;
        }
        pageContent = pageContent.substring(0, index);
        return pageContent;
    }

}
