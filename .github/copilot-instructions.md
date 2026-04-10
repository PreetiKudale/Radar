<!-- Guidance for AI coding agents working on the RADAR test automation repo -->
# RADAR — Copilot instructions

Purpose: give an AI agent the minimum, high-value knowledge to be productive in this Selenium + TestNG Maven test automation repository.

- **Quick actions / commands**:
  - Build and run all tests: `mvn test`
  - Run a single TestNG suite (examples are top-level XML suites): `mvn test -Dsurefire.suiteXmlFiles=UserSuite.xml`
  - Run a single test class from Maven: `mvn -Dtest=testCases.TC_001_superAdminExportOption test`

- **High-level architecture / why**:
  - Tests are organized as TestNG suites (root XML files such as [UserSuite.xml](UserSuite.xml)). Suites orchestrate the `testCases` classes which drive `pageObjects`.
  - `pageObjects` contains page-level helpers used by test classes in `testCases` (classic Page Object Model).
  - `utility` contains cross-cutting helpers: reporting (`ExtentReportManager`), screenshots (`ScreenshotUtil`), and an HTML→PDF converter used in the final report.
  - Maven manages deps and test execution via `pom.xml` ([pom.xml](pom.xml)). WebDriver binaries are managed at runtime by WebDriverManager (bonigarcia).

- **Key files to inspect (quick links)**:
  - Test runner / shared test setup: [src/test/java/testCases/BaseClass.java](src/test/java/testCases/BaseClass.java)
  - Configuration: [src/test/resources/config.properties](src/test/resources/config.properties)
  - Page objects: [src/test/java/pageObjects/](src/test/java/pageObjects/)
  - Utilities: [src/test/java/utility/ExtentReportManager.java](src/test/java/utility/ExtentReportManager.java), [src/test/java/utility/ScreenshotUtil.java](src/test/java/utility/ScreenshotUtil.java), [src/test/java/utility/HtmlToPdfConverter.java](src/test/java/utility/HtmlToPdfConverter.java)
  - Test suites at repo root: e.g. [UserSuite.xml](UserSuite.xml), [HeadSuite.xml](HeadSuite.xml), [addNewRegion.xml](addNewRegion.xml)

- **Project-specific conventions & patterns**:
  - Test classes use the `TC_###_Description` naming convention and live under `src/test/java/testCases/`.
  - `BaseClass` sets up WebDriver and ExtentReports. Tests rely on `BaseClass` lifecycle hooks (`@BeforeClass`, `@BeforeMethod`, `@AfterMethod`, `@AfterSuite`). Modifications to test behavior should respect these hooks.
  - Browser control happens via TestNG parameters named `Browser` and `os` (see `@Parameters` in `BaseClass`). Pass via suite XML or test runner args.
  - `config.properties` holds environment-specific values (TestAppURL etc.); code loads it from `src/test/resources/config.properties`.
  - Screenshots and logs are written to repo-level folders `screenshots/` and `logs/` and are referenced by Extent reports under `test-output/ExtentReport.html`.

- **Integration & external dependencies**:
  - Major libs: Selenium, TestNG, ExtentReports, WebDriverManager, Apache POI, OpenHTMLToPDF (PDF conversion).
  - Extent report generation: `ExtentReportManager` writes `test-output/ExtentReport.html`; `HtmlToPdfConverter` converts it to PDF in `@AfterSuite`.

- **Debugging and common modifications**:
  - To debug a flaky browser launch, inspect [BaseClass.java](src/test/java/testCases/BaseClass.java) where options/prefs are set; headless flags are currently commented — enable intentionally if CI requires headless execution.
  - To change the base URL, update [src/test/resources/config.properties](src/test/resources/config.properties).
  - To add a new Page Object, follow existing class naming and put locators + actions in `src/test/java/pageObjects/` and call them from a `TC_` class.

- **Examples (copyable)**:
  - Run the Chrome tests locally: `mvn test -Dbrowser=chrome` (or set `Browser` in the suite XML). The canonical parameter name used in code is `Browser`.
  - Generate a single report after a suite: run suite via Maven and then open `test-output/ExtentReport.html`.

- **What an AI should avoid changing without human review**:
  - `BaseClass` lifecycle sequences and `ExtentReportManager` wiring — small changes here affect all tests.
  - Hard-coded timeouts or global waits — prefer pattern-consistent updates (increase via `BaseClass` or config).

If anything is unclear or you want the instructions expanded (e.g., adding CI steps or example suite-run commands for the team CI), tell me which areas to expand.
