package com.example.test.service;

import com.example.test.model.Demo;
import com.example.test.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface DemoService extends IGeneralService<Demo>{
    Page<Demo> findAll(Pageable pageable);
}
