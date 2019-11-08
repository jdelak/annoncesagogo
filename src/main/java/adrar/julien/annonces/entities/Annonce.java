package adrar.julien.annonces.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="annonces")
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="annonce_id")
	private Long id;
	@Column(name="annonce_title")
	private String title;
	@Column(name="annonce_description")
	private String description;
	@Column(name="annonce_date_parution")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateParution;
	@ManyToOne
	@JoinColumn(name ="category_annonce")
	private Category categoryAnnonce;
	@Column(name="annonce_active")
	private boolean active;
	@ManyToOne
	@JoinColumn(name ="user_annonce")
	private User userAnnonce;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateParution() {
		return dateParution;
	}
	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}
	public Category getCategoryAnnonce() {
		return categoryAnnonce;
	}
	public void setCategoryAnnonce(Category categoryAnnonce) {
		this.categoryAnnonce = categoryAnnonce;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public User getUserAnnonce() {
		return userAnnonce;
	}
	public void setUserAnnonce(User userAnnonce) {
		this.userAnnonce = userAnnonce;
	}
	
	
	
	
	
	
	
	

}

