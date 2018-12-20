package com.codiecon.codiecon.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = DriverDetails.TABLE_NAME)
public class DriverDetails {

  public static final String TABLE_NAME = "driver";
  public static final String COLUMN_ID = "ID";
  public static final String COLUMN_NAME = "name";
  public static final String COLUMN_DL_NUMBER = "dl_number";
  public static final String COLUMN_CONTACT_NUMBER = "contact_number";
  public static final String COLUMN_IS_APPROVED = "is_approved";
  public static final String COLUMN_DL_TYPE = "dl_type";

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Column(name = DriverDetails.COLUMN_ID, nullable = false)
  private String id;
  @Column(name = DriverDetails.COLUMN_NAME, nullable = false)
  private String name;

  @Column(name = DriverDetails.COLUMN_DL_NUMBER, nullable = false)
  private String dlNumber;

  @Column(name = DriverDetails.COLUMN_DL_TYPE, nullable = false)
  private String dlType;

  @Column(name = DriverDetails.COLUMN_CONTACT_NUMBER, nullable = false)
  private String contactNumber;

  @Column(name = DriverDetails.COLUMN_IS_APPROVED, nullable = false)
  private boolean approved;

  private  boolean markForDelete;

  public DriverDetails(String id, String name, String dlNumber, String contactNumber, boolean approved) {
    this.id = id;
    this.name = name;
    this.dlNumber = dlNumber;
    this.contactNumber = contactNumber;
    this.approved = approved;
  }

}
