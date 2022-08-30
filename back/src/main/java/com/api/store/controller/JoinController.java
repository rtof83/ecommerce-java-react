package com.api.store.controller;

import com.api.store.model.Join;
import com.api.store.service.JoinService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/join")
public class JoinController {
    private JoinService joinService;

    public JoinController(JoinService joinService) {
        super();
        this.joinService = joinService;
    }

    // build get join customer
    @GetMapping()
    public List<Join> getJoin() {
        return joinService.getJoin();
    }
}
