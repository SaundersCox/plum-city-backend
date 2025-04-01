package com.plumcity.plum_city.entity.denodo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity representing a freight bill header record.
 */
@Entity
@Table(name = "bv_fbfiles_frp001")
@Getter
@Setter
@ToString
public class FreightBillHeader {

  @Column(name = "FHOT")
  private String originTerminalId;

  @Id
  @Column(name = "FHPRO")
  private String proNumber;

  @Column(name = "FHDT")
  private String destinationTerminalId;

  @Column(name = "FHPROD")
  private BigDecimal totalFreightBillCharges;

  @Column(name = "FHSNM")
  private String shipperName;

  @Column(name = "FHCNM")
  private String consigneeName;

  @Column(name = "FHSWGT")
  private Integer shippingWeight;

  @Column(name = "FHPDA8")
  private LocalDate fbEntryDate8;

  @Column(name = "FHA3")
  private String quoteNumber;

  @Column(name = "FHBNM")
  private String thirdPartyName;

  @Column(name = "FHSST")
  private String shipperState;

  @Column(name = "FHCST")
  private String consigneeState;
}