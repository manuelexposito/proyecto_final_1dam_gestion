package com.salesianas.dam.mesasroleras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianas.dam.mesasroleras.model.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
