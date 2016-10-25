package mapreduce;

public class Client {
  private String uid;
  private String login;
  private String email;
  private String numero;
  private Type type;
  private long montant;

  public Client(String uid, String login, String email, String numero, Type type, long montant) {
		super();
		this.uid = uid;
		this.login = login;
		this.email = email;
		this.numero = numero;
		this.type = type;
		this.montant = montant;
	}
	public String getUid() {
		return uid;
	}
	public String getLogin() {
		return login;
	}
	public String getEmail() {
		return email;
	}
	public String getNumero() {
		return numero;
	}
	public Type getType() {
		return type;
	}
	public long getMontant() {
		return montant;
	}
}
