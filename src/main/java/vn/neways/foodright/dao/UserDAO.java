package vn.neways.foodright.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.neways.foodright.entity.Users;

@Repository
public interface UserDAO extends JpaRepository<Users, String>{

}
