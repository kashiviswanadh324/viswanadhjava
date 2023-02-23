package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mypojo {
	//private properties
	@JsonProperty("userId")
	private int uid;
	@JsonProperty("title")
	private String t;
	@JsonProperty("body")
	private String b;
	@JsonProperty("id")
	private int i;
	//public setters for fields in request pay load
	public void setUserId(int x)
	{
		this.uid=x;
	}
	public void SetTitle(String x)
	{
		this.t=x;
	}
	public void setBody(String x)
	{
		this.b=x;
	}
	// public setters for fields in Response pay load
	public int getUserId()
	{
		return(this.uid);
	}
	public String getTitle()
	{
		return(this.t);
	}
	public String getBody()
	{
		return(this.b);
	}
	public int getId()
	{
		return(this.i);
	}

}
