package sandeep.qa.utils;

import sandeep.qa.steps.Context;

public class Cleanups{

    private Context context;

    public Cleanups(Context context){
        this.context = context;
    }

    // Add Runnable methods here that will be executed later

    public Runnable cleanupEmployee = new Runnable(){
        public void run() {
            context.endpointsApi.deleteEmployee();
        }

    };
}
