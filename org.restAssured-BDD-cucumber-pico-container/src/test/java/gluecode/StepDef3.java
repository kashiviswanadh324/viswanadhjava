package gluecode;

import java.util.List;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pojos.Mypojo;

public class StepDef3 {
	
	Shared sh;
	public StepDef3(Shared x)
	{
		
		this.sh=x; 
		
	}
	@Then("validate that restful service with content type as {string}") 
	public void method1(String ct,DataTable dt)
	{
		List<Map<String,String>> l = dt.asMaps();
		SoftAssert s = new SoftAssert();
		//loop on list of maps 
		for(int i=0;i<l.size();i++)
		{
			//put data to be posted in JSON format as pairs of request body parameters
			
			Mypojo obj = new Mypojo();
			if(l.get(i).get("uid")==null) {
				obj.setUserId(0);
			}else {
				obj.setUserId(Integer.parseInt(l.get(i).get("uid")));
			}
			obj.SetTitle(l.get(i).get("title"));
			obj.setBody(l.get(i).get("body"));
			sh.req.header("Content-Type",ct);
			sh.req.body(obj);
			// submit request through POST Method
			sh.res=sh.req.post();
			// validate response
			int esc = Integer.parseInt(l.get(i).get("sc"));
			String criteria = l.get(i).get("criteria");
			String ect = ct;
			if(criteria.equals("unique")&& sh.res.getStatusCode()==esc && sh.res.getContentType().contains(ect))
			{
				sh.s.log("Test passed for criteria"+criteria);
				s.assertTrue(true);
				
			}else if(criteria.equals("duplicate")&& sh.res.getStatusCode()==esc && sh.res.getContentType().contains(ect)) {
				
				sh.s.log("Test passed for criteria"+criteria);
				s.assertTrue(true);
			}else if(criteria.equals("wrong")&& sh.res.getStatusCode()==esc && sh.res.getContentType().contains(ect)) {
			
			sh.s.log("Test passed for criteria"+criteria);
			s.assertTrue(true);
			}else {
				sh.s.log("Test failed for criteria "+criteria+" because expected is "+"but actual is "+sh.res.getStatusCode());
				s.assertTrue(false);
			}
		} //loop closing
			s.assertAll();
		
	}

}
