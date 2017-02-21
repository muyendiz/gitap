package Users;


public abstract class User {

	private String name;
	private String surname;
	private String department;
	private String username;
	private String password;
	
	public User(String name, String surname,String department, String username, String password ){
		this.name = name;
		this.surname = surname;
		this.department = department;
		this.username = username;
		this.password = password;
	}
	
	public String changeUsername(String username){
		this.username = username;
		return username;
	}
	
	public String changePassword(String password){
		this.password = password;
		return password;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSurname(){
		return surname;
	}
	
	
	
	public String getDepartment(){
		return department;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
}
		