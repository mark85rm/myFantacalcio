package it.myfantacalcio.common;

public class MyException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7003000131093963328L;
	
	private String messaggio;
	private String azioneEseguita;
	 
 
	public String getMessaggio() {
		return messaggio;
	}


	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}




	public String getAzioneEseguita() {
		return azioneEseguita;
	}


	public void setAzioneEseguita(String azioneEseguita) {
		this.azioneEseguita = azioneEseguita;
	}
	
	public MyException(String messaggio, String azioneEseguita) {
		this.messaggio = messaggio;
		this.azioneEseguita = azioneEseguita;
	}


}
