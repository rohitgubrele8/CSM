package com.codiecon.codiecon.models.entity;

import com.codiecon.codiecon.models.enums.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = OwnerDetails.OWNER_TABLE)
public class OwnerDetails {

  private static final long serialVersionUID = 1L;
  public static final String OWNER_TABLE = "ownerDetails";
  private static final String OWNER = "owner";

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(updatable = false, nullable = false, unique = true)
  private String email;

  @Column(nullable = false, unique = true)
  private String contactNumber;

  @Column(nullable = false)
  private String ownerAddress;

  @Column(nullable = false)
  private String zipCode;

  @Enumerated(value = EnumType.STRING)
  @Column(nullable = false)
  private ApplicationStatus status;

  @OneToOne(mappedBy = OWNER)
  private PaymentDetails paymentDetails;

  @OneToMany(mappedBy = OWNER)
  private VehicleDetails vehicleDetails;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    OwnerDetails that = (OwnerDetails) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects
        .equals(email, that.email) && Objects.equals(contactNumber, that.contactNumber) && Objects
        .equals(ownerAddress, that.ownerAddress) && Objects.equals(zipCode, that.zipCode)
        && status == that.status && Objects.equals(paymentDetails, that.paymentDetails) && Objects
        .equals(vehicleDetails, that.vehicleDetails);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(id, name, email, contactNumber, ownerAddress, zipCode, status, paymentDetails,
            vehicleDetails);
  }
}

