package com.codiecon.codiecon.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = DriverDetails.TABLE_NAME)
public class DriverDetails {

  public static final String TABLE_NAME = "driver";
  public static final String COLUMN_ID = "ID";
  public static final String COLUMN_NAME = "name";
  public static final String COLUMN_DL_NUMBER = "dl_number";
  public static final String COLUMN_CONTACT_NUMBER = "contact_number";
  public static final String COLUMN_IS_APPROVED = "is_approved";

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Column(name = DriverDetails.COLUMN_ID, nullable = false)
  private String id;

  @Column(name = DriverDetails.COLUMN_NAME, nullable = false)
  private String name;

  @Column(name = DriverDetails.COLUMN_DL_NUMBER, nullable = false)
  private String dlNumber;

  @Column(name = DriverDetails.COLUMN_CONTACT_NUMBER, nullable = false)
  private String contactNumber;

  @Column(name = DriverDetails.COLUMN_IS_APPROVED, nullable = false)
  private boolean approved;

  public DriverDetails(String id, String name, String dlNumber, String contactNumber, boolean approved) {
    this.id = id;
    this.name = name;
    this.dlNumber = dlNumber;
    this.contactNumber = contactNumber;
    this.approved = approved;
  }

  public DriverDetails() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDlNumber() {
    return dlNumber;
  }

  public void setDlNumber(String dlNumber) {
    this.dlNumber = dlNumber;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public boolean isApproved() {
    return approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("DriverDetails{");
    sb.append("id='").append(id).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", dlNumber='").append(dlNumber).append('\'');
    sb.append(", contactNumber='").append(contactNumber).append('\'');
    sb.append(", approved=").append(approved);
    sb.append('}');
    return sb.toString();
  }
}
