import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class SimulationDriver {
    
    public static void main(String[] args) {
	Map<String, Student> students = new HashMap<String, Student>();
	Random rand = new Random();
	
	for(int i = rand.nextInt(30); i >= 0; i--) {
	    generateUser(students);
	}
	
	System.out.println("Hello");
    }
    
    public static void generateUser(Map<String, Student> students) {
	Student student = new Student();
	
	while (students.containsKey(student.getID())) {
	    student.generateID();
	}
	
	students.put(student.getID(), student);
    }

}
