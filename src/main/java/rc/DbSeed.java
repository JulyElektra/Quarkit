package rc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeed implements CommandLineRunner {

    UserRepository userRepository;

    public DbSeed(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Yuliya");
        User user2 = new User("Denis");

        userRepository.deleteAll();

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
