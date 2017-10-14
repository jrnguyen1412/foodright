package vn.neways.foodright.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.neways.foodright.entity.UserRoles;

@Repository
public interface UserRolesDAO extends JpaRepository<UserRoles, String> {
	
	List<UserRoles> findByUsername(String username);

}
