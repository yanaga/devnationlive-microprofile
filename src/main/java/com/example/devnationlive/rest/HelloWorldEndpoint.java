package com.example.devnationlive.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

	@Inject
	@ConfigProperty(name = "greeting")
	private Optional<String> greeting;

	@Fallback(fallbackMethod = "cachedNames")
	@GET
	@Path("/person")
	@Produces("application/json")
	public List<String> getPeople() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8081").path("person");
		List<Person> people = target.request().get(new GenericType<List<Person>>() {
		});
		return people.stream().map(Person::getName).collect(Collectors.toList());
	}

	public List<String> cachedNames() {
		return Arrays.asList("Edson", "Burr");
	}

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok(greeting.orElse("Aloha")).build();
	}

}