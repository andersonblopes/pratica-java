package com.lopes.envioemail.commonsmail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class TesteCommonsMail {

	private static final String CONTA_EMAIL = "anderson.lopes.2010@gmail.com";

	public static void main(String[] args) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("localhost");
		email.setSmtpPort(25);
		email.setAuthentication(CONTA_EMAIL, "123");
		email.setFrom(CONTA_EMAIL, "Administrador");
		email.addTo("livrojava@localhost");
		email.setSubject("Teste de e-mail usando CommonsMail");
		email.setMsg("Corpo da mensagem");
		email.send();
		System.out.println("E-mail enviado com sucesso");
	}

}
