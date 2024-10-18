package med.voll.api;
import org.flywaydb.core.Flyway;

public class FlywayRepair {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/vollmed_api", "root", "1234")
                .load();
        flyway.repair();
    }
}