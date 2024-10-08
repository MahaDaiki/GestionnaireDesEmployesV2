import configs.JpaUtil;

import javax.persistence.EntityManager;

public class maintest {
    public static void main(String[] args) {
        // Create an EntityManager instance
        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Test connection by checking if EntityManager is open
            if (em.isOpen()) {
                System.out.println("Connection to the database established successfully!");
            } else {
                System.out.println("Failed to establish connection to the database.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exception that occurs
        } finally {
            // Close the EntityManager
            em.close();
            // Close the EntityManagerFactory
            JpaUtil.close(); // Close resources
        }
    }
}
