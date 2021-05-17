package beans;

public class BeansCursoJsp {

	private String login;

	private String senha;
	
	/* metodo para validar login e senha */
	public boolean validarLoginSenha(String login, String senha) {
		if (login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
			return true;
		} 
		  return false;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int calculaNumero(int numero) {

		return numero * 100;
	}
}
