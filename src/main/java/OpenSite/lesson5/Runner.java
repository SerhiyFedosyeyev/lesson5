package OpenSite.lesson5;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {
    public static void main(String[] args) {
        //run OpenGooglePage test
        Result result = JUnitCore.runClasses(OpenGooglePage.class);
        if (result.wasSuccessful()) {
            System.out.println("Success");
        } else System.out.println("Failed" + result.getFailures());

        //working with failures
        for (Failure failure : result.getFailures()) {
            System.err.println("Exception - " + failure.getException());
            System.err.println("Trace - " + failure.getTrace());
        }
    }
}
