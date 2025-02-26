package com.prakash.cuconv.repository;

import com.prakash.cuconv.model.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionRepository extends JpaRepository<Conversion, Long> {
}
