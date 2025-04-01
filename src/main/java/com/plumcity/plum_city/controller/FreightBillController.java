package com.plumcity.plum_city.controller;

import com.plumcity.plum_city.entity.denodo.FreightBillHeader;
import com.plumcity.plum_city.service.FreightBillService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/freight-bills")
@RequiredArgsConstructor
public class FreightBillController {

  private final FreightBillService freightBillService;

//  @GetMapping
//  public ResponseEntity<Page<FreightBillHeader>> getFreightBills(
//      @RequestParam(defaultValue = "0") int page,
//      @RequestParam(defaultValue = "20") int size,
//      @RequestParam(defaultValue = "proNumber") String sort,
//      @RequestParam(defaultValue = "DESC") String direction) {
//
//    Page<FreightBillHeader> freightBills = freightBillService.getFreightBillsSorted(
//        page, size, sort, direction);
//
//    return ResponseEntity.ok(freightBills);
//  }
}
