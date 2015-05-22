package me.demo.qa.startup.resource.config;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import me.demo.qa.startup.resource.entity.ResponseMessage;

/**
 * request过滤器
 */
@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {
  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    ResponseMessage.CurrentUriInfo = requestContext.getUriInfo();

    // final SecurityContext securityContext = requestContext.getSecurityContext();
    // if (securityContext == null || !securityContext.isUserInRole("privileged"))
    // {
    //
    // requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("User cannot access the resource.").build());
    // }
  }
}
