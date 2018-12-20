package com.codiecon.codiecon.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Table(name = LoginDetails.TABLE_NAME)
public class LoginDetails {

  public static final String TABLE_NAME = "login";
  private static final String COLUMN_ID = "ID";
  private static final String COLUMN_USERNAME = "USER_NAME";
  private static final String COLUMN_PASSWORD = "PASSWORD";
  private static final String COLUMN_ROLE = "USER_ROLE";


  public enum UserRole {
    DRIVER, OWNER, ADMIN
  }


  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Column(name = LoginDetails.COLUMN_ID, nullable = false)
  private String id;

  private String name;

  @Column(name = LoginDetails.COLUMN_PASSWORD, nullable = false)
  private String password;

  @Column(unique = true)
  private String email;

  @Column(name = LoginDetails.COLUMN_ROLE, nullable = false)
  @Enumerated(value = EnumType.STRING)
  private UserRole role;
  private boolean markForDelete;

  private Integer otp;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("LoginDetails{");
    sb.append("id='").append(id).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", role=").append(role);
    sb.append('}');
    return sb.toString();
  }
}
