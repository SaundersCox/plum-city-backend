package com.plumcity.plum_city.service;

import com.plumcity.plum_city.entity.denodo.FreightBillHeader;
import com.plumcity.plum_city.repository.FreightBillHeaderRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FreightBillService {

  private final FreightBillHeaderRepository freightBillHeaderRepository;

//  /**
//   * Retrieve freight bills with pagination and sorting
//   *
//   * @param page          Page number (zero-based)
//   * @param size          Page size
//   * @param sortField     Field to sort by
//   * @param sortDirection Sort direction (ASC or DESC)
//   * @return Paginated list of freight bills
//   */
//  public Page<FreightBillHeader> getFreightBillsSorted(
//      int page, int size, String sortField, String sortDirection) {
//    Sort.Direction direction = "ASC".equalsIgnoreCase(sortDirection) ?
//        Sort.Direction.ASC : Sort.Direction.DESC;
//    String validSortField = validateSortField(sortField);
//    return freightBillHeaderRepository.findAll(
//        PageRequest.of(page, size, Sort.by(direction, validSortField))
//    );
//  }
//
//  /**
//   * Validates and maps the sort field name to ensure it exists in the entity
//   *
//   * @param sortField The requested sort field
//   * @return A valid sort field name
//   */
//  private String validateSortField(String sortField) {
//    // List of valid sort fields
//    Set<String> validFields = Set.of(
//        "proNumber", "originTerminalId", "destinationTerminalId",
//        "totalFreightBillCharges", "shipperName", "consigneeName",
//        "shippingWeight", "fbEntryDate8", "quoteNumber",
//        "thirdPartyName", "shipperState", "consigneeState"
//    );
//
//    return validFields.contains(sortField) ? sortField : "proNumber";
//  }
}
