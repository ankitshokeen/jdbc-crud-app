package dao;

import model.Registration;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {
    // Create (Insert)
    public void addRegistration(Registration registration) {
        String sql = "INSERT INTO Registration (Name, Email, DateOfBirth) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, registration.getName());
            pstmt.setString(2, registration.getEmail());
            pstmt.setString(3, registration.getDateOfBirth());
            pstmt.executeUpdate();

            System.out.println("Record added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read (Select All)
    public List<Registration> getAllRegistrations() {
        List<Registration> registrations = new ArrayList<>();
        String sql = "SELECT * FROM Registration";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Registration registration = new Registration();
                registration.setId(rs.getInt("ID"));
                registration.setName(rs.getString("Name"));
                registration.setEmail(rs.getString("Email"));
                registration.setDateOfBirth(rs.getString("DateOfBirth"));
                registrations.add(registration);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrations;
    }

    // Update
    public void updateRegistration(int id, String newName) {
        String sql = "UPDATE Registration SET Name = ? WHERE ID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

            System.out.println("Record updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteRegistration(int id) {
        String sql = "DELETE FROM Registration WHERE ID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Record deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
