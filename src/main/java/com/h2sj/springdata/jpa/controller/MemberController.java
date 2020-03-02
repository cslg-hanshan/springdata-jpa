package com.h2sj.springdata.jpa.controller;

import com.h2sj.springdata.jpa.entity.Member;
import com.h2sj.springdata.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping(value = "/{id}")
    public Member get(@PathVariable("id") Long id){
        Member member = memberService.get(id);
        return member;
    }

    @PostMapping(value = "")
    public String save(@Valid Member member, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            String ret = fieldErrors.toString();
            return ret;
        }
        memberService.insert(member);
        return "OK";
    }
}
