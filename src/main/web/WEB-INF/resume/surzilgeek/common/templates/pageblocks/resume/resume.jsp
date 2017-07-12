<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="my" uri="/WEB-INF/taglibs/neutrino.tld"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<my:init test="${!initialized}"/>
           
<div id="profile" class="profile-section section-padding">
    <div class="container">
        <div class="row">
            <div class="col-sm-8">
                <div class="section-content"> 
   					<my:block position="resume_resume" />
                </div>
                <div class="button">
                    <a href="cv.pdf" class="btn btn-primary">Download My Resume as a .pdf file</a>
                </div>
            </div>
        </div><!-- row -->
    </div><!-- container -->
</div><!-- profile section -->	
           
           
           
           
<%--
            
        <div id="profile" class="profile-section section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8">
                        <div class="section-content">
                            <div class="profile-logo">
                                <img class="img-responsive" src="<c:url value='/resources/src/resume/surzilgeek/images/profile.jpg'/>" alt="Image">
                            </div>
                            <div class="profile-info">
                                <h1>${resumeFirstName} ${resumeLastName}</h1>
                                <h4>${resumeFunction}</h4>
                                <address>
                                    <p>${resumeAddress}<br> Phone: ${resumePhone} <br> <a href="#">Email: ${resumeEmail}</a></p>
                                </address>
                            </div><!-- profile info -->
                            <div class="career-objective">
                                <div class="title">
                                    <div class="icons">
                                        <i class="fa fa-black-tie" aria-hidden="true"></i>
                                    </div>                                    
                                    <h3>Career Objective</h3>
                               </div> 
                                <div class="sub-content">
                                    <p>${resumeDescription}</p>
                                </div>
                            </div><!-- career objective -->
                            <hr>
                            <div class="work-history">
                                <div class="title">
                                    <div class="icons">
                                        <i class="fa fa-briefcase" aria-hidden="true"></i>
                                    </div>                                    
                                    <h3>Work History</h3>
                                </div>
                                <div class="sub-content">
                                    <div class="history">
                                        <h5>Senior Graphic Designer @ Buildomo</h5>
                                        <h6>2012 - Present</h6>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                    </div>
                                    <hr>
                                    <div class="history">
                                        <h5>Former Graphic Designer @ Ideame</h5>
                                        <h6>2011 - 2012</h6>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                    </div>
                                    <hr>
                                    <div class="history">
                                        <h5>Head of Design @ Titan Compnay</h5>
                                        <h6>2005 - 2011</h6>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                    </div>
                                    <hr>
                                    <div class="history">
                                        <h5>Graphic Designer @ Precision</h5>
                                        <h6>2004 - 2005</h6>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                    </div>
                                    <hr>
                                    <div class="history">
                                        <h5>Graphic Designer (Intern) @ Costa Rica Fruit Compnay</h5>
                                        <h6>2002 - 2004</h6>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                    </div>
                                </div>
                            </div><!-- work history -->
                            <hr> 
                            <div class="educational-background">
                                <div class="title">
                                    <div class="icons">
                                        <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                                    </div>                                    
                                    <h3>Educational Background</h3>                                    
                                </div>
                                <div class="sub-content">
                                    <div class="education">
                                        <h5>Masters of Arts @ Montana Satet University</h5>
                                        <p>1999 - 2001</p>
                                    </div>
                                    <hr>
                                    <div class="education">
                                        <h5>Bachalor of Arts @ Universty of Bristol</h5>
                                        <p>1995 - 1999</p>
                                    </div>
                                    <hr>
                                    <div class="education">
                                        <h5>Diploma in Graphics Design @ Cincinnati Christian University</h5>
                                        <p>1993 - 1995</p>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="language-proficiency">
                                <div class="title">
                                    <div class="icons">
                                        <i class="fa fa-language" aria-hidden="true"></i>
                                    </div>                                  
                                    <h3>Language Proficiency</h3>
                                </div>
                                <div class="sub-content">
                                    <ul class="list-inline">
                                        <li>
                                            <h5>English</h5>
                                            <ul>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <h5>German</h5>
                                            <ul>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <h5>Sh5anish</h5>
                                            <ul>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <h5>Latin</h5>
                                            <ul>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <hr>
                            <div class="expertise">
                                <div class="title">
                                    <div class="icons">
                                        <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
                                    </div>                                  
                                    <h3>Expertise</h3>
                                </div>                            
                                <div class="sub-content">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="rating-bar">
                                                <label>Photoshop</label>
                                                <div class="skill-progress">
                                                    <div class="progress">
                                                        <div class="progress-bar" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" >
                                                        </div>
                                                    </div>
                                                </div>
                                                <label>WordPress</label>
                                                <div class="skill-progress">
                                                    <div class="progress">
                                                        <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" >
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>                                
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="skill rating-bar">
                                                <label>Illustrator</label>
                                                <div class="skill-progress">
                                                    <div class="progress">
                                                        <div class="progress-bar" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" >
                                                        </div>
                                                    </div>
                                                </div>
                                                <label>Joomla</label>
                                                <div class="skill-progress">
                                                    <div class="progress">
                                                        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" >
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>                                
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="skill rating-bar">
                                                <label>Html 5 & CSS 3</label>
                                                <div class="skill-progress">
                                                    <div class="progress">
                                                        <div class="progress-bar" role="progressbar" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100" >
                                                        </div>
                                                    </div>
                                                </div>
                                                <label>PHP</label>
                                                <div class="skill-progress">
                                                    <div class="progress">
                                                        <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" >
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>                                
                                        </div>
                                    </div><!-- row -->                                    
                                </div>
                            </div><!-- expertise -->
                            <hr>
                            <div class="personal-info">
                                <div class="title">
                                    <div class="icons">
                                        <i class="fa fa-user-secret" aria-hidden="true"></i>
                                    </div>                                  
                                    <h3>Personal Info</h3>
                                </div>  
                                <div class="sub-content">
                                    <ul class="address">
                                        <li><h5>Full Name </h5> <span>:</span>Surzil Geek</li>
                                        <li><h5>Father's Name </h5> <span>:</span>Robert Geek</li>
                                        <li><h5>Mother's Name </h5> <span>:</span>Ismatic Roderos Geek</li>
                                        <li><h5>Date of Birth </h5> <span>:</span>26/01/1982</li>
                                        <li><h5>Birth Place </h5> <span>:</span>United State of America</li>
                                        <li><h5>Nationality </h5> <span>:</span>Canadian</li>
                                        <li><h5>Sex </h5> <span>:</span>Male</li>
                                        <li><h5>Address </h5> <span>:</span>121 King Street, Melbourne Victoria</li>
                                    </ul>
                                </div>                                
                            </div><!-- personal info -->
                            <hr>
                            <div class="portfolio">
                                <div class="title">
                                    <div class="icons">
                                        <i class="fa fa-picture-o" aria-hidden="true"></i>
                                    </div>                                  
                                    <h3>Portfolio</h3>
                                </div> 
                                <div class="sub-content">
                                    <ul>
                                        <li><h5>Dribbble </h5> <span>:</span><a href="#">dribbble.com/geek</a></li>
                                        <li><h5>Website </h5> <span>:</span><a href="#">www.surzilgeek.com/portfolio</a></li>
                                        <li><h5>Flicker </h5> <span>:</span><a href="#">www.flicker.com/geek-photography</a></li>
                                        <li><h5>Behance </h5> <span>:</span><a href="#">www.behance.com/geekin</a></li>
                                    </ul>                                    
                                </div>                                
                            </div><!-- portfolio -->
                            <hr>
                            <div class="declaration">
                                <div class="title">
                                    <div class="icons">
                                        <i class="fa fa-hand-peace-o" aria-hidden="true"></i>
                                    </div>                                  
                                    <h3>Declaration</h3>
                                </div>
                                <div class="sub-content">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </p>
                                    <div class="signature">
                                        <h1>Surzil Geek</h1>
                                    </div>                                    
                                </div>                                 
                            </div>
                        </div>
                        <div class="button">
                            <a href="cv.pdf" class="btn btn-primary">Download My Resume as a .pdf file</a>
                        </div>
                    </div>
                </div><!-- row -->
            </div><!-- container -->
        </div><!-- profile section -->		
        
        
        
 --%>