package mak.projectnew.api_db;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class Studentcontroller {
    
    @Autowired
    StudentRepo repo;
    
    @GetMapping("")
    public Collection<Student> getall(){
        return repo.findAll();
    }

    @PostMapping("/add")
    public String postMethodName(@RequestBody Student student){
        repo.save(student);
        return "Student Saved as" + student.getName();
    }

    @PostMapping("/addmany")
    public String pdMethodName(@RequestBody Collection<Student> students){
        repo.saveAll(students);
        return students.size()+" Student Saved ";
    }
}
