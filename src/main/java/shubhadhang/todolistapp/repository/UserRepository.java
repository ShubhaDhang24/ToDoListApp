package shubhadhang.todolistapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shubhadhang.todolistapp.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,String> {


    Boolean existsByEmail(String email);


    @Modifying
    @Query("UPDATE  User u set u.expired=:status where u.email=:email")
    void updateExpiredByEmail(@Param(("email"))String email,  @Param("status")boolean status);

   @Modifying
   @Query("UPDATE  User u set u.password=:password where u.email=:email")
    void updatePasswordByEmail(@Param("password")String newPassword,@Param("email")String email);



}
