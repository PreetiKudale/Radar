package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.inbound;

public class TC_007_Inbound extends BaseClass{
    @Test
    public void inboundAccount() {
        try {
            inbound inbound = new inbound(driver);
            inbound.setUserName(p.getProperty("InboundUserName"));
            inbound.setPassword(p.getProperty("Password"));
            inbound.setClickOnsignUp();
            inbound.otpGenerate();
            inbound.otpinput(p.getProperty("OTP"));
            inbound.VerifyOtp();
            inbound.clickCancelpopup();
            inbound.clickonworkspace();
            inbound.clickMyWorkspace();
            inbound.setSelectRowsPerPage();
            inbound.headerCheckbox();
            inbound.exportClick();
            inbound.clickCancelpopupagain();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed due to: " + e.getMessage(), e); // Log exception
            Assert.fail("No data found for Inbound Head. Exception: " + e.getMessage());
        }
        }
    }

