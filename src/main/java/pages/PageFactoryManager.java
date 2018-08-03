package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import pages.DealsBrowseDealAndCostPO;
import pages.DealsMaintainPO;
import pages.DealsSODLDetailsPO;
import pages.DealsSODLSearchAndMaintainPO;
import pages.DealsSODLTransactionPO;
import pages.DealsSearchPO;
import pages.DealBuilderPagePO;
import pages.OfferAccpetPO;
import pages.OfferCreatePO;
import pages.OfferMaintainPO;
import pages.OfferMassUploadPO;
import pages.OfferReviewPO;
import pages.OfferSearchPO;
import pages.DashboardPagePO;
import pages.LoginPagePO;

public class PageFactoryManager {
	private static LoginPagePO loginPage;
	private static DashboardPagePO dashboardPage;
	private static OfferCreatePO offerCreatePage;
	private static DealBuilderPagePO dealBuilderPage;
	private static OfferReviewPO offerReviewPage;
	private static OfferAccpetPO offerAcceptPage;
	private static OfferSearchPO offerSearchPage;
	private static OfferMaintainPO offerMaintainPage;
	private static OfferMassUploadPO offerMassUploadPage;
	private static DealsBrowseDealAndCostPO dealsBrowserDealAndCostPage;
	private static DealsMaintainPO dealsMaintainPage;
	private static DealsSearchPO dealsSearchPage;
	private static DealsSODLDetailsPO dealsSODLDetailsPage;
	private static DealsSODLSearchAndMaintainPO dealsSODLSearchAndMaintainPage;
	private static DealsSODLTransactionPO dealsSODLTransactionPage;
	private static BrowseDealAndCostPagePO browseDealAndCostPage;
	private static LGCreatePO createLocationGroupPage;
	private static LGMaintainPO locationGroupMaintainPage;
	private static CostMaintainPagePO costMaintainPage;
	private static CostLinkMaintenancePO costLinkMainenancePage;
	private static CommonPagePO commonPage;

	private static AbstractTest abstractTestPage;

	public static CommonPagePO getCommonPage(WebDriver driver_) {
		if (commonPage == null) {
			return new CommonPagePO(driver_);
		}
		return commonPage;
	}

	public static LoginPagePO getLoginPage(WebDriver driver_) {
		if (loginPage == null) {
			return new LoginPagePO(driver_);
		}
		return loginPage;
	}

	public static DashboardPagePO getDashboardPage(WebDriver driver_) {
		if (dashboardPage == null) {
			return new DashboardPagePO(driver_);
		}
		return dashboardPage;
	}

	public static OfferCreatePO getOfferCreatePage(WebDriver driver_) {
		if (offerCreatePage == null) {
			return new OfferCreatePO(driver_);
		}
		return offerCreatePage;

	}

	public static DealBuilderPagePO getDealBuilderPage(WebDriver driver_) {
		if (dealBuilderPage == null) {
			return new DealBuilderPagePO(driver_);
		}
		return dealBuilderPage;
	}

	public static OfferReviewPO getOfferReviewPage(WebDriver driver_) {
		if (offerReviewPage == null) {
			return new OfferReviewPO(driver_);
		}
		return offerReviewPage;
	}

	public static OfferAccpetPO getOfferAcceptPage(WebDriver driver_) {
		if (offerAcceptPage == null) {
			return new OfferAccpetPO(driver_);
		}
		return offerAcceptPage;
	}

	public static OfferMaintainPO getOfferMaintainPage(WebDriver driver_) {
		if (offerMaintainPage == null) {
			return new OfferMaintainPO(driver_);
		}
		return offerMaintainPage;
	}

	public static OfferSearchPO getOfferSearchPage(WebDriver driver_) {
		if (offerSearchPage == null) {
			return new OfferSearchPO(driver_);
		}
		return offerSearchPage;
	}

	public static OfferMassUploadPO getOfferMassUploadPage(WebDriver driver_) {
		if (offerMassUploadPage == null) {
			return new OfferMassUploadPO(driver_);
		}
		return offerMassUploadPage;
	}

	public static DealsBrowseDealAndCostPO getDealsBrowserDealAndCostPage(WebDriver driver_) {
		if (dealsBrowserDealAndCostPage == null) {
			return new DealsBrowseDealAndCostPO(driver_);
		}
		return dealsBrowserDealAndCostPage;
	}

	public static DealsMaintainPO getDealsMaintainPage(WebDriver driver_) {
		if (dealsMaintainPage == null) {
			return new DealsMaintainPO(driver_);
		}
		return dealsMaintainPage;
	}

	public static DealsSearchPO getDealsSearchPage(WebDriver driver_) {
		if (dealsSearchPage == null) {
			return new DealsSearchPO(driver_);
		}
		return dealsSearchPage;
	}

	public static DealsSODLDetailsPO getDealsSODLDetailsPage(WebDriver driver_) {
		if (dealsSODLDetailsPage == null) {
			return new DealsSODLDetailsPO(driver_);
		}
		return dealsSODLDetailsPage;
	}

	public static DealsSODLSearchAndMaintainPO getDealsSODLSearchAndMaintainPage(WebDriver driver_) {
		if (dealsSODLSearchAndMaintainPage == null) {
			return new DealsSODLSearchAndMaintainPO(driver_);
		}
		return dealsSODLSearchAndMaintainPage;
	}

	public static DealsSODLTransactionPO getDealsSODLTransactionPage(WebDriver driver_) {
		if (dealsSODLTransactionPage == null) {
			return new DealsSODLTransactionPO(driver_);
		}
		return dealsSODLTransactionPage;
	}

	public static BrowseDealAndCostPagePO getBrowseDealAndCostPage(WebDriver driver_) {
		if (browseDealAndCostPage == null) {
			return new BrowseDealAndCostPagePO(driver_);
		}
		return browseDealAndCostPage;
	}

	public static LGCreatePO getCreateLocationGroupPage(WebDriver driver_) {
		if (createLocationGroupPage == null) {
			return new LGCreatePO(driver_);
		}
		return createLocationGroupPage;
	}
	
	public static LGMaintainPO getLocationGroupMaintainPage(WebDriver driver_) {
		if (locationGroupMaintainPage == null) {
			return new LGMaintainPO(driver_);
		}
		return locationGroupMaintainPage;
	}
	
	public static CostMaintainPagePO getCostMaintainPage(WebDriver driver_) {
		if (costMaintainPage == null) {
			return new CostMaintainPagePO(driver_);
		}
		return costMaintainPage;
	}
	
	public static CostLinkMaintenancePO getCostLinkMaintainPage(WebDriver driver_) {
		if (costMaintainPage == null) {
			return new CostLinkMaintenancePO(driver_);
		}
		return costLinkMainenancePage;
	}

	public static AbstractTest getAbstractTestPage(WebDriver driver_) {
		if (abstractTestPage == null) {
			return new AbstractTest(driver_);
		}
		return abstractTestPage;
	}

}
