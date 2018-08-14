package com.newforesee.girl.controller.note;

import com.newforesee.girl.daomain.Notes;
import com.newforesee.girl.daomain.Result;
import com.newforesee.girl.repository.NoteRepository;
import com.newforesee.girl.service.note.NoteService;
import com.newforesee.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 添加一条笔记
     * @param note
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/noteadd")
    public Result noteAdd(@Valid @RequestBody Notes note, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //return null;
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());

        }
        return ResultUtil.success(noteService.noteAdd(note));
    }

    /**
     * 查询当前用户指定状态的笔记
     * @param userid
     * @return
     */
    @PostMapping(value = "/noteslist")
    public Result<List<Notes>> noteslist(@RequestParam("userid") Integer userid ,@RequestParam("statusid") Integer statusid){
        return ResultUtil.success(noteService.notesListByUseridAndStatus(userid,statusid));
    }

    /**
     * 删除一条笔记(放入回收站)
     * @param id
     * @return
     */
    @PostMapping("/dropnote")
    public Result<Notes> dropNote(@RequestParam("id") Integer id){

        return ResultUtil.success(noteService.dropNote(id));
    }

    /**
     * 根据id查看一条笔记
     * @param id
     * @return
     */
    @PostMapping("/notefindone")
    public Result<Notes> findOne(@RequestParam("id") Integer id){

        return ResultUtil.success(noteRepository.findOne(id));
    }







}
