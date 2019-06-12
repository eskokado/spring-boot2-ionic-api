package br.com.eskinfotechweb.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.eskinfotechweb.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
