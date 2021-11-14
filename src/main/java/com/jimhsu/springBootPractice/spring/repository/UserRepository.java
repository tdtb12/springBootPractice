package com.jimhsu.springBootPractice.spring.repository;

import com.jimhsu.springBootPractice.spring.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {

    UserDTO findByUserName(String userName);

}
