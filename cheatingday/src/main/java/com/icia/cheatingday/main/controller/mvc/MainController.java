package com.icia.cheatingday.main.controller.mvc;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.icia.cheatingday.util.editor.*;

@Controller
public class MainController {
	@InitBinder
	public void init(WebDataBinder wdb) {
		wdb.registerCustomEditor(List.class, "authorities", new AuthorityPropertyEditor());
	}
	
	//@Autowired
	//private MainService service;

	 
	// [공용] 로그인
	@GetMapping
	public ModelAndView login() {
		return new ModelAndView("main").addObject("viewName", "main/login.jsp");
	}
	
	
	/*
	// [일반] 회원가입 Get
	@GetMapping("/main/join_user")
	public ModelAndView UserJoin() {
		return new ModelAndView("main").addObject("viewName", "main/userjoin.jsp");
	}
	
	
	// [일반] 회원가입 Post
	@PostMapping("/main/join_user")
	public String ManagerJoin(@Valid UserDto.DtoForJoin dto, BindingResult bindingResult, RedirectAttributes ra) throws BindException {
		if(bindingResult.hasErrors()==true)
			throw new BindException(bindingResult);
		try {
			service.UserJoin(dto);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		ra.addFlashAttribute("msg", "치팅데이에 오신것을 환영합니다!");
		return "redirect:/system/msg";
	}
	
	
	// [일반] 아이디 찾기 Get
	@GetMapping("/main/u_find_id")
	public ModelAndView findUserUsername() {
		return new ModelAndView("main").addObject("viewName", "main/findid.jsp");
	}
	
	
	// [일반] 아이디찾기 Post
	@PostMapping("/main/u_find_id")
	public String findUserUsername(@RequestParam @NotNull String uIrum, @RequestParam @NotNull String uEmail, RedirectAttributes ra) {
		String username = service.findUserUsername(uIrum, uEmail);
		ra.addFlashAttribute("msg", "아이디는 " + username + " 입니다.");
		return "redirect:/main/login";
	}
	
	
	// [일반] '마이페이지' 클릭 시 비밀번호 확인 Get
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/main/u_check_pwd")
	public ModelAndView checkUserPwd() {
		return new ModelAndView("main").addObject("viewName", "main/checkpwd.jsp");
	}
	
	// [일반] '마이페이지' 클릭 시 비밀번호 확인 Post
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/main/u_check_pwd")
	public String checkUserPwd(String uPassword, Principal principal, HttpSession session) {
		service.checkUserPwd(uPassword, principal.getName());
		session.setAttribute("isCheck", "true");
		return "redirect:/user";
	}
	
	
	// [일반] 비밀번호 찾기 (재설정) Get
	@GetMapping("/main/u_find_pwd")
	public ModelAndView findUserPwd() {
		return new ModelAndView().addObject("viewName", "main/findpwd.jsp");
	}
	
	// [일반] 비밀번호 찾기 (재설정) Post
	@PostMapping("/main/u_find_pwd")
	public String resetUserPwd(@RequestParam @NotNull String uEmail, @RequestParam @NotNull String uUsername, RedirectAttributes ra) throws MessagingException {
		service.resetUserPwd(uUsername, uEmail);
		ra.addFlashAttribute("msg", "이메일로 비밀번호 재설정 링크를 발송했습니다. 확인해주세요");
		return "redirect:/main/login";
	}
	
	
	
	
	// [사업자] 회원가입 Get
	@GetMapping("/main/join_manager")
	public ModelAndView ManagerJoin() {
		return new ModelAndView("main").addObject("viewName", "main/managerjoin.jsp");
	}
	
	
	// [사업자] 회원가입 Post
	@PostMapping("/main/join_manager")
	public String ManagerJoin(@Valid ManagerDto.DtoForJoin dto, BindingResult bindingResult, RedirectAttributes ra) throws BindException {
		if(bindingResult.hasErrors()==true)
			throw new BindException(bindingResult);
		try {
			service.ManagerJoin(dto);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		ra.addFlashAttribute("msg", "가입 신청이 완료되었습니다. 관리자 승인 후 가입이 완료됩니다");
		return "redirect:/system/msg";
	}
	
	
	// [사업자] 아이디 찾기 Get
	@GetMapping("/main/m_find_id")
	public ModelAndView findManagerUsername() {
		return new ModelAndView("main").addObject("viewName", "main/findid.jsp");
	}
	
	
	// [사업자] 아이디찾기 Post
	@PostMapping("/main/m_find_id")
	public String findManagerUsername(@RequestParam @NotNull String mIrum, @RequestParam @NotNull String mEmail, RedirectAttributes ra) {
		String mUsername = service.findManagerUsername(mIrum, mEmail);
		ra.addFlashAttribute("msg", "아이디는 " + mUsername + " 입니다.");
		return "redirect:/main/login";
	}
	
	// [사업자] '사장님 페이지로' 클릭 시 비밀번호 확인 Get
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/main/m_check_pwd")
	public ModelAndView checkManagerPwd() {
		return new ModelAndView("main").addObject("viewName", "main/checkpwd.jsp");
	}
	
	// [사업자] '사장님 페이지로' 클릭 시 비밀번호 확인 Post
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/main/m_check_pwd")
	public String checkManagerPwd(String mPassword, Principal principal, HttpSession session) {
		service.checkManagerPwd(mPassword, principal.getName());
		session.setAttribute("isCheck", "true");
		return "redirect:/manager";
	}
	
	// [사업자] 비밀번호 찾기 (재설정) Get
	@GetMapping("/main/m_find_pwd")
	public ModelAndView findManagerPwd() {
		return new ModelAndView().addObject("viewName", "main/findpwd.jsp");
	}
	
	// [사업자] 비밀번호 찾기  (재설정) Post
	@PostMapping("/main/m_find_pwd")
	public String resetManagerPwd(@RequestParam @NotNull String mEmail, @RequestParam @NotNull String mUsername, RedirectAttributes ra) throws MessagingException {
		service.resetManagerPwd(mUsername, mEmail);
		ra.addFlashAttribute("msg", "이메일로 비밀번호 재설정 링크를 발송했습니다. 확인해주세요");
		return "redirect:/main/login";
	}
	*/
}
