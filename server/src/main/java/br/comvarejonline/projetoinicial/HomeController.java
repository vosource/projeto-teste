package br.comvarejonline.projetoinicial;

import java.time.ZonedDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping(path = "/ping")
	public String ping(HttpServletRequest request) {

		return ZonedDateTime.now().toString();
	}
}
