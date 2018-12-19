package com.codiecon.codiecon.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class VehicleDetails {

  private static final String OWNER_DETAILS = "owner_details";
  private static final String RENTAL_PRICE_DETAILS = "rental_price_details";
  private static final String VEHICLE_AVAILABLE_DATES = "vehicle_available_dates";
  private static final String ID = "id";

  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Id
  private String id;

  @Column(nullable = false, unique = true)
  private String vehicleNumber;

  private String vehicleType;

  private String vehicleModel;

  @ManyToOne
  @JoinColumn(name = OWNER_DETAILS, referencedColumnName = ID, nullable = false)
  private OwnerDetails ownerDetails;

  @ManyToOne
  @JoinColumn(name = RENTAL_PRICE_DETAILS, referencedColumnName = ID, nullable = false)
  private RentalPriceDetails rentalPriceDetails;

  private boolean isAvailable;

  private String insuranceNumber;

  @OneToMany
  @JoinColumn(name = VEHICLE_AVAILABLE_DATES, referencedColumnName = ID, nullable = false)
  private VehicleAvailableDates vehicleAvailableDates;

}
