package com.lopes.envioemail.javamail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Autenticacao extends Authenticator {
	private String usuario;
	private String senha;

	public Autenticacao(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.usuario, this.senha);
	}
}
