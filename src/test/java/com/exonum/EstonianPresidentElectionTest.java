package com.exonum;

import base.BaseTest;
import enums.TableEntry;
import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.testng.annotations.Test;
import pages.BallotPage;
import pages.CandidatesPage;
import pages.ElectionsPage;
import pages.MainPage;
import utils.HttpRequest;

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


        BallotPage ballotPage = candidatesPage.ballotPage();


    }

    private <T extends CandidatesPage> String sendPostToWikiAndParseResponse(T page) {
        String str = Jsoup.parse(HttpRequest.executePost(page.getWikiLink())).text();
        String result = str.substring(126, 288);
        return result;
    }

}
