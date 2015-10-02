package org.frangoro.acu.controller;

import java.util.List;

import org.frangoro.acu.editor.CategoryEditor;
import org.frangoro.acu.model.CategoryEntity;
import org.frangoro.acu.model.MemberEntity;
import org.frangoro.acu.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/member-module")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	/**
     * Method will be called in initial page load at GET /
     * */
    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model)
    {
    	MemberEntity member = new MemberEntity();
        model.addAttribute("member", member);
        return "members";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(MemberEntity member) {
    	
    	memberService.addMember(member);
    	
    	return "redirect:member-module";
    }
    
    /**
     * Bind CategoryEditor to CategoryEntity
     * */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(CategoryEntity.class, new CategoryEditor());
    }
    
    /**
     * Bind all members list
     * */
    @ModelAttribute("allMembers")
    public List<MemberEntity> populateMembers()
    {
        List<MemberEntity> members = memberService.getAllMembers();
        return members;
    }
    
    /**
     * Bind all categories
     **/
    @ModelAttribute("allCategories")
    public List<CategoryEntity> populateCategories()
    {
        List<CategoryEntity> categories = memberService.getAllCategories();
        return categories;
    }
		
}
