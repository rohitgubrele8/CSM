package com.codiecon.codiecon.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = LoginDetails.TABLE_NAME)
public class LoginDetails {

  public static final String TABLE_NAME = "login";
  public static final String COLUMN_ID = "ID";
  public static final String COLUMN_USERNAME = "USER_NAME";
  public static final String COLUMN_PASSWORD = "PASSWORD";
  public static final String COLUMN_ROLE = "USER_ROLE";

  public enum UserRole {
    DRIVER, OWNER, ADMIN
  }

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Column(name = LoginDetails.COLUMN_ID, nullable = false)
  private String id;

  @Column(name = LoginDetails.COLUMN_PASSWORD, nullable = false)
  private String password;

  @Column(name = LoginDetails.COLUMN_USERNAME, nullable = false)
  private String userName;

  @Column(name = LoginDetails.COLUMN_ROLE, nullable = false)
  @Enumerated(value = EnumType.STRING)
  private UserRole role;

  public LoginDetails(String id, String password, String userName, UserRole role) {
    this.id = id;
    this.password = password;
    this.userName = userName;
    this.role = role;
  }

  public LoginDetails() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("LoginDetails{");
    sb.append("id='").append(id).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", userName='").append(userName).append('\'');
    sb.append(", role=").append(role);
    sb.append('}');
    return sb.toString();
  }
}
