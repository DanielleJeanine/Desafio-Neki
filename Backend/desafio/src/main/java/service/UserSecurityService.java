package service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import model.UserSecurity;
import model.Users;
import repository.UserRepository;

public class UserSecurityService implements UserDetailsService {
    @Autowired
	private UserRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users usuario;
		try {
			Optional<Users> opUsuario = usuarioRepository.findByLogin(username);
			if (!opUsuario.isPresent())
				throw new UsernameNotFoundException("Usuário não encontrado");
			else {
				usuario = opUsuario.get();
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("database error");
		}
		UserSecurity springUser = buildUserFromUserEntity(usuario);
		return (UserDetails) springUser;

	}

	
	private UserSecurity buildUserFromUserEntity(Users userEntity) {
		String username = userEntity.getLogin().toString();
		String password = userEntity.getSenha();

		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		boolean enable = true;

		String[] userRoles = { "admin" };
		AuthorityUtils.createAuthorityList(userRoles);

		Collection<? extends GrantedAuthority> authorities = (Collection<? extends GrantedAuthority>) AuthorityUtils
				.createAuthorityList(userRoles);

		UserSecurity springUser = new UserSecurity(username, password, enable, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);

		return springUser;

	}
    
}
