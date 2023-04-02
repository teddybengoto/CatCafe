package formationsopra.catCafe.response;

public class AuthResponse {
	private boolean success;
	private String token;
	private int id;


	public boolean getSuccess() {
		return this.success;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthResponse(boolean success, String token, int id) {
		this.success = success;
		this.token = token;
		this.id=id;
	}
}
