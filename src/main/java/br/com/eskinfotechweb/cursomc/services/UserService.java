package br.com.eskinfotechweb.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.eskinfotechweb.cursomc.security.UserSS;

public class UserService {
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
