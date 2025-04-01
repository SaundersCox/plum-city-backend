package com.plumcity.plum_city.repository;

import com.plumcity.plum_city.entity.denodo.FreightBillHeader;
import java.sql.ResultSet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// TODO: Support JPA
//@Repository
//public interface FreightBillHeaderRepository extends JpaRepository<FreightBillHeader, String> {
//
//  Page<FreightBillHeader> findAll(Pageable pageable);
//}

@Repository
@RequiredArgsConstructor
public class FreightBillHeaderRepository {

  // Row mapper for FreightBillHeader
  private static final RowMapper<FreightBillHeader> rowMapper = (ResultSet rs, int rowNum) -> {
    FreightBillHeader header = new FreightBillHeader();
    header.setProNumber(rs.getString("FHPRO"));
    // Map other fields...
    return header;
  };
  private final JdbcTemplate jdbcTemplate;

  public FreightBillHeader findByProNumber(String proNumber) {
    String sql = "SELECT * FROM FREIGHT_BILL_HEADER WHERE FHPRO = ?";
    List<FreightBillHeader> results = jdbcTemplate.query(sql, rowMapper, proNumber);
    return results.isEmpty() ? null : results.getFirst();
  }

  public List<FreightBillHeader> findAll() {
    String sql = "SELECT * FROM FREIGHT_BILL_HEADER";
    return jdbcTemplate.query(sql, rowMapper);
  }
}