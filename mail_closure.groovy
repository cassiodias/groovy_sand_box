
class Mailer {

	String to
	String from
	String subject 
	String message

	void to(String mail){
		this.to = "\nto ${mail}"
	}

	void from(String from){
		this.from = "\nsending email from ${from}"
	}

	void subject(String subject){
		this.subject = "\nwith subject: ${subject}"
	}

	void message(String message){
		this.message = "\nmessage: ${message}"
	}

	void send(Closure configuration){
		this.with configuration
		print "${from} ${to} ${subject} ${message} "
	}

}

m = new Mailer()
m.send {
	to 'CassioDias@'
	from 'GroovyCode@'
	subject 'Ola!'
	message 'Esta eh uma mensagem!'
}
	