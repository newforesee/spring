package com.newforesee.girl.service.note;

import com.newforesee.girl.daomain.Notes;
import com.newforesee.girl.enums.NoteStatusEnum;
import com.newforesee.girl.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by newforesee on 2018/8/9.
 */
@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    /**
     * 添加一条笔记
     * @param note
     * @return
     */
    public Notes noteAdd(Notes note){
        note.setTitle(note.getTitle());
        note.setUserid(note.getUserid());
        note.setContext(note.getContext());
        note.setStatus(NoteStatusEnum.ADD.getCode());
        return noteRepository.save(note);

    }

    /**
     * 列出所有笔记
     * @param userid
     * @return
     */
    public List<Notes> notesListByuserid(Integer userid){
        return noteRepository.findByUserid(userid);
    }

    /**
     * 删除一条笔记
     * @param id
     * @return
     */
    @Transactional
    public Integer dropNote(Integer id){
        return noteRepository.dropNote(id,NoteStatusEnum.DORP.getCode());

    }

}
