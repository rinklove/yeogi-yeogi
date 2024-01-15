package com.yeogi.app.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yeogi.app.member.service.MemberService;
import com.yeogi.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("member")
@ResponseBody
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MemberController {

    private final MemberService service;

    //회원가입
    @PostMapping("join")
    public Map<String,String> join(@RequestBody MemberVo vo) throws Exception {
    	System.out.println(vo);
        int result = service.join(vo);
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}        
        return map;
    }

	// 로그인
    @PostMapping("login")
    public Map<String, Object> login(MemberVo vo) throws Exception {
        MemberVo loginMember = service.login(vo);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","good");
        map.put("loginMember", loginMember);
        System.out.println(loginMember);
        if(loginMember == null ) {
        	map.put("msg", "bad");
        }
        return map;        
    }
    
    // 회원 탈퇴
    @PostMapping("quit")
    public Map<String,String> quit(MemberVo vo) throws Exception {
        int result = service.quit(vo);
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}        
        return map;
        
    }

    //회원정보조회
    @PostMapping("mySelect")
    public Map<String, Object> mySelect(MemberVo vo) throws Exception {
    	
    	MemberVo loginMember = service.mySelect(vo);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","good");
        map.put("loginMember", loginMember);
        System.out.println(loginMember);
        if( loginMember == null ) {
        	map.put("msg", "bad");
        }
        return map;  
    }
    
    //내 정보 수정하기 
    @PostMapping("edit")
    public Map<String,String> edit(MemberVo vo) throws Exception {
        int result = service.edit(vo);
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}        
        return map;
        
    }
    
    //
//    @PostMapping("memberLogin")
//    public 
    
    
    
}//class
