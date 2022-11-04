package com.project.GesExpo.security;

import com.project.GesExpo.models.User;
import com.project.GesExpo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.List;

@Service
public class DbInitService implements CommandLineRunner{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;



    public DbInitService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //creation de l'admin
        User admin = new User("admin",
                passwordEncoder.encode("admin123"),"admin12@gmail.com",1,1,"ADMIN","", "I am a administrator");

        List<User> users = List.of(admin);

        //enregistrer l'admin en BD
        if(this.userRepository.count() <= 0) {
            this.userRepository.saveAll(users);
        }
    }
}
