package com.salesianas.dam.mesasroleras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.salesianas.dam.mesasroleras.model.Member;
/**
 * <h1>MemberRepository</h1>
 * 
 * This interface represents the data access object(DAO) for the model {@link Member}. Extends the interface JpaRepository.
 * 
 * @see Member
 * @see JpaRepository
 * 
 * @author Manuel Exposito Herrera
 *
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
