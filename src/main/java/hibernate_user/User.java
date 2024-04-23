package hibernate_user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user_info")
public class User {
    @Id
    @Column(name = "user_id")
	private int id;
	private String name;
	@Column(unique = true)
	private long phone;
	@Column(unique = true)
	private String email;
	private String password;
	private String facebook;
	private String instagram;
	private String X;
	private String snapchat; 
}
