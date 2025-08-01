package com.fatmakara.services.impl;

import com.fatmakara.entities.Team;
import com.fatmakara.repository.TeamRepository;
import com.fatmakara.services.ITeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements ITeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Integer id) {
        Optional<Team> optional = teamRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteTeam(Integer id) {
        Team dbTeam = getTeamById(id);
        if (dbTeam != null) {
            teamRepository.delete(dbTeam);
        }
    }

    @Override
    public Team updateTeam(Integer id, Team updatedTeam) {
        Team dbTeam = getTeamById(id);
        if (dbTeam != null) {
            dbTeam.setName(updatedTeam.getName());
            return teamRepository.save(dbTeam);
        }
        throw new RuntimeException("Takım bulunamadı. ID: " + id);
    }
}
