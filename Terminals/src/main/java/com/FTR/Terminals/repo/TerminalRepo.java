package com.FTR.Terminals.repo;

import java.util.List;

import com.FTR.Terminals.model.Terminal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminalRepo extends JpaRepository<Terminal, String> {
    public List<Terminal> findByItemType(String itemType);
}
