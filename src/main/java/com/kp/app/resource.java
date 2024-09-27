package com.kp.app;

import java.util.List;

import jakarta.validation.constraints.Pattern;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.sql.*;
@Path("aliens")
public class resource {
	repository r=new repository();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<alien> getit() throws SQLException 
	{
		//r=new repository();
		//System.out.println("at get method");
		
		
		return r.getaliens();
		
	}
	
	@Path("alien")
	@POST
	
	@Consumes(MediaType.APPLICATION_XML)
	public void createalien(alien i)
	{
		//repository r=new repository();
		//System.out.println("at post method");
		r.createalien(i);
		i.toString();
	}
	
	@Path("alien/100")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void updatealien(alien i)
	{
		r.update(i);
	}
	
	@Path("alien/101/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_XML)
	public void deletealien(@PathParam("id") int id)
	{
		r.delete(id);
	}
	
	
	
	
	
	
}
