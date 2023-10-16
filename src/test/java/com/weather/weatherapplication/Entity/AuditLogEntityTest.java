package com.weather.weatherapplication.Entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.weather.weatherapplication.entity.AuditLog;



@SpringBootTest
public class AuditLogEntityTest {

	  
	    @Test
	    public void testAuditLogEntity() {
	        // Create a new AuditLog instance
	        AuditLog auditLog = new AuditLog();
	        auditLog.setId(1);
	        auditLog.setAction("Create");
            auditLog.setStatus(200);
	        auditLog.setErrorCode("TestErrorCode");
	        auditLog.setResponseBody("TestResponseBody");
	        auditLog.setErrorMessage("TestErrorMessage");
	        auditLog.setCreatedAt(new Timestamp(System.currentTimeMillis()));
	        auditLog.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
	        auditLog.setCreatedBy("User");
	        auditLog.setUpdatedBy("User");

	       assertEquals(1, auditLog.getId());
	        assertEquals("Create", auditLog.getAction());
	     assertEquals(Integer.valueOf(200), auditLog.getStatus());
	        assertEquals("TestErrorCode", auditLog.getErrorCode());
	        assertEquals("TestResponseBody", auditLog.getResponseBody());
	        assertEquals("TestErrorMessage", auditLog.getErrorMessage());
	        assertNotNull(auditLog.getCreatedAt());
	        assertNotNull(auditLog.getUpdatedAt());
	        assertEquals("User", auditLog.getCreatedBy());
	        assertEquals("User", auditLog.getUpdatedBy());
	    }
	
	@Test
	public void testAuditLogConstructtor() {
		
		 Integer id = 1;
	        String action = "Create";
	        Integer status = 200;
	        String errorCode = "NO_ERROR";
	        Object responseBody = "Success";
	        String errorMessage = null;
	        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
	        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
	        String createdBy = "User1";
	        String updatedBy = "User2";

	        AuditLog auditLog = new AuditLog(id, action, status, errorCode, responseBody,
	                errorMessage, createdAt, updatedAt, createdBy, updatedBy);

	        assertEquals(id, auditLog.getId());
	        assertEquals(action, auditLog.getAction());
	        assertEquals(status, auditLog.getStatus());
	        assertEquals(errorCode, auditLog.getErrorCode());
	        assertEquals(responseBody, auditLog.getResponseBody());
	        assertEquals(errorMessage, auditLog.getErrorMessage());
	        assertEquals(createdAt, auditLog.getCreatedAt());
	        assertEquals(updatedAt, auditLog.getUpdatedAt());
	        assertEquals(createdBy, auditLog.getCreatedBy());
	        assertEquals(updatedBy, auditLog.getUpdatedBy());
	    }

	

	
	}

	

