package org.neutrinocms.resume.service;

import org.neutrinocms.core.bo.annotation.CustomService;
import org.neutrinocms.core.service.UserService;
import org.neutrinocms.resume.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@CustomService
public class MemberService extends UserService{
	
}
