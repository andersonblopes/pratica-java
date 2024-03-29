package com.lopes.envioemail.commonsmail;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class TesteCommonsMailAnexo {
	private static final String EMAIL = "livrojava@localhost";

	public static void main(String[] args) throws EmailException {
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("localhost");
		email.setSmtpPort(25);
		email.setAuthentication(EMAIL, "123");
		email.setFrom(EMAIL, "Administrador");
		email.addTo("livrojava@localhost");
		email.setSubject("Teste de e-mail com anexo usando CommonsMail");
		email.setMsg("Corpo da mensagem");

		EmailAttachment anexo = new EmailAttachment();
		anexo.setPath("src/main/resources/temp/texto.txt");
		anexo.setDisposition(EmailAttachment.ATTACHMENT);
		email.attach(anexo);

		email.send();

		System.out.println("E-mail enviado com sucesso");
	}
}
