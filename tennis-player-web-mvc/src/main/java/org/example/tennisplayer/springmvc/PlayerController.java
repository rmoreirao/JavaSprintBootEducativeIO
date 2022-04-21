package org.example.tennisplayer.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayerController {
    @Autowired
    PlayerService service;

    //method to handle /showPlayerForm
    @RequestMapping("/showPlayerForm")
    public String showForm () {
        return "search-player-form";
    }

    //method to handle /processPlayerForm
    @RequestMapping("/processPlayerForm")
    public String processForm(HttpServletRequest request, Model model) {
        String pName = request.getParameter("playerName");
        Player player = service.getPlayerByName(pName);
        model.addAttribute("name", pName);
        model.addAttribute("country", player.getNationality());
        model.addAttribute("dob", player.getBirthDate());
        model.addAttribute("titles", player.getTitles());
        return "player-detail";
    }
}
