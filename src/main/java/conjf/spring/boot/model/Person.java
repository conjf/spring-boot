package conjf.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "person")
@ApiModel(description="Table that holds person information. ")
public class Person {

	@ApiModelProperty(notes = "The database generated person ID")
	private long id;
	@ApiModelProperty(notes = "first name")
	private String firstName;
	@ApiModelProperty(notes = "last name")
	private String lastName;
	@ApiModelProperty(notes = "email address")
	private String emailAddress;

	public Person() { }

	public Person(String firstName, String lastName, String emailAddress) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.emailAddress = emailAddress; 
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
	    return id; 
	}

	public void setId(long id) {
	    this.id = id; 
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
	    return firstName; 
    }

	public void setFirstName(String firstName) {
	    this.firstName = firstName; 
    }

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
	    return lastName; 
    }

	public void setLastName(String lastName) {
	    this.lastName = lastName; }

	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
	    return emailAddress; 
    }

	public void setEmailId(String emailAddress) {
	    this.emailAddress = emailAddress; 
    }

	@Override
	public String toString() {
	    return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + "]"; 
    }
	
}
