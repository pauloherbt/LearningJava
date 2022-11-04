package entities;

import java.util.Date;

public class Client {
	private String name;
	private String email;
	private Date birthday;
	
	public Client(String name, String email, Date birthday) {
		this.name = name;
		this.email = email;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthday() {
		return birthday;
	}
	
	}
