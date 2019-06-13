package br.com.eskinfotechweb.cursomc.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eskinfotechweb.cursomc.security.JWTUtil;
import br.com.eskinfotechweb.cursomc.security.UserSS;
import br.com.eskinfotechweb.cursomc.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

 	@Autowired
	private JWTUtil jwtUtil;

 	@PostMapping("/refresh_token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}
}
