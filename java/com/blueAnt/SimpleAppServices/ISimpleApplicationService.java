package com.blueAnt.SimpleAppServices;

import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public interface ISimpleApplicationService {

	 JdbcTemplate fetchTemplate();
	 Session session();
}
