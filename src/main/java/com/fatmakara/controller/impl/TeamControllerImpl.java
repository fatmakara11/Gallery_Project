package com.fatmakara.controller.impl;

import com.fatmakara.controller.ITeamController;
import com.fatmakara.entities.Team;
import com.fatmakara.services.ITeamService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "http://localhost:4200")  // Angular frontend için CORS
public class TeamControllerImpl implements ITeamController {

    private final ITeamService teamService;

    public TeamControllerImpl(ITeamService teamService) {
        this.teamService = teamService;
    }

    // Yeni ekip oluştur
    @PostMapping
    public Team saveTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }

    // Tüm ekipleri listele
    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // ID'ye göre ekip getir
    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Integer id) {
        return teamService.getTeamById(id);
    }

    // Ekip güncelle
    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Integer id, @RequestBody Team updatedTeam) {
        return teamService.updateTeam(id, updatedTeam);
    }
    // Ekip sil
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Integer id) {
        teamService.deleteTeam(id);
    }
    @DeleteMapping("/{teamId}/employees/{employeeId}")
    public void removeEmployeeFromTeam(@PathVariable Integer teamId, @PathVariable Integer employeeId) {
        teamService.removeEmployeeFromTeam(teamId, employeeId);
    }
}


