package springbootsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springbootsecurity.model.entity.Note;
import springbootsecurity.model.service.NoteService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getListOfNotes() {
        return new ModelAndView("list")
                .addObject("notes", noteService.listAll());
    }

    @PostMapping("/delete")
    public ModelAndView deleteNoteById(@RequestParam long id) {
        noteService.deleteById(id);
        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping("/edit")
    public ModelAndView showEditPage(@RequestParam("id") long id) {
        return new ModelAndView("edit")
                .addObject("note", noteService.getById(id));
    }

    @PostMapping("/edit")
    public ModelAndView editNote(@ModelAttribute Note note)  {
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("create");
    }

    @PostMapping("/create")
    public ModelAndView createNote(@ModelAttribute Note note)  {
        noteService.add(note);
        return new ModelAndView("redirect:/note/list");
    }
}
