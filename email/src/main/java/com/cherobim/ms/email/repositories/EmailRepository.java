package com.cherobim.ms.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cherobim.ms.email.model.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
