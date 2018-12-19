package com.codiecon.codiecon.models.entity;

import com.codiecon.codiecon.models.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class VehicleDetails {

  private static final String OWNER_DETAILS = "owner_details";
  private static final String RENTAL_PRICE_ID = "rental_price_id";
  private static final String VEHICLE_AVAILABLE_DATES_ID = "vehicle_available_dates_id";
  private static final String OWNER_ID = "owner_id";
  private static final String ID = "id";

  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Id
  private String id;

  @Column(nullable = false, unique = true)
  private String vehicleNumber;

  private VehicleType vehicleType;

  private String vehicleModel;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonBackReference
  @JoinColumn(name = OWNER_ID, nullable = false)
  private OwnerDetails ownerDetails;

  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = RENTAL_PRICE_ID, nullable = false)
  private RentalPriceDetails rentalPriceDetails;

  private boolean isAvailable;

  private String insuranceNumber;

  @OneToMany
  @JsonManagedReference
  @JoinColumn(name = VEHICLE_AVAILABLE_DATES_ID, nullable = false)
  private List<VehicleAvailableDates> vehicleAvailableDates;

}
