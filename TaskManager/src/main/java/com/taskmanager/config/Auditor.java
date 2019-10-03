package com.taskmanager.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/**
 * 
 * @author Ambuj
 *
 */
public class Auditor implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("SYSTEM");
	}

}
