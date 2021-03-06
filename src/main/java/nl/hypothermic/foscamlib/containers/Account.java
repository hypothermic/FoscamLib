package nl.hypothermic.foscamlib.containers;

/******************************\
 * > Account.java			< *
 * FoscamAPI by hypothermic	  *
 * www.github.com/hypothermic *
\******************************/

public class Account {
	
	/** Username of the account */
	public String username;
	/** Password of the account */
	public String password;
	/** Privilege level of the account */
	public Privilege privilege;
	
	/**
	 * Create a new Account object which stores the username, password and privilege level. <br><br>
	 * <b>NOTE</b>: this is different from a Credentials object, because Credentials is final and Account is modifiable.
	 * @param username = User name
	 * @param password = Password of user
	 * @param privilege = Privilege level of user
	 */
	public Account(String username, String password, Privilege privilege) {
		this.username = username;
		this.password = password;
		this.privilege = privilege;
	}
	
	/**
	 * Enum of Account Privilege levels with their respective integers attached.
	 */
	public static enum Privilege {
		VISITOR(0),
		OPERATOR(1),
		ADMINISTRATOR(2);
		
		private final int value;
		
		private Privilege(final int value) {
			this.value = value;
		}
		
		/**
		 * Returns int value of Privilege instance
		 * @return Value of Privilege instance
		 */
		public int getValue() {
			return this.value;
		}
		
		public static Privilege match(int x) {
	        switch(x) {
	        case 0:
	            return VISITOR;
	        case 1:
	            return OPERATOR;
	        case 2:
	            return ADMINISTRATOR;
	        }
	        return null;
	    }

		public static Privilege match(String value) {
			if (value.contains("0")) return VISITOR;
			if (value.contains("1")) return OPERATOR;
			if (value.contains("2")) return ADMINISTRATOR;
			return null;
		}
	}

	@Override public String toString() {
		return "Account [username=" + this.username + ", password=" + this.password + ", privilege=" + this.privilege + "]";
	}
}
