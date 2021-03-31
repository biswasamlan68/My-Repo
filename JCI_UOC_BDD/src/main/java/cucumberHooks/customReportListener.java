package cucumberHooks;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.testng.IDataProviderListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.Event;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCaseStarted;

import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.gherkin.model.Feature;
	import com.aventstack.extentreports.gherkin.model.Given;
	
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.formatter.Formatter;

	import io.cucumber.plugin.event.TestRunFinished;
	import io.cucumber.plugin.event.TestRunStarted;
	import io.cucumber.plugin.event.TestSourceRead;
	import io.cucumber.plugin.event.TestStepFinished;
	import io.cucumber.plugin.event.TestStepStarted;
	import io.cucumber.plugin.event.HookTestStep;
	import java.util.HashMap;
	import java.util.Map;

import cucumber.api.TestStep;
import cucumber.api.event.*;
	
	
	public class customReportListener implements Formatter {
	private ExtentSparkReporter spark;
	private ExtentReports extent;
	Map<String, ExtentTest> feature = new HashMap<String, ExtentTest>();
	ExtentTest scenario;
	ExtentTest step;
	
	
	public customReportListener() {
	  
		
	
	};
	

	@Override
	public void setEventPublisher(cucumber.api.event.EventPublisher publisher) {
		// TODO Auto-generated method stub
		
		publisher.registerHandlerFor(cucumber.api.event.TestRunStarted.class, this::runStarted );
		
		publisher.registerHandlerFor(cucumber.api.event.TestSourceRead.class, this::featureRead);
		publisher.registerHandlerFor(cucumber.api.event.TestCaseStarted.class, this::ScenarioStarted);
		publisher.registerHandlerFor(cucumber.api.event.TestStepStarted.class, this::stepStarted);
		publisher.registerHandlerFor(cucumber.api.event.TestStepFinished.class, this::stepFinished); 
		publisher.registerHandlerFor(cucumber.api.event.TestRunFinished.class, this::runFinished);
	
	}
		
	/*
	@Override
	public void setEventPublisher(cucumber.api.event.EventPublisher publisher) {
		// TODO Auto-generated method stub
	/*
	* :: is method reference , so this::collecTag means collectTags method in
	* 'this' instance. Here we says runStarted method accepts or listens to
	* TestRunStarted event type

	
	publisher.registerHandlerFor(TestRunStarted.class, this::runStarted);
	publisher.registerHandlerFor(TestRunFinished.class, this::runFinished);
	publisher.registerHandlerFor(TestSourceRead.class, this::featureRead);
	publisher.registerHandlerFor(TestCaseStarted.class, this::ScenarioStarted);
	publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
	publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished); 
		
	};*/
	/*
	* Here we set argument type as TestRunStarted if you set anything else then the
	* corresponding register shows error as it doesn't have a listner method that
	* accepts the type specified in TestRunStarted.class
	*/
	// Here we create the reporter
	
	private void runStarted(cucumber.api.event.TestRunStarted event) {
	
		
	extent = new ExtentReports();
	spark = new ExtentSparkReporter("./ExtentReport/ExtentReportResults.html");
	
	spark.config().setTheme(Theme.DARK);
	// Create extent report instance with spark reporter
	extent.attachReporter(spark);
	
		
	};
	
	// This event is triggered when feature file is read
	
	// here we create the feature node
	private void featureRead(cucumber.api.event.TestSourceRead event) {
	//String featureSource = event.getUri().toString();	
	String featureSource = event.uri.toString();
	System.out.println(featureSource);
	//String featureName = featureSource.split(".*/")[1];
	String featureName = featureSource.split(".*/")[1];
	System.out.println(featureName);
	if (feature.get(featureSource) == null) {
	feature.putIfAbsent(featureSource, extent.createTest(featureName));
	}
	};
	
	
	// This event is triggered when Test Case is started
	// here we create the scenario node
	private void ScenarioStarted(cucumber.api.event.TestCaseStarted event) {
	//String featureName = event.getTestCase().getUri().toString();
	String featureName =event.testCase.getUri().toString(); 
	System.out.println("Test"+featureName);
	//scenario = feature.get(featureName).createNode(event.getTestCase().getName());
	scenario = feature.get(featureName).createNode(event.testCase.getName());
	scenario.log(Status.PASS, "Passed");
	};
	
	
	// step started event
	// here we creates the test node
	private void stepStarted(cucumber.api.event.TestStepStarted event) {
	String stepName = " ";
	String keyword = "Triggered the hook :";
	// We checks whether the event is from a hook or step
	//if (event.getTestStep() instanceof PickleStepTestStep) {
	//if (event.testStep instanceof PickleStepTestStep){
	if (event.testStep instanceof TestStep){
	// TestStepStarted event implements PickleStepTestStep interface
	// WHich have additional methods to interact with the event object
	// So we have to cast TestCase object to get those methods
	//PickleStepTestStep steps = (PickleStepTestStep) event.getTestStep();
	TestStep steps = (TestStep) event.testStep;
	//stepName = steps.getStep().getText();
	stepName = steps.getStepText();
	System.out.println(stepName);
	//keyword = steps.getStep().getKeyWord();
	//System.out.println(keyword);
	} /*else {
	// Same with HoojTestStep
	//HookTestStep hoo = (HookTestStep) event.getTestStep();
		HookTestStep hoo = (HookTestStep) event.testStep;
	stepName = hoo.getHookType().name();
	}*/
	step = scenario.createNode(Given.class, keyword + " " + stepName);
	};
	// This is triggered when TestStep is finished
	private void stepFinished(cucumber.api.event.TestStepFinished event) {
	//if (event.getResult().getStatus().toString() == "PASSED") {
		
		if (event.result.getStatus().toString() == "PASSED") {
		
	step.log(Status.PASS, "This passed");
	} //else if (event.getResult().getStatus().toString() == "SKIPPED")
		else if (event.result.getStatus().toString() == "SKIPPED")
	{
	step.log(Status.SKIP, "This step was skipped ");
	} else {
	step.log(Status.FAIL, "This failed");
	}
	}
	
	// TestRunFinished event is triggered when all feature file executions are
		// completed
		private void runFinished(cucumber.api.event.TestRunFinished event) {
			System.out.println("Test");
			//step.log(Status.PASS, "Passed");
		extent.flush();
		};


	}
