package org.neutrinocms.resume.dbinitializer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.neutrinocms.bo.dbinitializer.InitBO;
import org.neutrinocms.bo.service.light.LinkService;
import org.neutrinocms.bo.service.light.StorageService;
import org.neutrinocms.core.conf.NeutrinoCoreProperties;
import org.neutrinocms.core.exception.ServiceException;
import org.neutrinocms.core.model.independant.Folder;
import org.neutrinocms.core.model.independant.MapTemplate;
import org.neutrinocms.core.model.independant.NData;
import org.neutrinocms.core.model.independant.NSchema;
import org.neutrinocms.core.model.independant.NSchema.ScopeType;
import org.neutrinocms.core.model.independant.NType;
import org.neutrinocms.core.model.independant.NType.ValueType;
import org.neutrinocms.core.model.independant.Position;
import org.neutrinocms.core.model.translation.Lang;
import org.neutrinocms.core.model.translation.Page;
import org.neutrinocms.core.model.translation.Template;
import org.neutrinocms.core.model.translation.Translation;
import org.neutrinocms.core.service.FolderService;
import org.neutrinocms.core.service.LangService;
import org.neutrinocms.core.service.MapTemplateService;
import org.neutrinocms.core.service.NDataService;
import org.neutrinocms.core.service.NSchemaService;
import org.neutrinocms.core.service.PageService;
import org.neutrinocms.core.service.PositionService;
import org.neutrinocms.core.service.TObjectService;
import org.neutrinocms.core.service.TemplateService;
import org.neutrinocms.core.util.IdProviderUtil;
import org.neutrinocms.resume.model.Article;
import org.neutrinocms.resume.model.Category;
import org.neutrinocms.resume.model.Education;
import org.neutrinocms.resume.model.Experience;
import org.neutrinocms.resume.model.Icon;
import org.neutrinocms.resume.model.Job;
import org.neutrinocms.resume.model.Portfolio;
import org.neutrinocms.resume.model.Resume;
import org.neutrinocms.resume.model.Skill;
import org.neutrinocms.resume.model.Skill.SkillKind;
import org.neutrinocms.resume.model.SocialNetwork;
import org.neutrinocms.resume.service.CategoryService;
import org.neutrinocms.resume.service.EducationService;
import org.neutrinocms.resume.service.ExperienceService;
import org.neutrinocms.resume.service.IconService;
import org.neutrinocms.resume.service.MemberService;
import org.neutrinocms.resume.service.PortfolioService;
import org.neutrinocms.resume.service.ResumeService;
import org.neutrinocms.resume.service.SkillService;
import org.neutrinocms.resume.service.SocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InitResume {
	private Logger logger = Logger.getLogger(InitResume.class);
	
	public InitResume() {

	}
	
	@Autowired
	private InitBO InitBO;
	
	@Autowired
	private NeutrinoCoreProperties applicationProperties;
	
	
	@Autowired
	private StorageService fileService;
	
	
	@Autowired
	private LinkService linkService;
	
	@Autowired
	private LangService langService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private NSchemaService nSchemaService;
	
	@Autowired
	private NDataService nDataService;
	
	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private PositionService positionService;
	
	@Autowired
	private MapTemplateService mapTemplateService;
	
	@Autowired
	private PageService pageService;
	
	@Autowired
	private ResumeService resumeService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private IconService iconService;
	
	
	@Autowired
	private FolderService folderService;

	@Autowired
	private TObjectService tObjectService;
	
	

	@Autowired
	private IdProviderUtil idProviderUtil;

	@Autowired
	private SkillService skillService;
	
	@Autowired
	private ExperienceService experienceService;
	
	@Autowired
	private EducationService educationService;
	
	@Autowired
	private PortfolioService portfolioService;
	
	@Autowired
	private SocialNetworkService socialNetworkService;
	
	Map<String, Folder> mapfolders;
	
	@PostConstruct
	public void run() throws ServiceException, InstantiationException, IllegalAccessException {
		logger.debug("init");
		if (!applicationProperties.getHibernateHbm2ddlAuto().equals("create-drop")) return;
		
		initFolders();
		
		initLangs();
		initUsers();

		initTemplates();
		
		initCv();
	}

	private Lang langEN;
	private Lang langFR;
	private List<Lang> langs;
	public void initLangs() throws ServiceException{
		logger.debug("init langs");
		langs = new ArrayList<>();

		langEN = langService.findByCode("en");
		langs.add(langEN);
		
		langFR = langService.findByCode("fr");
		langs.add(langFR);
	}
	
	
	public void initUsers() throws ServiceException{
		logger.debug("init users");
//		Member member = new Member();
//		member.setLogin("admin");
//		ShaPasswordEncoder sha = new ShaPasswordEncoder();
//		member.setEncryptPassword(sha.encodePassword("852963", null));
//		member.setEnabled(true);
//		member.setRole("ROLE_ADMIN");
//		member.setFirstName("Super");
//		member.setLastName("Boss");
//		member.setMail("postmaster@cedric-sevestre.fr");
//		memberService.save(member);
//
//		member = new Member();
//		member.setLogin("mrYapados");
//		sha = new ShaPasswordEncoder();
//		member.setEncryptPassword(sha.encodePassword("852963", null));
//		member.setEnabled(true);
//		member.setRole("ROLE_USER");
//		member.setFirstName("Cédric");
//		member.setLastName("Sevestre");
//		member.setMail("info@cedric-sevestre.fr");
//		memberService.save(member);
//		
//		User user = new User();
//		user.setLogin("admin");
//		ShaPasswordEncoder sha = new ShaPasswordEncoder();
//		user.setEncryptPassword(sha.encodePassword("852963", null));
//		user.setEnabled(true);
//		List<Authority> authorities = new ArrayList<Authority>();
//		authorities.add(mapAuthorities.get(AuthorityName.ROLE_ADMIN));
//		user.setAuthorities(authorities);
//		memberService.save(user);
//
//		user = new User();
//		user.setLogin("mrYapados");
//		sha = new ShaPasswordEncoder();
//		user.setEncryptPassword(sha.encodePassword("852963", null));
//		user.setEnabled(true);
//		authorities = new ArrayList<Authority>();
//		authorities.add(mapAuthorities.get(AuthorityName.ROLE_USER));
//		user.setAuthorities(authorities);
//		userService.save(user);
	}

	public void initTemplates() throws ServiceException{
		logger.debug("init templates");
				
		Template homeEN = templateService.translate(new Template(), langEN);
		homeEN.setName("home");
		homeEN.setDescription("home description en");
		homeEN.setMetaTitle("home");
		homeEN.setMetaDescription("MetaDescription");
		homeEN.setPath("home/home");
		homeEN.setKind(Template.TemplateKind.PAGE);
		templateService.save(homeEN);
		
		Template homeFr = templateService.translate(homeEN, langFR);
		homeFr.setName("home");
		homeFr.setDescription("home description fr");
		templateService.save(homeFr);

		
		
		Template homeProjectEN = templateService.translate(new Template(), langEN);
		homeProjectEN.setName("homeProject");
		homeProjectEN.setDescription("homeProject description en");
		homeProjectEN.setMetaTitle("{0}");
		homeProjectEN.setMetaDescription("MetaDescription");
		homeProjectEN.setPath("home/homeProject");
		homeProjectEN.setKind(Template.TemplateKind.PAGE);
		templateService.save(homeProjectEN);
		
		Template homeProjectFr = templateService.translate(homeProjectEN, langFR);
		homeProjectFr.setName("homeProject");
		homeProjectFr.setDescription("homeProject description fr");
		templateService.save(homeProjectFr);

		
		
		Template homeArticleEN = templateService.translate(new Template(), langEN);
		homeArticleEN.setName("homeArticle");
		homeArticleEN.setDescription("homeArticle description en");
		homeArticleEN.setMetaTitle("{0}");
		homeArticleEN.setMetaDescription("MetaDescription");
		homeArticleEN.setPath("home/homeArticle");
		homeArticleEN.setKind(Template.TemplateKind.PAGE);
		templateService.save(homeArticleEN);
		
		Template homeArticleFr = templateService.translate(homeArticleEN, langFR);
		homeArticleFr.setName("homeArticle");
		homeArticleFr.setDescription(" description fr");
		templateService.save(homeArticleFr);
		
		
		
//		String name = "";
//		
//		name = "@bo_list";
//		Template bo_listEN = templateService.translate(new Template(), langEN);
//		bo_listEN.setName(name + "");
//		bo_listEN.setDescription(name + " description en");
//		bo_listEN.setMetaTitle("{0}");
//		bo_listEN.setMetaDescription("MetaDescription");
//		bo_listEN.setPath("home/home");
//		bo_listEN.setType(Template.TemplateType.PAGE);
//		templateService.save(bo_listEN);
//		
//		Template bo_listFR = templateService.translate(bo_listEN, langFR);
//		bo_listFR.setName(name + "");
//		bo_listFR.setDescription(name + " description fr");
//		templateService.save(bo_listFR);
		
		
		
		
		
		
		

	}

	public void initFolders() throws ServiceException{
		logger.debug("init initFolders");
		
		mapfolders = new HashMap<>();

		List<String> serverNames = null;
		Folder folder = null;
		
		folder = new Folder();
		folder.setName("front");
		serverNames = new ArrayList<>();
		serverNames.add("front");
		folder.setServerName(serverNames);
		folder.setPath("pages/");
		folderService.save(folder);
		mapfolders.put(folder.getName(), folder);
	}
	

	public MapTemplate addMapTemplate(Translation model, String block, String position, Integer ordered) throws ServiceException{
		MapTemplate mapTemplate = new MapTemplate();
		mapTemplate.setModel(model);
		mapTemplate.setBlock(templateService.identify(null, block, model.getLang()));

		mapTemplate.setPosition(positionService.findByName(position));
		mapTemplate.setOrdered(ordered);
		mapTemplateService.save(mapTemplate);
		return mapTemplate;
	}
	


	
	

	
	public Position mkPosition(String name) throws ServiceException{
		Position position = new Position();
		position.setName(name);
		positionService.save(position);
		return position;
	}
	public Position addPosition(Map<String, Position> mapPosition, String name) throws ServiceException {
		Position position = mkPosition(name);
		mapPosition.put(name, position);
		return position;
	}
	
	public MapTemplate addMapTemplate(Translation model, Translation block, Position position, Integer ordered) throws ServiceException{
		MapTemplate mapTemplate = new MapTemplate();
		mapTemplate.setModel(model);
		mapTemplate.setBlock((Template) block);
		mapTemplate.setPosition(position);
		mapTemplate.setOrdered(ordered);
		mapTemplateService.save(mapTemplate);
		return mapTemplate;
	}
	public Map<Lang, MapTemplate> addMapTemplate(Map<Lang, Translation> models, Map<Lang, Translation> blocks, Position position) throws ServiceException{
		Map<Lang, MapTemplate> mapTemplates = new HashMap<>();
		for (Lang lang : langs) {
			mapTemplates.put(lang, addMapTemplate(models.get(lang), blocks.get(lang), position, orderBlock(position)));
		}
		return mapTemplates;
	}
	
	private Map<Position, Integer> countPosition;
	public Integer orderBlock(Position position){
		if (countPosition == null) countPosition = new HashMap<>();
		Integer count;
		if (!countPosition.containsKey(position)){
			countPosition.put(position, 0);
		}
		count = countPosition.get(position) + 10;
		countPosition.put(position, count);
		return count;
	}
	
	

	public Map<Lang, Translation> mkPage(Page base, Folder folder, String name, String context, Map<Lang, Translation> models, Map<Lang, Translation> parents) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkPage(base, folders, name, context, models, parents);
	}
	public Map<Lang, Translation> mkPage(Page base, List<Folder> folders, String name, String context, Map<Lang, Translation> models, Map<Lang, Translation> parents) throws ServiceException{
		Map<Lang, Translation> map = new HashMap<>();
		Page first = null;
		for (Lang lang : langs) {
			Page page = null;
			if (first == null){
				page = pageService.translate(base, lang);
				page.setName(name);
				if (base.getDescription() == null) page.setDescription(name + " Page description " + lang.getCode());
				page.setContext(context);
				page.setModel((Template) models.get(lang));
				page.setFolders(folders);
				if (parents != null) page.setParent((Page) parents.get(lang));
				first = page;
			} else {
				page = pageService.translate(first, lang);
				page.setFolders(folders);
				page.setName(name);
				if (base.getDescription() == null) page.setDescription(name + " Page description " + lang.getCode());
				if (parents != null) page.setParent((Page) parents.get(lang));
			}
			
			if (base instanceof Category){
				Category cat = (Category) page;
				cat.setMenuColor(((Category) base).getMenuColor());
				cat.setTitle(((Category) base).getTitle());
				cat.setIcon(((Category) base).getIcon());
				cat.setOrdered(((Category) base).getOrdered());
				cat.setInMenu(((Category) base).getInMenu());
				cat.setDescription(((Category) base).getDescription());
			} else if (base instanceof Portfolio){
				Portfolio port = (Portfolio) page;
				port.setDescription(((Portfolio) base).getDescription());
			} else {
				
			}
			
			pageService.save(page);
			map.put(lang, page);
		}
		return map;
	}

	
	public Map<Lang, Translation> mkModel(Folder folder, String name) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkModel(folders, name);
	}
	public Map<Lang, Translation> mkModel(List<Folder> folders, String name) throws ServiceException{
		return mkModel(folders, name, name + "/" + name);
	}
	public Map<Lang, Translation> mkModel(Folder folder, String name, String path) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkModel(folders, name, path);
	}
	public Map<Lang, Translation> mkModel(List<Folder> folders, String name, String path) throws ServiceException{
		Map<Lang, Translation> map = new HashMap<>();
		Template first = null;
		for (Lang lang : langs) {
			Template template = null;
			if (first == null){
				template = templateService.translate(new Template(), lang);
				template.setName(name);
				template.setDescription(name + " Model description " + lang.getCode());
				template.setMetaTitle("{0}");
				template.setMetaDescription("MetaDescription");
				template.setPath(path);
				template.setKind(Template.TemplateKind.PAGE);
				template.setFolders(folders);
				templateService.save(template);
				first = template;
			} else {
				template = templateService.translate(first, lang);
				template.setFolders(folders);
				template.setName(name);
				template.setDescription(name + " Model description " + lang.getCode());
				templateService.save(template);
			}
			map.put(lang, template);
		}
		return map;

	}
	
	


	
	
	public Map<Lang, Translation> mkPageBlock(Folder folder, String name) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkPageBlock(folders, name);
	}
	public Map<Lang, Translation> mkPageBlock(Folder folder, String name, String path) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkPageBlock(folders, name, path);
	}
	public Map<Lang, Translation> mkPageBlock(Folder folder, String name, String path, NSchema nSchema) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkPageBlock(folders, name, path, nSchema);
	}
	public Map<Lang, Translation> mkPageBlock(List<Folder> folders, String name) throws ServiceException{
		return mkPageBlock(folders, name, name + "/" + name, null);
	}
	public Map<Lang, Translation> mkPageBlock(List<Folder> folders, String name, String path) throws ServiceException{
		return mkPageBlock(folders, name, path, null);
	}
	public Map<Lang, Translation> mkPageBlock(List<Folder> folders, String name, String path, NSchema nSchema) throws ServiceException{
		Map<Lang, Translation> map = new HashMap<>();
		Template first = null;
		for (Lang lang : langs) {
			Template template = null;
			if (first == null){
				template = templateService.translate(new Template(), lang);
				template.setName(name);
				template.setDescription(name + " PageBlock description " + lang.getCode());
				template.setPath(path);
				template.setKind(Template.TemplateKind.PAGEBLOCK);
				template.setSchema(nSchema);
				template.setFolders(folders);
				templateService.save(template);
				first = template;
			} else {
				template = templateService.translate(first, lang);
				template.setFolders(folders);
				template.setName(name);
				template.setDescription(name + " PageBlock description " + lang.getCode());
				templateService.save(template);
			}
			map.put(lang, template);
		}
		return map;
	}
	
	
	
	
	
	
	
	public Map<Lang, Translation> mkElement(Folder folder, String name) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkElement(folders, name);
	}
	public Map<Lang, Translation> mkElement(Folder folder, String name, String path) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkElement(folders, name, path);
	}
	public Map<Lang, Translation> mkElement(Folder folder, String name, String path, NSchema nSchema) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkElement(folders, name, path, nSchema);
	}
	public Map<Lang, Translation> mkElement(List<Folder> folders, String name) throws ServiceException{
		return mkElement(folders, name, name + "/" + name, null);
	}
	public Map<Lang, Translation> mkElement(List<Folder> folders, String name, String path) throws ServiceException{
		return mkElement(folders, name, path, null);
	}
	public Map<Lang, Translation> mkElement(List<Folder> folders, String name, String path, NSchema nSchema) throws ServiceException{
		Map<Lang, Translation> map = new HashMap<>();
		Template first = null;
		for (Lang lang : langs) {
			Template template = null;
			if (first == null){
				template = templateService.translate(new Template(), lang);
				template.setName(name);
				template.setDescription(name + " Element description " + lang.getCode());
				template.setPath(path);
				template.setKind(Template.TemplateKind.ELEMENT);
				template.setSchema(nSchema);
				template.setFolders(folders);
				first = template;
			} else {
				template = templateService.translate(first, lang);
				template.setFolders(folders);
				template.setName(name);
				template.setDescription(name + " Element description " + lang.getCode());
				
			}
			template.setController(name);
			templateService.save(template);
			map.put(lang, template);
		}
		return map;
	}
	
	
	
	
	
	
	public Map<Lang, Translation> mkBlock(Folder folder, String name) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkBlock(folders, name);
	}
	public Map<Lang, Translation> mkBlock(Folder folder, String name, String path) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkBlock(folders, name, path);
	}
	public Map<Lang, Translation> mkBlock(Folder folder, String name, String path, NSchema nSchema) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkBlock(folders, name, path, nSchema);
	}
	public Map<Lang, Translation> mkBlock(List<Folder> folders, String name) throws ServiceException{
		return mkBlock(folders, name, name + "/" + name, null);
	}
	public Map<Lang, Translation> mkBlock(List<Folder> folders, String name, String path) throws ServiceException{
		return mkBlock(folders, name, path, null);
	}
	public Map<Lang, Translation> mkBlock(List<Folder> folders, String name, String path, NSchema nSchema) throws ServiceException{
		Map<Lang, Translation> map = new HashMap<>();
		Template first = null;
		for (Lang lang : langs) {
			Template template = null;
			if (first == null){
				template = templateService.translate(new Template(), lang);
				template.setName(name);
				template.setDescription(name + " Block description " + lang.getCode());
				template.setPath(path);
				template.setKind(Template.TemplateKind.BLOCK);
				template.setSchema(nSchema);
				template.setFolders(folders);
				first = template;
			} else {
				template = templateService.translate(first, lang);
				template.setFolders(folders);
				template.setName(name);
				template.setDescription(name + " Block description " + lang.getCode());
				
			}
			template.setController(name);
			templateService.save(template);
			map.put(lang, template);
		}
		return map;
	}

	
	public Icon mkIcon(Icon icon) throws ServiceException{
		return iconService.save(icon);
	}
	public Resume mkResume(Resume resume) throws ServiceException{
		return resumeService.save(resume);
	}
	
	public NSchema mkNSchema(Map<String, NType> columns, NSchema.ScopeType scopeType) throws ServiceException{
		NSchema nSchema = new NSchema();
		nSchema.setColumns(columns);
		nSchema.setScope(scopeType);
		nSchemaService.save(nSchema);
		return nSchema;
	}
	

	
	public Map<Lang, Translation> mkSocialNetwork(SocialNetwork base, Folder folder, String name) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkSocialNetwork(base, folders, name);
	}
	public Map<Lang, Translation> mkSocialNetwork(SocialNetwork base, List<Folder> folders, String name) throws ServiceException{
		Map<Lang, Translation> map = new HashMap<>();
		SocialNetwork first = null;
		for (Lang lang : langs) {
			SocialNetwork socialNetwork = null;
			if (first == null){
				socialNetwork = socialNetworkService.translate(base, lang);
				socialNetwork.setName(name);
				socialNetwork.setDescription(name + " Education description " + lang.getCode());
				socialNetwork.setFolders(folders);
				first = socialNetwork;
			} else {
				socialNetwork = socialNetworkService.translate(first, lang);
				socialNetwork.setFolders(folders);
				socialNetwork.setName(name);
				socialNetwork.setDescription(name + " Education description " + lang.getCode());
			}
						
			socialNetworkService.save(socialNetwork);
			map.put(lang, socialNetwork);
		}
		return map;
	}
	
	public Map<Lang, Translation> mkEducation(Education base, Folder folder, String name) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkEducation(base, folders, name);
	}
	public Map<Lang, Translation> mkEducation(Education base, List<Folder> folders, String name) throws ServiceException{
		Map<Lang, Translation> map = new HashMap<>();
		Education first = null;
		for (Lang lang : langs) {
			Education education = null;
			if (first == null){
				education = educationService.translate(base, lang);
				education.setName(name);
				education.setDescription(name + " Education description " + lang.getCode());
				education.setFolders(folders);
				first = education;
			} else {
				education = educationService.translate(first, lang);
				education.setFolders(folders);
				education.setName(name);
				education.setDescription(name + " Education description " + lang.getCode());
			}
						
			educationService.save(education);
			map.put(lang, education);
		}
		return map;
	}

	public Map<Lang, Translation> mkExperience(Experience base, Folder folder, String name, String context, Map<Lang, Translation> jobs) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkExperience(base, folders, name, jobs);
	}
	public Map<Lang, Translation> mkExperience(Experience base, List<Folder> folders, String name, Map<Lang, Translation> jobs) throws ServiceException{
		Map<Lang, Translation> map = new HashMap<>();
		Experience first = null;
		for (Lang lang : langs) {
			Experience experience = null;
			if (first == null){
				experience = experienceService.translate(base, lang);
				experience.setName(name);
				experience.setDescription(name + " Page description " + lang.getCode());
				experience.setFolders(folders);
				experience.setJob((Job) jobs.get(lang));
				first = experience;
			} else {
				experience = experienceService.translate(first, lang);
				experience.setFolders(folders);
				experience.setName(name);
				experience.setDescription(name + " Page description " + lang.getCode());
				experience.setJob((Job) jobs.get(lang));
			}
						
			experienceService.save(experience);
			map.put(lang, experience);
		}
		return map;
	}
	
	
	public Map<Lang, Translation> mkSkill(Skill base, Folder folder, String name) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkSkill(base, folders, name);
	}
	public Map<Lang, Translation> mkSkill(Skill base, List<Folder> folders, String name) throws ServiceException{
		Map<Lang, Translation> map = new HashMap<>();
		Skill first = null;
		for (Lang lang : langs) {
			Skill skill = null;
			if (first == null){
				skill = skillService.translate(base, lang);
				skill.setName(name);
				skill.setDescription(name + " Page description " + lang.getCode());
				skill.setFolders(folders);
				first = skill;
			} else {
				skill = skillService.translate(first, lang);
				skill.setFolders(folders);
				skill.setName(name);
				skill.setDescription(name + " Page description " + lang.getCode());
			}
						
			skillService.save(skill);
			map.put(lang, skill);
		}
		return map;
	}


