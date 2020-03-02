package com.h2sj.springdata.jpa.repository;

import com.h2sj.springdata.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>, JpaSpecificationExecutor<Member> {

    @Query(nativeQuery = true,value = "select * from db_member where m_nickname=#{mNickname}")
    public List<Member> getListByNNickname(String mNickname);
}
