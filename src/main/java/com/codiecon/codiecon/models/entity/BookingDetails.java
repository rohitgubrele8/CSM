package com.codiecon.codiecon.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = BookingDetails.TABLE_NAME, uniqueConstraints = @UniqueConstraint(columnNames = {
    BookingDetails.COLUMN_DATE ,BookingDetails.COLUMN_VEHICLE_ID}))
public class BookingDetails {

  public static final String TABLE_NAME = "booking";
  public static final String COLUMN_ID = "ID";
  public static final String COLUMN_DRIVER_ID = "driver_id";
  public static final String COLUMN_VEHICLE_ID = "vehicle_id";
  public static final String COLUMN_DATE = "booking_date";

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Column(name = BookingDetails.COLUMN_ID, nullable = false)
  private String id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = BookingDetails.COLUMN_DRIVER_ID)
  private DriverDetails driverDetails;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = BookingDetails.COLUMN_VEHICLE_ID)
  private VehicleDetails vehicleDetails;

  @Column(name = BookingDetails.COLUMN_DATE, nullable = false)
  @DateTimeFormat(pattern = "dd.MM.yyyy")
  private Date date;

  public BookingDetails(String id, DriverDetails driverDetails, VehicleDetails vehicleDetails, Date date) {
    this.id = id;
    this.driverDetails = driverDetails;
    this.vehicleDetails = vehicleDetails;
    this.date = date;
  }

  public BookingDetails() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DriverDetails getDriverDetails() {
    return driverDetails;
  }

  public void setDriverDetails(DriverDetails driverDetails) {
    this.driverDetails = driverDetails;
  }

  public VehicleDetails getVehicleDetails() {
    return vehicleDetails;
  }

  public void setVehicleDetails(VehicleDetails vehicleDetails) {
    this.vehicleDetails = vehicleDetails;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("BookingDetails{");
    sb.append("id='").append(id).append('\'');
    sb.append(", driverDetails=").append(driverDetails);
    sb.append(", vehicleDetails=").append(vehicleDetails);
    sb.append(", date=").append(date);
    sb.append('}');
    return sb.toString();
  }
}
