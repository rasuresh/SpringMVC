package com.acuvue.pdo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
    
	private Integer userId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dob;
    private Set userLogins = new HashSet();
    private Set userContacts;
    private Set userApplications;
    private Set userRoles;
    private Set userDatas;

    /** full constructor */
    public User(Integer userId, String firstName, String lastName, String gender, Date dob, Set userLogins, Set userContacts, Set userApplications, Set userRoles, Set userDatas) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.userLogins = userLogins;
        this.userContacts = userContacts;
        this.userApplications = userApplications;
        this.userRoles = userRoles;
        this.userDatas = userDatas;
    }

    /** default constructor */
    public User() {
    }

    /** minimal constructor */
    public User(Integer userId, Set userLogins, Set userContacts, Set userApplications, Set userRoles, Set userDatas) {
        this.userId = userId;
        this.userLogins = userLogins;
        this.userContacts = userContacts;
        this.userApplications = userApplications;
        this.userRoles = userRoles;
        this.userDatas = userDatas;
    }
    
    public Integer getAddressKey() {
    	Integer addressKey = null;
    	return addressKey;
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Set getUserLogins() {
        return this.userLogins;
    }

    public void setUserLogins(Set userLogins) {
        this.userLogins = userLogins;
    }

    public Set getUserContacts() {
        return this.userContacts;
    }

    public void setUserContacts(Set userContacts) {
        this.userContacts = userContacts;
    }

    public Set getUserApplications() {
        return this.userApplications;
    }

    public void setUserApplications(Set userApplications) {
        this.userApplications = userApplications;
    }

    public Set getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(Set userRoles) {
        this.userRoles = userRoles;
    }

    public Set getUserDatas() {
        return this.userDatas;
    }

    public void setUserDatas(Set userDatas) {
        this.userDatas = userDatas;
    }
    
}
