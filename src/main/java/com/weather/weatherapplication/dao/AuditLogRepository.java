package com.weather.weatherapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weather.weatherapplication.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {

}
