package com.aryamann.Engineer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/engineers")
public class EngineerController {

    private final EngineerService engineerService;
    @Autowired
    public EngineerController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping
    public List<Engineer> getEngineers(){
        return engineerService.getEngineers();
    }

    @PostMapping
    public void addEngineer(@RequestBody Engineer engineer){
        engineerService.addEngineer(engineer);
    }

    @DeleteMapping(path = "{engineerId}")
    public void deleteEngineerById(@PathVariable(name = "engineerId") Integer engineerId){
        engineerService.deleteEngineerById(engineerId);
    }

    @PutMapping(path = "{engineerId}")
    public void updateEngineerById(@PathVariable(name = "engineerId") Integer engineerId,
    @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String techStack){
        engineerService.updateEngineerById(engineerId , name , techStack);

    }
}
