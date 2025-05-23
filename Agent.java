public class Agent implements Comparable<Agent> {
	private String username;
	private String fullName;
	private String email;
	private String phone;
	private String password;
	private String licenseNumber;
	private String agencyName;
	private String areasServed;
	private String bio;
	private double rating;  // Rating field for sorting

	// BST Node
	private static class Node {
		Agent agent;
		Node left;
		Node right;

		Node(Agent agent) {
			this.agent = agent;
			left = right = null;
		}
	}

	// Root
	private static Node root;

	// Constructor with rating
	public Agent(String username, String fullName, String email, double rating) {
		this.username = username;
		this.fullName = fullName;
		this.email = email;
		this.rating = rating;
	}

	public Agent() {
	}

	// BST Operations
	public static void insert(Agent agent) {
		root = insertRec(root, agent);
	}

	private static Node insertRec(Node root, Agent agent) {
		if (root == null) {
			return new Node(agent);
		}

		if (agent.compareTo(root.agent) < 0) {
			root.left = insertRec(root.left, agent);
		} else if (agent.compareTo(root.agent) > 0) {
			root.right = insertRec(root.right, agent);
		}

		return root;
	}

	public static Agent search(String username) {
		return searchRec(root, username);
	}

	private static Agent searchRec(Node root, String username) {
		if (root == null || root.agent.getUsername().equals(username)) {
			return (root != null) ? root.agent : null;
		}

		if (username.compareTo(root.agent.getUsername()) < 0) {
			return searchRec(root.left, username);
		}

		return searchRec(root.right, username);
	}

	public static void inorderTraversal() {
		inorderRec(root);
	}

	private static void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println("Agent: " + root.agent.getUsername() + " - " + root.agent.getFullName());
			inorderRec(root.right);
		}
	}

	@Override
	public int compareTo(Agent other) {
		return this.username.compareTo(other.username);
	}

	// Getter and setter for rating
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	// Selection Sort implementation
	public static Agent[] selectionSortByRating(Agent[] agents) {
		int n = agents.length;

		for (int i = 0; i < n - 1; i++) {
			int maxIndex = i;

			// Find the agent with maximum rating in unsorted part
			for (int j = i + 1; j < n; j++) {
				if (agents[j].getRating() > agents[maxIndex].getRating()) {
					maxIndex = j;
				}
			}

			// Swap the found maximum element with the first element of unsorted part
			if (maxIndex != i) {
				Agent temp = agents[i];
				agents[i] = agents[maxIndex];
				agents[maxIndex] = temp;
			}
		}

		return agents;
	}

	// Utility method to convert BST to Array for sorting
	public static Agent[] getBSTAsArray() {
		if (root == null) return new Agent[0];

		java.util.List<Agent> agentList = new java.util.ArrayList<>();
		collectAgents(root, agentList);

		return agentList.toArray(new Agent[0]);
	}

	//method to collect agents from BST
	private static void collectAgents(Node node, java.util.List<Agent> agentList) {
		if (node != null) {
			collectAgents(node.left, agentList);
			agentList.add(node.agent);
			collectAgents(node.right, agentList);
		}
	}

	// Utility method to print sorted agents
	public static void printSortedAgentsByRating() {
		Agent[] agents = getBSTAsArray();
		agents = selectionSortByRating(agents);

		System.out.println("\nAgents Sorted by Rating (Highest to Lowest):");
		for (Agent agent : agents) {
			System.out.printf("Agent: %s - %s (Rating: %.1f)%n",
					agent.getUsername(),
					agent.getFullName(),
					agent.getRating());
		}
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getAreasServed() {
		return areasServed;
	}
	public void setAreasServed(String areasServed) {
		this.areasServed = areasServed;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}


}