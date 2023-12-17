package com.projecto.Horadada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class HoradadaApplicationTests {

  
    
    @Autowired
    private BCryptPasswordEncoder codificador;
    
   

}
