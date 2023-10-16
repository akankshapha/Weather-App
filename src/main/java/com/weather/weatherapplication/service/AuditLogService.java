package com.weather.weatherapplication.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.weatherapplication.dao.AuditLogRepository;
import com.weather.weatherapplication.entity.AuditLog;

@Service
public class AuditLogService {

	@Autowired
	AuditLogRepository  auditlogRepo;
	public void logAudit(AuditLog auditlog) {     
		
		auditlogRepo.save(auditlog);
		
	}
}
