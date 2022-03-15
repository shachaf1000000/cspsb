package com.fscsp.csp.repos;


import com.fscsp.csp.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompaniesRepository extends JpaRepository<Company,Integer> {
    Company findByEmailAndPassword(String email, String password);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN 'true' ELSE 'false' END FROM Company c WHERE c.name = ?1 Or c.email = ?2")
    Boolean existsByNameOrEmail(String name, String email);

    Boolean existsById(Company company);

    @Query("select c from Company c where c.email = ?1 and c.id <> ?2")
    Company findCompanyByEmailAndId(String email, int id);

    Company findByName(String name);

    List<Company> findByIdAndName(int id, String name);

    String findByPassword(String password);

    default Company findOneCompanyById(int companyId) {
        return findById(companyId).iterator().next();

    }

    boolean existsByEmailAndPassword(String email, String password);

    List <Company> findByEmail(String companyEmail) ;

    List <Company> findById(int companyId) ;

    boolean existsByEmail(String email);

    boolean existsByName(String Name);
}
