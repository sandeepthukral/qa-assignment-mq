package sandeep.qa.utils;

import java.util.ArrayList;
import java.util.List;

public class LaterExecution {

    private List<Runnable> listOfMethods = new ArrayList<>();

    // use this to add any Runnable method for later cleanup
    public void addMethod(Runnable methodCall) {
        listOfMethods.add(methodCall);
    }

    // Call this in the After hook method to clean data up
    public void performCleanups()
    {
        System.out.println("Performing Cleanups");
        for(Runnable aMethod : listOfMethods) {
            aMethod.run();
        }
    }
}
