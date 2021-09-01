package com.codegym.controller;

import com.codegym.dto.SongDto;
import com.codegym.model.entity.Song;
import com.codegym.model.service.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/song")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("")
    public ModelAndView showList() {
        List<Song> list = songService.findAll();
        return new ModelAndView("list", "songs", list);
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("create", "songDto", new SongDto());
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.songService.save(song);
        redirectAttributes.addFlashAttribute("status", "Tạo mới thành công!");
        return "redirect:/song";
    }

}
