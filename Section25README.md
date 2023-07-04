# Section 25 Selenium Framework Interview Questions

1. What is the design pattern you have used in writing the tests in your framework?
	A: Used page object model as well as page factory pattern
	Initialised item for page factory initElements(webDriver) in the constructor
	Used the @FindBy annotations
	How the objects are created by writing them in action methods. Create actions in 
	the object methods.
	By creating a return type of a given page it can be feed to the following page 
	to initalize
2. How are reusable	utilities handled within the framework?
	A: 1. By creating abstract components package which defines commonly used methods 
	that can then be extended by any page object to utilise as needed
	A: 2. Also have a reuseable test utilities - BaseTest which completes all the  
	initialisation, and defines Before and After behaviour
3. Where did you use inheritance OOPS concepts in your framework?
	A: Have reuseable classes and don't want to create these for each and every class 
	but instead allow the class to inherit the functionality using "extends" keyword
	e.g. "extends BaseTest" inherits annotations in BasetTest
4. How did you drive the data from external files in the framework?
	A: Use JSON files to send the data in a parameterised object fashion.  Using the 
	DataProvider in TestNG you can read in the test data. Create a utility to read the 
	data in the JSON file and converts it into a HashMap. Once converted HashMap is 
	passed into the DataProvider.
	Use the Jackson Databind dependancy utilities to convert JSON to HashMap
5. Did you use interfaces in the framework?  If so, what is the scope of it?
	A: Yes through the form of ITestListener via the keyword "implements".  This means that
	each method defined in the interface must be defined in the class that implements it.
	Why use ITestListener interface?  It contains a lot of helpful methods for reporting 
	including taking screenshots on test failures
	WebDriver is also an interface
6. How are you achieving Encapsulation within your framework?
	A: By hiding the implementation details of your class including hiding variables.
	Should not call web elements directly in script - should use methods to execute 
	actions. Protect variables by using keyword "private" on elements of a given class.
	Only expose them via public action methods.
7. Does your framework support parallel runs? How are you writing thread safe code?
	A: Yes, in the testng.xml use the parallel="tests" at suite level allows any tests 
	defined in the suite to be executed in parallel.  There is no conflict as long as
	each class is wrapped in its own test to starts it in its own thread.  
	This prevents overwriting of commonly used data. So they become unique to each 
	thread instance. Saw this error during reporting implementation so used 
	ThreadLocal<ExtentTest> class to provide safe implementation and prevent overwriting
	using getting and setting.
8. Do you have static keywords in the framework? If so what is its usage?
	A: If you use static keyword on webDriver element you cannot run tests in parallel 
	as the webDriver is needed to be used uniquely in each thread.  Otherwise 
	data can be overwritten.  Can use static keyword on elements that will not be 
	"written" to to save memory space.
9. How are you sending Global Properties to your test at runtime?
	A: Using a properties file that has the values read at runtime using the 
	java.util.Properties class to read a file with a .properties extension e.g. define
	environment url, environment name, timeouts or browser names. 
	You can also read parameters from maven command line commands.  
	System.getProperty("browser");
	properties.getProperty("browser"); -D
10. What is the mechanism you use to only run a selected set of tests inside a framework?
	A: Using TestNG @Test(groups={"ErrorHandling"}) as defined in the pom.xml profile id
	Using the <groups> definition in the pom.xml you can limit the execution to given
	group tags are run.
	This can be run from maven using the -P profile command. 
11. How are you handling flaky tests in the framework?
	A: Using the IRetryAnalyzer interface by reattempting execution on a test failure.
12.	Does your framework take screenshots on test failures? How did you implement it?
	A: Yes, using the ITestListener interface from TestNG capture a screenshot in the 
	catch block of a test failure and attach it to a test report via 
	onTestFailure(ITestResult result) method.
13. Explain Framework Architecture
	A: Project Architecture - see "Framework Architecture" diagram
									
