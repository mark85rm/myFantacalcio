package it.myfantacalcio.service;

public interface MailService {
	
	public void sendMail(String from, String to, String subject, String msg);

}
