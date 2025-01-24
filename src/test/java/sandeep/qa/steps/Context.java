package sandeep.qa.steps;

import sandeep.qa.utils.EndpointsApi;
import sandeep.qa.utils.Employee;
import sandeep.qa.utils.LaterExecution;

public class Context {
    public String cookieName = "_CafeTownsend-Angular-Rails_session";
    public String cookieValue;
    public String csrfToken;

    public String employeeId;
    public Employee employee;

    public EndpointsApi endpointsApi = new EndpointsApi(this);
    public LaterExecution laterExecution = new LaterExecution();
}
