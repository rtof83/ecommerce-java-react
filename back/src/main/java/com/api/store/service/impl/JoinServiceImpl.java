package com.api.store.service.impl;

import com.api.store.model.Join;
import com.api.store.repository.JoinRepository;
import com.api.store.service.JoinService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinServiceImpl implements JoinService {

    private JoinRepository joinRepository;

    public JoinServiceImpl(JoinRepository joinRepository) {
        this.joinRepository = joinRepository;
    }

    @Override
    public List<Join> getJoin() { return joinRepository.getJoin(); }
}
