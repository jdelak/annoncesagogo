package adrar.julien.annonces.entities;


import javax.persistence.*;

import java.util.Collection;
import java.util.Set;

	@Entity
	@Table(name = "users")
	public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    @Column(name="user_id")
	    private Long id;
	    @Column(name="user_username")
	    private String username;
	    @Column(name="user_password")
	    private String password;

	    @Transient
	    private String passwordConfirm;

	    @ManyToMany
	    @JoinTable(name="users_roles",
        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="user_id")},
        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="role_id")}
    )
	    Collection<Role> roles;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getPasswordConfirm() {
	        return passwordConfirm;
	    }

	    public void setPasswordConfirm(String passwordConfirm) {
	        this.passwordConfirm = passwordConfirm;
	    }

		public Collection<Role> getRoles() {
			return roles;
		}

		public void setRoles(Collection<Role> roles) {
			this.roles = roles;
		}

	   
	    
}
