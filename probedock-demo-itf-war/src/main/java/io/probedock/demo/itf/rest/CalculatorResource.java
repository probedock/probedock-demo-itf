package io.probedock.demo.itf.rest;

import io.probedock.demo.itf.service.CalculatorService;
import io.probedock.demo.itf.to.ErrorTO;
import io.probedock.demo.itf.to.OperationTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST resource for {@link io.probedock.demo.itf.service.CalculatorService}.
 *
 * @author Laurent Prevost <laurent.prevost@probeodock.io>
 */
@Path("calculator")
@Stateless
public class CalculatorResource {
	@EJB
	protected CalculatorService calculatorService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response requestToken(OperationTO operation){

		switch (operation.getOp()) {
			case "add":
				return Response.ok(calculatorService.add(operation.getLeft(), operation.getRight())).build();
			case "sub":
				return Response.ok(calculatorService.sub(operation.getLeft(), operation.getRight())).build();
			case "mul":
				return Response.ok(calculatorService.mul(operation.getLeft(), operation.getRight())).build();
			case "div":
				try {
					return Response.ok(calculatorService.div(operation.getLeft(), operation.getRight())).build();
				}
				catch (IllegalArgumentException iae) {
					return Response.status(422).entity(new ErrorTO(iae.getMessage())).build();
				}
			default:
				return Response.status(404).entity(new ErrorTO("Operation not found")).build();
		}
	}
}
