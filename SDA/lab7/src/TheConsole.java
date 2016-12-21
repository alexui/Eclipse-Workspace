import java.io.Console;
import java.util.Arrays;
import java.io.IOException;

public class TheConsole {//runs only in command line
    
	public static char[] pass = new char[20];
	public static String username="alex";
    public static void main (String args[]) throws IOException {
  
    	pass[0]='a';
    	pass[1]='l';
    	pass[2]='e';
    	pass[3]='x';
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String login = c.readLine("Enter your login: ");
        char [] oldPassword = c.readPassword("Enter your old password: ");

        if (verify(login, oldPassword)) {
            boolean noMatch;
            do {
                char [] newPassword1 = c.readPassword("Enter your new password: ");
                char [] newPassword2 = c.readPassword("Enter new password again: ");
                noMatch = ! Arrays.equals(newPassword1, newPassword2);
                if (noMatch) {
                    c.format("Passwords don't match. Try again.%n");
                } else {
                    change(login, newPassword1);
                    c.format("Password for %s changed.%n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            } while (noMatch);
        }
        else
        	System.err.println("Wrong password or username.");

        Arrays.fill(oldPassword, ' ');
    }
    
    // Dummy change method.
    static boolean verify(String login, char[] password) {
        int index;
        if(!login.equals(username))
        	return false;
        for(index=0;index<password.length;index++)
        {
        	if(password[index]!=pass[index])
        		return false;
        }
        return true;
    }
    // Dummy change method.
    static void change(String login, char[] password) {
    	
       int index;
       for(index=0;index<password.length;index++)
       {
    	   pass[index]=password[index];
       }
    }
}
