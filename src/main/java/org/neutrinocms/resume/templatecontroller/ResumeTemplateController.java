package org.neutrinocms.resume.templatecontroller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.jsp.PageContext;

import org.neutrinocms.core.bo.annotation.BlockMapping;
import org.neutrinocms.core.bo.annotation.ElementMapping;
import org.neutrinocms.core.bo.annotation.TemplateController;
import org.neutrinocms.core.exception.ControllerException;
import org.neutrinocms.core.exception.ServiceException;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.core.model.translation.Page;
import org.neutrinocms.core.model.translation.Template;
import org.neutrinocms.core.model.translation.Translation;
import org.neutrinocms.resume.conf.ApplicationProperties;
import org.neutrinocms.resume.model.Contact;
import org.neutrinocms.resume.model.Resume;
import org.neutrinocms.resume.model.Skill.SkillKind;
import org.neutrinocms.resume.service.AchievementService;
import org.neutrinocms.resume.service.ArticleService;
import org.neutrinocms.resume.service.CategoryService;
import org.neutrinocms.resume.service.EducationService;
import org.neutrinocms.resume.service.ExperienceService;
import org.neutrinocms.resume.service.PortfolioService;
import org.neutrinocms.resume.service.ResumeService;
import org.neutrinocms.resume.service.SkillService;
import org.neutrinocms.resume.service.SocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@TemplateController
@Component
public class ResumeTemplateController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AchievementService achievementService;
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private ExperienceService experienceService;
	
	@Autowired
	private EducationService educationService;
	
	@Autowired
	private SocialNetworkService socialNetworkService;
	
	@Autowired
	private PortfolioService portfolioService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ResumeService resumeService;
	
	@Autowired
	private ApplicationProperties properties;
	
	protected static final String ATTR_CATEGORIES = "categories";
	protected static final String ATTR_ACTIVERESUME = "activeResume";
	protected static final String ATTR_ACHIEVEMENTS = "achievements";
	protected static final String ATTR_SKILLS = "skills";
	protected static final String ATTR_EXPERIENCES = "experiences";
	protected static final String ATTR_EDUCATIONS = "educations";
	protected static final    int ATTR_PORTFOLIOS_MAXRESULT = 10;
	protected static final    int ATTR_ARTICLES_MAXRESULT = 10;
	protected static final String ATTR_PUBLISHDATE = "publishDate";
	protected static final String ATTR_PORTFOLIOS = "portfolios";
	protected static final String ATTR_ARTICLES = "articles";
	protected static final String ATTR_SOCIALNETWORK = "socialnetworks";
	protected static final String ATTR_ACTIVEPAGE = "activePage";
	protected static final String ATTR_ACTIVELANG = "activeLang";
	
	@ElementMapping("resume_element_activeResume")
	public ModelMap activeResume(Folder folder, Lang lang, PageContext pageContext) throws ControllerException{
		try {
			ModelMap modelMap = new ModelMap();
			if (pageContext != null){
				Resume resume = resumeService.identify(folder, properties.getResumeName(), lang);
				modelMap.addAttribute(ATTR_ACTIVERESUME, resume);
			}
			return modelMap;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
	
	@BlockMapping({"resume_block_nav", "resume_block_listpage"})
	public ModelMap navs(Translation model, Translation activeObject, Template template, Folder folder, Lang lang) throws ControllerException{	
		try {
			ModelMap modelMap = new ModelMap();
			modelMap.addAttribute(ATTR_CATEGORIES, categoryService.findAllForFolderAndLang(folder, lang));
			return modelMap;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}

	}

	@ElementMapping("resume_block_achievement")
	public ModelMap achievement(Folder folder, Lang lang, PageContext pageContext) throws ControllerException{
		try {
			ModelMap modelMap = new ModelMap();
			if (pageContext != null){
				modelMap.addAttribute(ATTR_ACHIEVEMENTS, achievementService.findAllForFolderAndLang(folder, lang));
			}
			return modelMap;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
	
	@BlockMapping("resume_block_skill_progressBar_list")
	public ModelMap skillsProgressBar(Folder folder, Lang lang, PageContext pageContext) throws ControllerException{	
		try {
			ModelMap modelMap = new ModelMap();
			if (pageContext != null){
				modelMap.addAttribute(ATTR_SKILLS, skillService.findAllKindForFolderAndLang(SkillKind.PROGRESSBAR, folder, lang));
			}
			return modelMap;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}

	}

	@BlockMapping("resume_block_skill_chart_list")
	public ModelMap skillsChart(Folder folder, Lang lang, PageContext pageContext) throws ControllerException{	
		try {
			ModelMap modelMap = new ModelMap();
			if (pageContext != null){
				modelMap.addAttribute(ATTR_SKILLS, skillService.findAllKindForFolderAndLang(SkillKind.CHART, folder, lang));
			}
			return modelMap;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
	
	@BlockMapping("resume_block_experience_list")
	public ModelMap experiences(Folder folder, Lang lang, PageContext pageContext) throws ControllerException{	
		try {
			ModelMap modelMap = new ModelMap();
			if (pageContext != null){
				modelMap.addAttribute(ATTR_EXPERIENCES, experienceService.findAllForFolderAndLang(folder, lang));
			}
			return modelMap;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
	
	@BlockMapping("resume_block_education_list")
	public ModelMap educations(Folder folder, Lang lang, PageContext pageContext) throws ControllerException{
		try {
			ModelMap modelMap = new ModelMap();
			if (pageContext != null){
				modelMap.addAttribute(ATTR_EDUCATIONS, educationService.findAllForFolderAndLang(folder, lang));
			}
			return modelMap;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
	
	@BlockMapping("resume_block_portfolio_list")
	public ModelMap portfolios(Folder folder, Lang lang, PageContext pageContext) throws ControllerException{
		try {
			ModelMap modelMap = new ModelMap();
			if (pageContext != null){
				List<Order> orders = new ArrayList<>();
				orders.add(new Order(Direction.DESC, ATTR_PUBLISHDATE));
				Pageable pageRequest = new PageRequest(0, ATTR_PORTFOLIOS_MAXRESULT, new Sort(orders));
				modelMap.addAttribute(ATTR_PORTFOLIOS, portfolioService.findAllForFolderAndLang(folder, lang, pageRequest).getContent());
			}
			return modelMap;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
	
	@BlockMapping("resume_block_blog_list")
	public ModelMap articles(Folder folder, Lang lang, PageContext pageContext) throws ControllerException{
		try {
			ModelMap modelMap = new ModelMap();
			if (pageContext != null){
				List<Order> orders = new ArrayList<>();
				orders.add(new Order(Direction.DESC, ATTR_PUBLISHDATE));
				
				Pageable pageRequest = new PageRequest(0, ATTR_ARTICLES_MAXRESULT, new Sort(orders));
				modelMap.addAttribute(ATTR_ARTICLES, articleService.findAllForFolderAndLang(folder, lang, pageRequest).getContent());
			}
			return modelMap;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}

	@ElementMapping("resume_element_socialnetwork")
	public ModelMap socialnetwork(Folder folder, Lang lang, PageContext pageContext) throws ControllerException{
		try {
			ModelMap modelMap = new ModelMap();
			if (pageContext != null){
				modelMap.addAttribute(ATTR_SOCIALNETWORK, socialNetworkService.findAllForFolderAndLang(folder, lang));
				modelMap.addAttribute("contact", new Contact());
			}
			return modelMap;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
	
	@BlockMapping("resume_block_breadbrumb")
	public ModelMap breadcrumb(Folder folder, Lang lang, PageContext pageContext) throws ControllerException{
		ModelMap modelMap = new ModelMap();
		if (pageContext != null){
			List<Page> pages = new ArrayList<>();
			Page page = (Page) pageContext.getAttribute(ATTR_ACTIVEPAGE, PageContext.REQUEST_SCOPE);
			pages.add(page);
			while (true) {
				page = page.getParent();
				if (page != null) pages.add(page);
				else break;
	        }
			Collections.reverse(pages);
			modelMap.addAttribute("breadcrumbPages", pages);
		}
		return modelMap;
	}
	
	
	
	
}
