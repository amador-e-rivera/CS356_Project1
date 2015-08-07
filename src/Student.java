import java.util.Random;


public class Student implements IUser {

    private String id;
    private UserType userType;
    
    public Student() {
	generateID();
	setUserType(UserType.Student); //Student is default user type.
    }
    
    
    @Override
    public void setUserType(UserType userType) {
	this.userType = userType;
    }

    @Override
    public UserType getUserType() {
	return userType;
    }
    
    @Override
    public void generateID() {
	Random rand = new Random();	
	id = String.valueOf(rand.nextInt());
    }

    @Override
    public String getID() {
	return id;
    }
}
