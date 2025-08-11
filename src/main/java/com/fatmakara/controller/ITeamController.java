package com.fatmakara.controller;

import com.fatmakara.entities.Team;
import java.util.List;

public interface ITeamController {
    Team saveTeam(Team team);
    List<Team> getAllTeams();
    Team getTeamById(Integer id);
    void deleteTeam(Integer id);
    Team updateTeam(Integer id, Team updatedTeam);
    void removeEmployeeFromTeam(Integer teamId, Integer employeeId);

}
