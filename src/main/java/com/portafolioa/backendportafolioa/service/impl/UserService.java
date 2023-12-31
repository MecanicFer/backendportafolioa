/**/
package com.portafolioa.backendportafolioa.service.impl;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.portafolioa.backendportafolioa.entity.UserRole;
import com.portafolioa.backendportafolioa.repository.UserRepository;



// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */


@Service("userService")
public class UserService implements UserDetailsService{
	
	/** The user repository. */

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.portafolioa.backendportafolioa.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAutorities(user.getUserRole());
		return buildUser(user, authorities);
	}
	
	/**
	 * Builds the user.
	 *
	 * @param user the user
	 * @param authorities the authorities
	 * @return the user
	 */
	private User buildUser(com.portafolioa.backendportafolioa.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
	
	/**
	 * Builds the autorities.
	 *
	 * @param userRoles the user roles
	 * @return the list
	 */
	

	private List<GrantedAuthority> buildAutorities (Set<UserRole> userRoles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		for (UserRole userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}
	
}

