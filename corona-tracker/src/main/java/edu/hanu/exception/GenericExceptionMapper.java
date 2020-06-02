package edu.hanu.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import edu.hanu.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable e) {
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 500, "http://google.com/");
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR)
									.entity(errorMessage)
									.build();
		return response;
	}
}
