import dao.RegistrationDAO;
import model.Registration;

public class Main {
    public static void main(String[] args) {
        RegistrationDAO dao = new RegistrationDAO();

        // Create
        dao.addRegistration(new Registration(0, "Ankit Shokeen", "ankitshokeen2001@gmail.com", "2001-01-20"));

        // Read
        System.out.println("All Registrations:");
        dao.getAllRegistrations().forEach(reg ->
                System.out.println(reg.getId() + ", " + reg.getName() + ", " + reg.getEmail() + ", " + reg.getDateOfBirth())
        );

        // Update
        dao.updateRegistration(1, "Inderjeet");

        // Delete
        dao.deleteRegistration(1);
    }
}
