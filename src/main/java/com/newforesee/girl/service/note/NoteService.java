package com.newforesee.girl.service.note;

import com.newforesee.girl.daomain.Notes;
import com.newforesee.girl.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by newforesee on 2018/8/9.
 */
@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Notes noteAdd(Notes note){
        note.setTitle(note.getTitle());
        note.setUserid(note.getUserid());
        note.setContext(note.getContext());
        return noteRepository.save(note);

    }

    public List<Notes> notesListByuserid(Integer userid){
        return noteRepository.findByUserid(userid);
    }

}
