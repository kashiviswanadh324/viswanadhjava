package gluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Shared {
	//common objects which are need for all step definition classes
	public RequestSpecification req;
	public Response res;
	public Scenario s;
	@Before 
	public void method1(Scenario scobj)
	{
		s=scobj;
		s.log("Hi,"+s.getName()+"is login to run");
	}
	@After
	public void method2(Scenario scobj)
	{
		s=scobj;
		s.log(s.getName()+"is"+s.getStatus().name());
	}
	
}
