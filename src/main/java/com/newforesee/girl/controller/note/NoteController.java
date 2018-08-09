package com.newforesee.girl.controller.note;

import com.newforesee.girl.daomain.Notes;
import com.newforesee.girl.daomain.Result;
import com.newforesee.girl.repository.NoteRepository;
import com.newforesee.girl.service.note.NoteService;
import com.newforesee.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by newforesee on 2018/8/9.
 */
@RestController
@CrossOrigin
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteService noteService;

    @PostMapping(value = "/noteadd")
    public Result noteAdd(@Valid Notes note, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //return null;
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());

        }
        return ResultUtil.success(noteService.noteAdd(note));
    }

    @PostMapping(value = "/noteslist")
    public Result<List<Notes>> noteslist(@RequestParam("userid") Integer userid){
        return ResultUtil.success(noteService.notesListByuserid(userid));
    }

    @PostMapping("/dropnote")
    public Result<Notes> dropNote(@RequestParam("id") Integer id){

        return ResultUtil.success(noteService.dropNote(id));
    }






}
