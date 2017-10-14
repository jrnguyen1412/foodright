package vn.neways.foodright.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.neways.foodright.dao.UserDAO;
import vn.neways.foodright.dao.UserRolesDAO;
import vn.neways.foodright.entity.UserRoles;
import vn.neways.foodright.entity.Users;

@Service
public class DBAuthenticationService implements UserDetailsService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserRolesDAO userRolesDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		// Get users
		Users users = userDAO.findOne(username);
 
        if (users == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
         
        // Get user roles
        List<UserRoles> userRoles = userRolesDAO.findByUsername(username);
        
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(userRoles!= null)  {
            for(UserRoles userRole: userRoles)  {
                // Grant role: ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userRole.getUserRole());
                grantList.add(authority);
            }
        }
        
        UserDetails userDetails = (UserDetails) new User(users.getUsername(), //
                users.getPassword(),grantList);
 
        return userDetails;
	}

	
	
}
