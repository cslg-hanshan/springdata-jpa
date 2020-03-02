package com.h2sj.springdata.jpa.service;

import com.h2sj.springdata.jpa.entity.Member;
import com.h2sj.springdata.jpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /*-----------------------------------------增------------------------------------------*/
    public void insert(Member object){
        memberRepository.save(object);
    }
    /*-----------------------------------------删------------------------------------------*/

    public void delete(Long id){
        memberRepository.deleteById(id);
    }
    /*-----------------------------------------改------------------------------------------*/
    public void update(Member object){
        memberRepository.save(object);
    }
    /*-----------------------------------------查------------------------------------------*/
    public Member get(Long id){
        Optional<Member> byId = memberRepository.findById(id);
        return byId.orElseGet(null);
    }

    public Page<Member> getPages(Integer page,Integer limit){
        PageRequest pageRequest = PageRequest.of(page - 1, limit);
        return memberRepository.findAll(pageRequest);
    }

    public List<Member> getListByNickname(String str){
        List<Member> list = memberRepository.findAll(new Specification<Member>() {
            @Override
            public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate mNickname = criteriaBuilder.equal(root.get("mNickname"), str);
                return mNickname;
            }
        });
        return list;
    }

}
