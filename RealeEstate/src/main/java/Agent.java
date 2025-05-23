public class Agent {
	private String username;
	private String fullName;
	private String email;
	private String phone;
	private String password;
	private String licenseNumber;
	private String agencyName;
	private String areasServed;
	private String bio;

	// ✅ Full Constructor
	public Agent(String username, String fullName, String email, String phone, String password,
				 String licenseNumber, String agencyName, String areasServed, String bio) {
		this.username = username;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.licenseNumber = licenseNumber;
		this.agencyName = agencyName;
		this.areasServed = areasServed;
		this.bio = bio;
	}

	// ✅ Default Constructor
	public Agent() {}

	// ✅ Getters & Setters
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getFullName() { return fullName; }
	public void setFullName(String fullName) { this.fullName = fullName; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String getLicenseNumber() { return licenseNumber; }
	public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

	public String getAgencyName() { return agencyName; }
	public void setAgencyName(String agencyName) { this.agencyName = agencyName; }

	public String getAreasServed() { return areasServed; }
	public void setAreasServed(String areasServed) { this.areasServed = areasServed; }

	public String getBio() { return bio; }
	public void setBio(String bio) { this.bio = bio; }

	// ✅ Method to Format for Saving to File
	public String toFileFormat() {
		return "Username: " + username + "\n" +
				"FullName: " + fullName + "\n" +
				"Email: " + email + "\n" +
				"Phone: " + phone + "\n" +
				"Password: " + password + "\n" +
				"Action: Agent\n" +
				"licenseNumber: " + licenseNumber + "\n" +
				"agencyName: " + agencyName + "\n" +
				"areasServed: " + areasServed + "\n" +
				"bio: " + bio + "\n";
	}
}
