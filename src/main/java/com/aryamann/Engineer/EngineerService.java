package com.aryamann.Engineer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EngineerService {

    @Autowired
    private EngineerRepository engineerRepository;

    @Autowired
    public EngineerService(EngineerRepository engineerRepository) {
        this.engineerRepository = engineerRepository;
    }

    public List<Engineer> getEngineers(){
        return engineerRepository.findAll();
    }

    public void addEngineer(Engineer engineer){
        engineerRepository.save(engineer);
    }

    public void deleteEngineerById(Integer engineerId) {
        boolean b = engineerRepository.existsById(engineerId);
        if(!b) throw new IllegalStateException("Engineer with Id " +engineerId +" not found");
        engineerRepository.deleteById(engineerId);
    }
    public void updateEngineerById(Integer engineerId, String name, String techStack) {
        Engineer engineer = engineerRepository.findById(engineerId).orElseThrow(()-> new IllegalStateException("Student not found"));
        if(name!=null && !name.isEmpty() && !Objects.equals(name , engineer.getName())) {
            engineer.setName(name);
        }
        if(techStack!=null && !techStack.isEmpty() && !Objects.equals(techStack , engineer.getTechStack())) {
            engineer.setTechStack(techStack);
        }
        engineerRepository.save(engineer);
        System.out.println("Engineer Updated!");
    }
}
