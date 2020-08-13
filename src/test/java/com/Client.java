//package com;
//
//import org.junit.platform.launcher.Launcher;
//import org.junit.platform.launcher.LauncherDiscoveryRequest;
//import org.junit.platform.launcher.TestPlan;
//import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
//import org.junit.platform.launcher.core.LauncherFactory;
//import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
//import org.junit.platform.launcher.listeners.TestExecutionSummary;
//
//import java.io.PrintWriter;
//
//import static org.junit.platform.engine.discovery.ClassNameFilter.STANDARD_INCLUDE_PATTERN;
//import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
//import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
//
//public class Client {
//    SummaryGeneratingListener listener = new SummaryGeneratingListener();
//
//    public void launchAllTests() {
//
//        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
//                .selectors(selectPackage("com.itvdn"))
//                .filters(includeClassNamePatterns(STANDARD_INCLUDE_PATTERN))
//                .build();
//        Launcher launcher = LauncherFactory.create();
//        TestPlan testPlan = launcher.discover(request);
//        launcher.registerTestExecutionListeners(listener);
//        launcher.execute(request);
//    }
//
//    public static void main(String[] args) {
//        Client runner = new Client();
//        runner.launchAllTests();
//
//        TestExecutionSummary summary = runner.listener.getSummary();
//        summary.printTo(new PrintWriter(System.out));
//    }
//}
