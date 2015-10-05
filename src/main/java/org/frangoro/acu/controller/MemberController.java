package org.frangoro.acu.controller;

import java.util.List;

import org.frangoro.acu.editor.CategoryEditor;
import org.frangoro.acu.model.CategoryEntity;
import org.frangoro.acu.model.MemberEntity;
import org.frangoro.acu.service.MemberService;
import org.frangoro.acu.validator.MemberValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/member-module")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberValidator memberValidator = new MemberValidator();
	
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
    public String submitForm(@ModelAttribute("member") MemberEntity member, BindingResult result, SessionStatus status) {
    	
    	logger.debug("Start submitForm");
    	// Spring validation
    	Errors errors = new BeanPropertyBindingResult(member,"member");
    	ValidationUtils.invokeValidator(memberValidator, member, errors);
    	List<ObjectError> allObjectErrors = errors.getAllErrors();
    	for (ObjectError objectError : allObjectErrors) {
    		if (objectError instanceof FieldError) {
    			result.addError(objectError);
    		}
    	}
    	
    	if (result.hasErrors()) {
    		logger.info("Validation errors were happened");
    		return "members";
    	}
    	
    	memberService.addMember(member);
    	
    	logger.debug("End submitForm");
    	
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
