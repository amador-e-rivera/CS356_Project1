/**
 * 
 * @author Amador
 *
 * IUser interface created in case a different type of user needs to be added.
 * 
 */

public interface IUser {
    public static enum UserType {
	Student, Teacher
    }
    public void generateID();
    public String getID();
    public void setUserType(UserType userType);
    public UserType getUserType();
}
