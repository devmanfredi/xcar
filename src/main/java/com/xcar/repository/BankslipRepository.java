package com.xcar.repository;

import com.xcar.model.entity.Bankslip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface BankslipRepository extends JpaRepository<Bankslip, UUID> {
    @Transactional
    @Modifying
    @Query("UPDATE Bankslip b SET b.status = :status WHERE b.id = :id")
    void updateBankslipStatusById(@Param("id") String id, @Param("status") String status);
}