//	public Map<Lang, Translation> mkPortfolio(Portfolio base, Folder folder, String name, String context, Map<Lang, Translation> models, Map<Lang, Translation> resumes) throws ServiceException{
//		List<Folder> folders = new ArrayList<>();
//		folders.add(folder);
//		return mkPortfolio(base, folders, name, context, models, resumes);
//	}
//	public Map<Lang, Translation> mkPortfolio(Portfolio base, List<Folder> folders, String name, String context, Map<Lang, Translation> models, Map<Lang, Translation> resumes) throws ServiceException{
//		Map<Lang, Translation> map = new HashMap<>();
//		Portfolio first = null;
//		for (Lang lang : langs) {
//			Portfolio portfolio = null;
//			if (first == null){
//				portfolio = portfolioService.translate(base, lang);
//				portfolio.setName(name);
//				portfolio.setContext(context);
//				portfolio.setDescription(name + " Portfolio description " + lang.getCode());
//				portfolio.setFolders(folders);
//				portfolio.setModel((Template) models.get(lang));
//				portfolio.setResume((Resume) resumes.get(lang));
//				first = portfolio;
//			} else {
//				portfolio = portfolioService.translate(first, lang);
//				portfolio.setFolders(folders);
//				portfolio.setContext(context);
//				portfolio.setModel((Template) models.get(lang));
//				portfolio.setName(name);
//				portfolio.setDescription(name + " Portfolio description " + lang.getCode());
//				portfolio.setResume((Resume) resumes.get(lang));
//			}
//						
//			portfolioService.save(portfolio);
////			map.put(lang, portfolio);
//		}
//		return map;
//	}
	
	public Map<Lang, Translation> mkTranslation(Translation base, Folder folder, String name, String context) throws ServiceException{
		List<Folder> folders = new ArrayList<>();
		folders.add(folder);
		return mkTranslation(base, folders, name);
	}
	public Map<Lang, Translation> mkTranslation(Translation base, List<Folder> folders, String name) throws ServiceException{
		Map<Lang, Translation> map = new HashMap<>();
		Translation first = null;
		for (Lang lang : langs) {
			Translation translation = null;
			if (first == null){
				translation = tObjectService.translate(base, lang);
				translation.setName(name);
				translation.setDescription(name + " Page description " + lang.getCode());
				translation.setFolders(folders);
				first = translation;
			} else {
				translation = tObjectService.translate(first, lang);
				translation.setFolders(folders);
				translation.setName(name);
				translation.setDescription(name + " Page description " + lang.getCode());
			}
						
			tObjectService.save(translation);
			map.put(lang, translation);
		}
		return map;
	}
	
	
	private Date mkDate(int year, int month, int day){
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(year, month, day);
		return calendar.getTime();
	}
	
	@SuppressWarnings("unused")
	private void initCv() throws ServiceException{
		
		
		
		//Folder
		List<Folder> fldsResume = new ArrayList<>();
		List<Folder> fldsNull = null;
		
		Folder fldSamuel = new Folder();
		fldSamuel.setName("samuel");
		List<String> serverNames = new ArrayList<>();
		serverNames.add("samuel");
		fldSamuel.setServerName(serverNames);
		fldSamuel.setPath("resume/samuel/");
		folderService.save(fldSamuel);
		mapfolders.put(fldSamuel.getName(), fldSamuel);
		fldsResume.add(fldSamuel);
		
		Folder fldSurzilGeek = new Folder();
		fldSurzilGeek.setName("surzilgeek");
		serverNames = new ArrayList<>();
		serverNames.add("localhost");
		serverNames.add("127.0.0.1");
		serverNames.add("surzilgeek");
		fldSurzilGeek.setServerName(serverNames);
		fldSurzilGeek.setPath("resume/surzilgeek/");
		folderService.save(fldSurzilGeek);
		mapfolders.put(fldSurzilGeek.getName(), fldSurzilGeek);
		fldsResume.add(fldSurzilGeek);

		// Resumes
		Map<Lang, Translation> rCS = mkTranslation(new Resume("Cédric", "Sevestre", "Developper JAVA JEE", "info@cedric-sevestre.com", "+33 07 68 61 62 54", mkDate(1984, 7, 21), "903 Chemin de la croix des Banquets 84300 Cavaillon"), fldsResume, "cedricsevestre");
		Map<Lang, Translation> rJP = mkTranslation(new Resume("Justine", "Puiffe", "Project Manager", "justinepuiffe@gmail.com", "+33 06 16 03 08 84", mkDate(1990, 0, 30), "903 Chemin de la croix des Banquets 84300 Cavaillon"), fldsResume, "justinepuiffe");

		// Jobs
		Map<Lang, Translation> jWebDesigner = mkTranslation(new Job("Web Designer"), fldsResume, "webdesigner");
		Map<Lang, Translation> jDevelopper = mkTranslation(new Job("Developper"), fldsResume, "developper");

		// Skill
		Map<Lang, Translation> skPhotoshopJP = mkSkill(new Skill(SkillKind.PROGRESSBAR,"Photoshop", 80, "#f4bf00"), fldsResume, "photoshop");
		Map<Lang, Translation> skIllustratorJP = mkSkill(new Skill(SkillKind.PROGRESSBAR,"Illustrator", 75, "#f26522"), fldsResume, "illustrator");
		Map<Lang, Translation> skPHPJP = mkSkill(new Skill(SkillKind.PROGRESSBAR,"PHP", 20, "#b90162"), fldsResume, "php");
		Map<Lang, Translation> skJoomlaJP = mkSkill(new Skill(SkillKind.PROGRESSBAR,"Joomla", 35, "#ed1c24"), fldsResume, "joomla");
		Map<Lang, Translation> skHtml5Css3JP = mkSkill(new Skill(SkillKind.PROGRESSBAR,"Html 5 & CSS 3", 0, "#3c70b4"), fldsResume, "html5css3");
		Map<Lang, Translation> skWordpressJP = mkSkill(new Skill(SkillKind.PROGRESSBAR,"Wordpress", 90, "#87c05e"), fldsResume, "wordpress");
		Map<Lang, Translation> skLangEnglishJP = mkSkill(new Skill(SkillKind.CHART,"English", 100, "#f7941d"), fldsResume, "english");
		Map<Lang, Translation> skLangGermanJP = mkSkill(new Skill(SkillKind.CHART,"German", 100, "#f26522"), fldsResume, "german");
		Map<Lang, Translation> skLangSpanishJP = mkSkill(new Skill(SkillKind.CHART,"Spanish", 80, "#3c70b4"), fldsResume, "spanish");
		Map<Lang, Translation> skLangFrenchJP = mkSkill(new Skill(SkillKind.CHART,"French", 30, "#87c05e"), fldsResume, "french");
		
		// Experiences
		Map<Lang, Translation> exp2 = mkExperience(putExperienceX(new Experience("Senior Graphic Designer", "MyCompany", mkDate(2012, 07, 12), null), "2.png"), fldsResume, "exp2", jWebDesigner);
		Map<Lang, Translation> exp1 = mkExperience(putExperienceX(new Experience("Former Graphic Designer", "MyCompany", mkDate(2011, 07, 10), mkDate(2012, 06, 25)), "1.png"), fldsResume, "exp1", jDevelopper);

		// Education
		Map<Lang, Translation> ed1 = mkEducation(putEducationX(new Education("Bachelor of Art", "Montana State University", 2010), "1.png"), fldsResume, "ed1");
		Map<Lang, Translation> ed2 = mkEducation(putEducationX(new Education("University of Bristol", "Cincinnati Christian University", 2007), "2.png"), fldsResume, "ed2");
		Map<Lang, Translation> ed3 = mkEducation(putEducationX(new Education("this is a test", "Montana State University", 2005), "3.png"), fldsResume, "ed3");
		
		
		// Icons
		Icon iHome = mkIcon(new Icon("home", "flaticon-insignia", "fa fa-hand-peace-o", ""));
		Icon iResume = mkIcon(new Icon("resume", "flaticon-graduation61", "", ""));
		Icon iAboutMe = mkIcon(new Icon("aboutme", "", "fa fa-user-secret", ""));
		Icon iSkills = mkIcon(new Icon("skills", "", "fa fa-sliders", ""));
		Icon iExperiences = mkIcon(new Icon("experience", "", "fa fa-briefcase", ""));
		Icon iEducation = mkIcon(new Icon("education", "", "fa fa-leanpub", ""));
		Icon iPortfolio = mkIcon(new Icon("portfolio", "flaticon-book-bag2", "fa fa-picture-o", ""));
		Icon iContact = mkIcon(new Icon("contact", "flaticon-placeholders4", "fa fa-volume-control-phone", ""));
		Icon iFeedBack = mkIcon(new Icon("feedback", "flaticon-earphones18", "", ""));
		Icon iBlog = mkIcon(new Icon("blog", "flaticon-pens15", "fa fa-file-text-o", ""));
		Icon iSave = mkIcon(new Icon("save", "", "fa fa-floppy-o", ""));

		Icon iFacebook = mkIcon(new Icon("facebook", "", "fa fa-facebook", ""));
		Icon iTwitter = mkIcon(new Icon("twitter", "", "fa fa-twitter", ""));
		Icon iGooglePlus = mkIcon(new Icon("googlePlus", "", "fa fa-google-plus", ""));
		Icon iDribbble = mkIcon(new Icon("dribbble", "", "fa fa-dribbble", ""));
		Icon iBehance = mkIcon(new Icon("behance", "", "fa fa-behance", ""));
		Icon iGithubAlt = mkIcon(new Icon("github", "", "fa fa-github-alt", ""));

		//SocialNetworks
		Map<Lang, Translation> snFacebook = mkSocialNetwork(new SocialNetwork("Facebook", "http://myurl.com", iFacebook, 10), fldsResume, "snFacebook");
		Map<Lang, Translation> snTwitter = mkSocialNetwork(new SocialNetwork("Twitter", "http://myurl.com", iTwitter, 10), fldsResume, "snTwitter");
		Map<Lang, Translation> snGooglePlus = mkSocialNetwork(new SocialNetwork("GooglePlus", "http://myurl.com", iGooglePlus, 10), fldsResume, "snGooglePlus");
		Map<Lang, Translation> snDribbble = mkSocialNetwork(new SocialNetwork("Dribbble", "http://myurl.com", iDribbble, 10), fldsResume, "snDribbble");
		Map<Lang, Translation> snBehance = mkSocialNetwork(new SocialNetwork("Behance", "http://myurl.com", iBehance, 10), fldsResume, "snBehance");
		Map<Lang, Translation> snGithubAlt = mkSocialNetwork(new SocialNetwork("Github", "http://myurl.com", iGithubAlt, 10), fldsResume, "snGithubAlt");
	

	

		// Positions
		Map<String, Position> mapPosition = new HashMap<>();
		
		
		Position pStandardHeader = addPosition(mapPosition, "resume_standard_header");
		Position pStandardArticle = addPosition(mapPosition, "resume_standard_article");
		Position pStandardFooter = addPosition(mapPosition, "resume_standard_footer");
		
		Position pHeader = addPosition(mapPosition, "resume_header");
		Position pheaderMenu = addPosition(mapPosition, "resume_headerMenu");
		Position pNav = addPosition(mapPosition, "resume_nav");
		Position pAside = addPosition(mapPosition, "resume_aside");
		Position pMain = addPosition(mapPosition, "resume_main");
		Position pFooter = addPosition(mapPosition, "resume_footer");
		
		Position pAboutMe = addPosition(mapPosition, "resume_aboutMe");
		Position pSkills = addPosition(mapPosition, "resume_skills");
		Position pExperiences = addPosition(mapPosition, "resume_experiences");
		Position pEducation = addPosition(mapPosition, "resume_educations");
		Position pPortfolio = addPosition(mapPosition, "resume_portfolios");
		Position pBlog = addPosition(mapPosition, "resume_articles");
		Position pContact = addPosition(mapPosition, "resume_contact");
		Position pResume = addPosition(mapPosition, "resume_resume");
		
		Position pGoal = addPosition(mapPosition, "resume_goal");
		Position pDeclaration = addPosition(mapPosition, "resume_declaration");
		
		// Models
		Map<Lang, Translation> mHome = mkModel(fldsResume, "resume_model_home", "default/default");
		Map<Lang, Translation> mDefault = mkModel(fldsResume, "resume_model_default", "default/default");
		Map<Lang, Translation> mPortfolio = mkModel(fldsResume, "resume_model_portfolio", "default/default");
		Map<Lang, Translation> mArticle = mkModel(fldsResume, "resume_model_article", "default/default");
		
		// Pages
		Map<Lang, Translation> pgHome = mkPage(new Category("#1abc9c", "Home", iHome, true, 10), fldsResume, "home", "home", mHome, null);


		// Pages dédiés à l'un ou l'autre
		Map<Lang, Translation> pgResume = mkPage(new Category("#3498db", "Resume", iResume, true, 20), fldSamuel, "resume", "resume", mDefault, pgHome);
		Map<Lang, Translation> pgFeedBack = mkPage(new Category("#e74c3c", "Feedback", iFeedBack, true, 50), fldSamuel, "feedback", "feedback", mDefault, pgHome);
		
		// Pages communes aux deux modèles
		Map<Lang, Translation> pgPortfolio = mkPage(new Category("#9b59b6", "Portfolio", iPortfolio, true, 40), fldsResume, "portfolio", "portfolio", mDefault, pgHome);
		Map<Lang, Translation> pgContact = mkPage(new Category("#e67e22", "Contact", iContact, true, 30), fldsResume, "contact", "contact", mDefault, pgHome);
		Map<Lang, Translation> pgBlog = mkPage(new Category("#d9a81d", "Blog", iBlog, true, 60), fldsResume, "blog", "blog", mDefault, pgHome);
		
		Map<Lang, Translation> pgAboutMe = mkPage(putCategoryAboutMe(new Category(null, "About me", iAboutMe, true, 12)), fldSurzilGeek, "aboutme", "aboutme", mDefault, pgHome);
		Map<Lang, Translation> pgSkills = mkPage(putCategorySkills(new Category(null, "Skills", iSkills, true, 14)), fldSurzilGeek, "skills", "skills", mDefault, pgHome);
		Map<Lang, Translation> pgExperiences = mkPage(putCategoryExperience(new Category(null, "Experiences", iExperiences, true, 16)), fldSurzilGeek, "experiences", "experiences", mDefault, pgHome);
		Map<Lang, Translation> pgEducations = mkPage(putCategoryEducation(new Category(null, "Education", iEducation, true, 18)), fldSurzilGeek, "education", "education", mDefault, pgHome);
		Map<Lang, Translation> pgResumeSurzilGeek = mkPage(new Category(null, "My resume PDF", iSave, true, 70), fldSurzilGeek, "resume", "resume", mDefault, pgHome);
		
		
		
		//Pages portfolio
		Map<Lang, Translation> pgPfTest01 = mkPage(putPortfolioX(new Portfolio("Test01", "/files/resume/surzilgeek/portfolio/01.jpg" , 10)), fldsResume, "pftest01", "portfolio", mPortfolio, pgHome);
		Map<Lang, Translation> pgPfTest02 = mkPage(putPortfolioX(new Portfolio("Test02", "/files/resume/surzilgeek/portfolio/02.jpg" , 20)), fldsResume, "pftest02", "portfolio", mPortfolio, pgHome);
		Map<Lang, Translation> pgPfTest03 = mkPage(putPortfolioX(new Portfolio("Test03", "/files/resume/surzilgeek/portfolio/03.jpg" , 30)), fldsResume, "pftest03", "portfolio", mPortfolio, pgHome);
		Map<Lang, Translation> pgPfTest04 = mkPage(putPortfolioX(new Portfolio("Test04", "/files/resume/surzilgeek/portfolio/04.jpg" , 40)), fldsResume, "pftest04", "portfolio", mPortfolio, pgHome);
		Map<Lang, Translation> pgPfTest05 = mkPage(putPortfolioX(new Portfolio("Test05", "/files/resume/surzilgeek/portfolio/05.jpg" , 50)), fldsResume, "pftest05", "portfolio", mPortfolio, pgHome);
		Map<Lang, Translation> pgPfTest06 = mkPage(putPortfolioX(new Portfolio("Test06", "/files/resume/surzilgeek/portfolio/06.jpg" , 60)), fldsResume, "pftest06", "portfolio", mPortfolio, pgHome);
		Map<Lang, Translation> pgPfTest07 = mkPage(putPortfolioX(new Portfolio("Test07", "/files/resume/surzilgeek/portfolio/07.jpg" , 70)), fldsResume, "pftest07", "portfolio", mPortfolio, pgHome);
		Map<Lang, Translation> pgPfTest08 = mkPage(putPortfolioX(new Portfolio("Test08", "/files/resume/surzilgeek/portfolio/08.jpg" , 80)), fldsResume, "pftest08", "portfolio", mPortfolio, pgHome);
		Map<Lang, Translation> pgPfTest09 = mkPage(putPortfolioX(new Portfolio("Test09", "/files/resume/surzilgeek/banner.jpg" , 90)), fldsResume, "pftest09", "portfolio", mPortfolio, pgPfTest08);
		Map<Lang, Translation> pgPfTest10 = mkPage(putPortfolioX(new Portfolio("Test10", "/files/resume/surzilgeek/portfolio/10.png" , 100)), fldsResume, "pftest10", "portfolio", mPortfolio, pgPfTest09);
		
		//Pages articles
		Map<Lang, Translation> pgAtTest01 = mkPage(putArticleX(new Article("Test01", "/files/resume/surzilgeek/article/01.jpg" , 10)), fldsResume, "attest01", "article", mArticle, pgBlog);
		Map<Lang, Translation> pgAtTest02 = mkPage(putArticleX(new Article("Test02", "/files/resume/surzilgeek/article/02.jpg" , 20)), fldsResume, "attest02", "article", mArticle, pgBlog);
		Map<Lang, Translation> pgAtTest03 = mkPage(putArticleX(new Article("Test03", "/files/resume/surzilgeek/article/03.jpg" , 30)), fldsResume, "attest03", "article", mArticle, pgBlog);
		Map<Lang, Translation> pgAtTest04 = mkPage(putArticleX(new Article("Test04", "/files/resume/surzilgeek/article/04.jpg" , 40)), fldsResume, "attest04", "article", mArticle, pgBlog);
		Map<Lang, Translation> pgAtTest05 = mkPage(putArticleX(new Article("Test05", "/files/resume/surzilgeek/article/05.jpg" , 50)), fldsResume, "attest05", "article", mArticle, pgBlog);
		Map<Lang, Translation> pgAtTest06 = mkPage(putArticleX(new Article("Test06", "/files/resume/surzilgeek/article/06.jpg" , 60)), fldsResume, "attest06", "article", mArticle, pgBlog);
		Map<Lang, Translation> pgAtTest07 = mkPage(putArticleX(new Article("Test07", "/files/resume/surzilgeek/article/07.jpg" , 70)), fldsResume, "attest07", "article", mArticle, pgAtTest06);
		Map<Lang, Translation> pgAtTest08 = mkPage(putArticleX(new Article("Test08", "/files/resume/surzilgeek/article/08.jpg" , 80)), fldsResume, "attest08", "article", mArticle, pgAtTest07);

		Map<Lang, Translation> elActiveResume = mkElement(fldsResume, "resume_element_activeResume", "activeresume/activeresume");
		Map<Lang, Translation> elSocialNetwork = mkElement(fldsResume, "resume_element_socialnetwork", "socialnetwork/socialnetwork");
		
		// PageBlocks
		Map<Lang, Translation> pbHeader = mkPageBlock(fldsResume, "resume_pageblock_header", "header/header");
		Map<Lang, Translation> pbFooter = mkPageBlock(fldsResume, "resume_pageblock_footer", "footer/footer");
		Map<Lang, Translation> pbListPage = mkPageBlock(fldSurzilGeek, "resume_pageblock_listpage", "listpage/listpage");
		Map<Lang, Translation> pbAboutMe = mkPageBlock(fldsResume, "resume_pageblock_aboutme", "aboutme/aboutme");
		Map<Lang, Translation> pbSkills = mkPageBlock(fldsResume, "resume_pageblock_skills", "skills/skills");
		Map<Lang, Translation> pbExperiences = mkPageBlock(fldsResume, "resume_pageblock_experiences", "experiences/experiences");
		Map<Lang, Translation> pbEducations = mkPageBlock(fldsResume, "resume_pageblock_educations", "educations/educations");
		Map<Lang, Translation> pbPortfolio = mkPageBlock(fldsResume, "resume_pageblock_portfolio", "portfolio/portfolio");
		Map<Lang, Translation> pbContact = mkPageBlock(fldsResume, "resume_pageblock_contact", "contact/contact");
		Map<Lang, Translation> pbBlog = mkPageBlock(fldsResume, "resume_pageblock_blog", "blog/blog");
		Map<Lang, Translation> pbResume = mkPageBlock(fldsResume, "resume_pageblock_resume", "resume/resume");
		Map<Lang, Translation> pbGoal = mkPageBlock(fldsResume, "resume_pageblock_goal", "goal/goal");
		Map<Lang, Translation> pbDeclaration = mkPageBlock(fldsResume, "resume_pageblock_declaration", "declaration/declaration");
		
		Map<Lang, Translation> pbPortfolioTemplate = mkPageBlock(fldsResume, "resume_pageblock_portfolio_template", "standard/standard");
		Map<Lang, Translation> pbArticleTemplate = mkPageBlock(fldsResume, "resume_pageblock_article_template", "standard/standard");
		
		
		// Blocks
		Map<String, NType> columns = new HashMap<>();
		columns.put("text", new NType(NType.ValueType.HTML));
		Map<Lang, Translation> bParagraph = mkBlock(fldsResume, "resume_block_paragraph", "various/paragraph/paragraph", mkNSchema(columns, ScopeType.ONE));
		
		Map<Lang, Translation> bBreadbrumb = mkBlock(fldsResume, "resume_block_breadbrumb", "various/breadcrumb/breadcrumb");
		
		
		
		Map<Lang, Translation> bNav = mkBlock(fldsResume, "resume_block_nav", "nav/nav");
		
		Map<Lang, Translation> bAboutMeInfo = mkBlock(fldSurzilGeek, "resume_block_achievement", "aboutme/info");
		Map<Lang, Translation> bAchievement = mkBlock(fldSurzilGeek, "resume_block_achievement", "achievement/achievement");
		Map<Lang, Translation> bSkillsProgressBar = mkBlock(fldSurzilGeek, "resume_block_skill_progressBar_list", "skill/progressBar/list");
		Map<Lang, Translation> bSkillsChart = mkBlock(fldSurzilGeek, "resume_block_skill_chart_list", "skill/chart/list");
		Map<Lang, Translation> bExperiences = mkBlock(fldSurzilGeek, "resume_block_experience_list", "experience/list");
		Map<Lang, Translation> bEducations = mkBlock(fldSurzilGeek, "resume_block_education_list", "education/list");
		Map<Lang, Translation> bPortfolios = mkBlock(fldSurzilGeek, "resume_block_portfolio_list", "portfolio/list");
		Map<Lang, Translation> bPortfolioPicture = mkBlock(fldSurzilGeek, "resume_block_portfolio_picture", "portfolio/picture");
		Map<Lang, Translation> bBlogs = mkBlock(fldSurzilGeek, "resume_block_blog_list", "blog/list");
		Map<Lang, Translation> bBlogPicture = mkBlock(fldSurzilGeek, "resume_block_blog_picture", "blog/picture");
		Map<Lang, Translation> bContactAddress = mkBlock(fldSurzilGeek, "resume_block_contact_address", "contact/address");
		Map<Lang, Translation> bContactForm = mkBlock(fldSurzilGeek, "resume_block_contact_address", "contact/form");
		
		// Set MapTemplate
		
		// Header on model Home and Default and Portfolio - All pages model
		Map<Lang, MapTemplate> mtPbHeaderMHome = addMapTemplate(mHome, pbHeader, pHeader);
		Map<Lang, MapTemplate> mtPbHeaderMDefault = addMapTemplate(mDefault, pbHeader, pHeader);
		Map<Lang, MapTemplate> mtPbHeaderMPortfolio = addMapTemplate(mPortfolio, pbHeader, pHeader);
		Map<Lang, MapTemplate> mtPbHeaderMArticle = addMapTemplate(mArticle, pbHeader, pHeader);
		
		// Footer on model Home and Default and Portfolio - All pages model
		Map<Lang, MapTemplate> mtPbFooterMHome = addMapTemplate(mHome, pbFooter, pFooter);
		Map<Lang, MapTemplate> mtPbFooterMDefault = addMapTemplate(mDefault, pbFooter, pFooter);
		Map<Lang, MapTemplate> mtPbFooterMPortfolio = addMapTemplate(mPortfolio, pbFooter, pFooter);
		Map<Lang, MapTemplate> mtPbFooterMArticle = addMapTemplate(mArticle, pbFooter, pFooter);
		
		// Nav on model Home and Default and pb Header and Portfolio and Blog - All pages model
		Map<Lang, MapTemplate> mtBNavMHome = addMapTemplate(mHome, bNav, pNav);
		Map<Lang, MapTemplate> mtBNavMDefault = addMapTemplate(mDefault, bNav, pNav);
		Map<Lang, MapTemplate> mtBNavpbHeader = addMapTemplate(pbHeader, bNav, pNav);
		Map<Lang, MapTemplate> mtBNavMPortfolio = addMapTemplate(mPortfolio, bNav, pNav);
		Map<Lang, MapTemplate> mtBNavMArticle = addMapTemplate(mArticle, bNav, pNav);
		
		// Breadcrumb on model Default and Portfolio - All pages model
		Map<Lang, MapTemplate> mtBBreadcrumbMDefault = addMapTemplate(mDefault, bBreadbrumb, pHeader);
		Map<Lang, MapTemplate> mtBBreadcrumbMPortfolio = addMapTemplate(mPortfolio, bBreadbrumb, pHeader);
		Map<Lang, MapTemplate> mtBBreadcrumbMArticle = addMapTemplate(mArticle, bBreadbrumb, pHeader);
		
		// PortfolioTemplate on model Portfolio - All pages model
		Map<Lang, MapTemplate> mtPBPortfolioTemplateMPortfolio = addMapTemplate(mPortfolio, pbPortfolioTemplate, pMain);
		Map<Lang, MapTemplate> mtBPortfolioPicturePbPortfolioTemplate = addMapTemplate(pbPortfolioTemplate, bPortfolioPicture, pStandardHeader);
		Map<Lang, MapTemplate> mtBParagraphPbPortfolioTemplate = addMapTemplate(pbPortfolioTemplate, bParagraph, pStandardArticle);
		NData nData = new NData();
		nData.setvHtml("<h2>Others portfolios</h2>");
		nData.setVarType(ValueType.HTML);
		nData.setPropertyName("paragraph");
		nData.setMapTemplate(mtBParagraphPbPortfolioTemplate.get(langEN));
		nDataService.save(nData);
		Map<Lang, MapTemplate> mtBPortfoliosPbPortfolioTemplate = addMapTemplate(pbPortfolioTemplate, bPortfolios, pStandardArticle);
		
		// PortfolioTemplate on model Portfolio - All pages model
		Map<Lang, MapTemplate> mtPBArticleTemplateMArticle = addMapTemplate(mArticle, pbArticleTemplate, pMain);
		Map<Lang, MapTemplate> mtBBlogPicturePbArticleTemplate = addMapTemplate(pbArticleTemplate, bBlogPicture, pStandardHeader);

		// BlogTemplate on model Blog - All pages model
		Map<Lang, MapTemplate> mtBlogTemplateMBlog = addMapTemplate(mArticle, pbArticleTemplate, pMain);
		
		
		// Listpage on page Home for folder SurzilGeek only
		Map<Lang, MapTemplate> mtPgHomeSurzilGeek = addMapTemplate(mHome, pbListPage, pMain);
		
		// blocks on pages
		Map<Lang, MapTemplate> mtPbAboutmePgAboutMe = addMapTemplate(pgAboutMe, pbAboutMe, pMain);
		Map<Lang, MapTemplate> mtPbAboutInfoPgAboutMe = addMapTemplate(pbAboutMe, bAboutMeInfo, pAboutMe);
		Map<Lang, MapTemplate> mtPbAchievementPgAboutMe = addMapTemplate(pbAboutMe, bAchievement, pAboutMe);
		
		Map<Lang, MapTemplate> mtPbSkillsPgSkills = addMapTemplate(pgSkills, pbSkills, pMain);
		Map<Lang, MapTemplate> mtBSkillsProgressBarPgSkills = addMapTemplate(pbSkills, bSkillsProgressBar, pSkills);
		Map<Lang, MapTemplate> mtBSkillsChartPgSkills = addMapTemplate(pbSkills, bSkillsChart, pSkills);
		
		Map<Lang, MapTemplate> mtPbExperiencesPgExperiences = addMapTemplate(pgExperiences, pbExperiences, pMain);
		Map<Lang, MapTemplate> mtBExperiencesPgExperiences = addMapTemplate(pbExperiences, bExperiences, pExperiences);
		
		Map<Lang, MapTemplate> mtPbEducationsPgEducations = addMapTemplate(pgEducations, pbEducations, pMain);
		Map<Lang, MapTemplate> mtBEducationsPgEducations = addMapTemplate(pbEducations, bEducations, pEducation);

		Map<Lang, MapTemplate> mtPbPortfolioPgPortfolio = addMapTemplate(pgPortfolio, pbPortfolio, pMain);
		Map<Lang, MapTemplate> mtBPortfoliosPgPortfolios = addMapTemplate(pbPortfolio, bPortfolios, pPortfolio);

		Map<Lang, MapTemplate> mtPbContactPgContact = addMapTemplate(pgContact, pbContact, pMain);
		Map<Lang, MapTemplate> mtBContactAddressPgContact = addMapTemplate(pbContact, bContactAddress, pContact);
		Map<Lang, MapTemplate> mtBContactFormPgContact = addMapTemplate(pbContact, bContactForm, pContact);
		
		Map<Lang, MapTemplate> mtPbBlogPgBlog = addMapTemplate(pgBlog, pbBlog, pMain);
		Map<Lang, MapTemplate> mtBBlogsPgBlog = addMapTemplate(pbBlog, bBlogs, pBlog);
		
		Map<Lang, MapTemplate> mtPbResumePgResume = addMapTemplate(pgResumeSurzilGeek, pbResume, pMain);
		Map<Lang, MapTemplate> mtBAboutMeInfoPgResume = addMapTemplate(pbResume, bAboutMeInfo, pResume);
		Map<Lang, MapTemplate> mtPbGoalPgResume = addMapTemplate(pbResume, pbGoal, pResume);
		Map<Lang, MapTemplate> mtBExperiencesPgResume = addMapTemplate(pbResume, bExperiences, pResume);
		Map<Lang, MapTemplate> mtBEducationsPgResume = addMapTemplate(pbResume, bEducations, pResume);
		Map<Lang, MapTemplate> mtBSkillsChartPgResume = addMapTemplate(pbResume, bSkillsChart, pResume);
		Map<Lang, MapTemplate> mtBSkillsProgressPgResume = addMapTemplate(pbResume, bSkillsProgressBar, pResume);
		
		Map<Lang, MapTemplate> mtBPortfoliosPgResume = addMapTemplate(pbResume, bPortfolios, pResume);
		Map<Lang, MapTemplate> mtPbDeclarationPgResume = addMapTemplate(pbResume, pbDeclaration, pResume);
	}
	
	private Page putCategoryAboutMe(Page page){
		String description = "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>";
		page.setDescription(description);
		return page;
	}
	private Page putCategoryExperience(Page page){
		String description = "<h3>15 Years Exprience</h3><p>Lorem ipsum onsectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad onsectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad onsectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad , tempor incididunt ut labore. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>";
		page.setDescription(description);
		return page;
	}
	private Page putCategorySkills(Page page){
		String description = "<h3>This is SKILLS !!!!!</h3><p>Lorem ipsum onsectetur adipisicing elitenim ad, tempor incididunt ut labore. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>";
		page.setDescription(description);
		return page;
	}
	private Page putCategoryEducation(Page page){
		String description = "<h3>Just My Educational Background</h3><p>Lorem ipsum onsectetur adipisicing elit, sed do eiusmod tod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad onsectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad , tempor incididunt ut labore. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>";
		page.setDescription(description);
		return page;
	}
	
	
	
	
	private Experience putExperienceX(Experience exp, String img){
		exp.setDescription("<h3>this is the title youpi !</h3><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>");
		exp.setChapo("<p>Lorem ipsum dolor sit ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>");
		exp.setPicture("/files/resume/surzilgeek/experiences/" + img);
		return exp;
	}
	private Education putEducationX(Education ed, String img){
		ed.setDescription("<h3>this is the title youpi !</h3><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>");
		ed.setChapo("<p>Lorem ipsum dolor sit ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>");
		ed.setPicture("/files/resume/surzilgeek/education/" + img);
		return ed;
	}
	private Portfolio putPortfolioX(Portfolio pf){
		pf.setDescription("<h2>Lorem ipsum dolor sit amet</h2><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse pretium varius mauris, nec ornare lacus. Suspendisse potenti. Morbi non dignissim lectus. Vivamus ipsum leo, pulvinar id posuere a, ullamcorper eget ipsum. In eget mauris lorem. Phasellus dolor mauris, sagittis vitae mauris eu, dignissim blandit quam. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut gravida sit amet elit quis tempus. Integer dictum est id tempus tempus. In quis pulvinar lorem.</p><p>Integer eleifend venenatis justo, ut pulvinar dolor scelerisque auctor. Suspendisse potenti. Sed ipsum felis, fermentum vel quam ac, congue eleifend enim. Quisque rhoncus, nisi at rhoncus mattis, magna eros dictum eros, quis viverra metus libero nec felis. Fusce accumsan vulputate ullamcorper. Etiam sodales tortor ac odio elementum ornare. Etiam a congue metus. Nulla sed dui fringilla, accumsan nunc a, fringilla tellus. Phasellus vel mi lobortis, pellentesque risus sit amet, consequat lacus. Phasellus ac mattis lectus, id commodo urna. Etiam quis aliquet ante. Vestibulum mattis sollicitudin diam ut facilisis. Pellentesque libero nunc, feugiat non commodo et, mattis eu nibh. Suspendisse consequat tristique sapien, non consequat sem imperdiet placerat. Nunc vitae ante erat.</p><h2>Integer a nunc sit amet mauris sollicitudin imperdiet</h2><p>Etiam lectus enim, faucibus eget augue vitae, tristique rutrum elit. Integer a nunc sit amet mauris sollicitudin imperdiet. Fusce venenatis, mauris id egestas pellentesque, dolor quam vehicula lorem, sit amet tempus metus nisi ultricies urna. Nunc porttitor erat vel nulla sagittis porta. Sed ac varius ligula. Donec interdum, metus sit amet aliquam faucibus, quam lectus maximus mi, nec vehicula libero nunc ac leo. Aliquam ornare eu diam eget consectetur. Ut non fermentum tortor. Sed varius massa at iaculis dignissim. Curabitur a varius libero. Proin ullamcorper nibh elementum neque feugiat, et tincidunt nulla laoreet. Nulla lacinia ullamcorper tellus vitae ullamcorper. Phasellus odio arcu, ullamcorper non porttitor sit amet, dictum quis leo. Suspendisse risus urna, vestibulum in suscipit vitae, tincidunt non leo.</p><p>Integer eget purus non tortor venenatis maximus. Vestibulum vitae tristique neque. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque tempor fringilla nibh cursus consequat. Suspendisse id suscipit quam. Ut velit massa, facilisis mattis tellus id, mattis accumsan leo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Maecenas non dui nisl. Aenean commodo malesuada velit in dictum. Proin commodo quis ipsum a euismod. Donec consectetur purus vitae dictum auctor. Praesent quis elementum velit, in dapibus velit.</p><p>Nam ac condimentum nisi, vel accumsan tortor. Mauris lacus orci, posuere in dictum quis, tristique non lacus. Ut non pellentesque nulla. Praesent vulputate tortor in velit accumsan, at faucibus risus auctor. Integer vitae tempor felis. Etiam interdum, velit eget rutrum molestie, lacus lorem tempor odio, quis placerat est ligula ac ex. Suspendisse sit amet ultricies sapien. Fusce consectetur non leo vel fermentum. Suspendisse fringilla neque scelerisque semper volutpat. In efficitur, mi at semper porttitor, elit arcu condimentum metus, quis tempus ipsum felis at eros. Duis aliquam auctor sem, non tristique dolor pellentesque ac. Phasellus et libero eget lacus viverra iaculis nec sit amet diam. Sed vel sodales metus. In ut felis lacus.</p>");
		pf.setChapo("<p>Lorem ipsum dolor</p>");
		return pf;
	}
	private Article putArticleX(Article at){
		at.setDescription("<h2>Lorem ipsum dolor sit amet</h2><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse pretium varius mauris, nec ornare lacus. Suspendisse potenti. Morbi non dignissim lectus. Vivamus ipsum leo, pulvinar id posuere a, ullamcorper eget ipsum. In eget mauris lorem. Phasellus dolor mauris, sagittis vitae mauris eu, dignissim blandit quam. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut gravida sit amet elit quis tempus. Integer dictum est id tempus tempus. In quis pulvinar lorem.</p><p>Integer eleifend venenatis justo, ut pulvinar dolor scelerisque auctor. Suspendisse potenti. Sed ipsum felis, fermentum vel quam ac, congue eleifend enim. Quisque rhoncus, nisi at rhoncus mattis, magna eros dictum eros, quis viverra metus libero nec felis. Fusce accumsan vulputate ullamcorper. Etiam sodales tortor ac odio elementum ornare. Etiam a congue metus. Nulla sed dui fringilla, accumsan nunc a, fringilla tellus. Phasellus vel mi lobortis, pellentesque risus sit amet, consequat lacus. Phasellus ac mattis lectus, id commodo urna. Etiam quis aliquet ante. Vestibulum mattis sollicitudin diam ut facilisis. Pellentesque libero nunc, feugiat non commodo et, mattis eu nibh. Suspendisse consequat tristique sapien, non consequat sem imperdiet placerat. Nunc vitae ante erat.</p><h2>Integer a nunc sit amet mauris sollicitudin imperdiet</h2><p>Etiam lectus enim, faucibus eget augue vitae, tristique rutrum elit. Integer a nunc sit amet mauris sollicitudin imperdiet. Fusce venenatis, mauris id egestas pellentesque, dolor quam vehicula lorem, sit amet tempus metus nisi ultricies urna. Nunc porttitor erat vel nulla sagittis porta. Sed ac varius ligula. Donec interdum, metus sit amet aliquam faucibus, quam lectus maximus mi, nec vehicula libero nunc ac leo. Aliquam ornare eu diam eget consectetur. Ut non fermentum tortor. Sed varius massa at iaculis dignissim. Curabitur a varius libero. Proin ullamcorper nibh elementum neque feugiat, et tincidunt nulla laoreet. Nulla lacinia ullamcorper tellus vitae ullamcorper. Phasellus odio arcu, ullamcorper non porttitor sit amet, dictum quis leo. Suspendisse risus urna, vestibulum in suscipit vitae, tincidunt non leo.</p><p>Integer eget purus non tortor venenatis maximus. Vestibulum vitae tristique neque. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque tempor fringilla nibh cursus consequat. Suspendisse id suscipit quam. Ut velit massa, facilisis mattis tellus id, mattis accumsan leo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Maecenas non dui nisl. Aenean commodo malesuada velit in dictum. Proin commodo quis ipsum a euismod. Donec consectetur purus vitae dictum auctor. Praesent quis elementum velit, in dapibus velit.</p><p>Nam ac condimentum nisi, vel accumsan tortor. Mauris lacus orci, posuere in dictum quis, tristique non lacus. Ut non pellentesque nulla. Praesent vulputate tortor in velit accumsan, at faucibus risus auctor. Integer vitae tempor felis. Etiam interdum, velit eget rutrum molestie, lacus lorem tempor odio, quis placerat est ligula ac ex. Suspendisse sit amet ultricies sapien. Fusce consectetur non leo vel fermentum. Suspendisse fringilla neque scelerisque semper volutpat. In efficitur, mi at semper porttitor, elit arcu condimentum metus, quis tempus ipsum felis at eros. Duis aliquam auctor sem, non tristique dolor pellentesque ac. Phasellus et libero eget lacus viverra iaculis nec sit amet diam. Sed vel sodales metus. In ut felis lacus.</p>");
		at.setChapo("<p>Lorem ipsum dolor sit ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>");
		return at;
	}
	
	
	
	
	
	
}
