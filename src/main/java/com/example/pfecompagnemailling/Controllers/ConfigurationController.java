package com.example.pfecompagnemailling.Controllers;

import com.example.pfecompagnemailling.Entities.Configuration;
import com.example.pfecompagnemailling.Services.ConfigurationService.IConfigurationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class ConfigurationController {
    IConfigurationService iConfigurationService;

    @PostMapping("/addConfiguration")
    public Configuration addConfiguration(@RequestBody Configuration configuration) {
        return iConfigurationService.addConfiguration(configuration);
    }

    @PutMapping("/updateConfiguration")
    public Configuration updateConfiguration(@RequestBody Configuration configuration) {
        return iConfigurationService.updateConfiguration(configuration);
    }

    @GetMapping("/AllConfiguration")
    public List<Configuration> AllConfiguration() {
        return iConfigurationService.getAllConfigurations();
    }

    @GetMapping("/getConfigurationById/{id}")
    public Configuration getConfigurationById(@PathVariable("id") int id) {
        return iConfigurationService.getConfigurationById(id);
    }

    @DeleteMapping("/deleteConfiguration/{id}")
    public void deleteConfiguration(@PathVariable("id") int id) {
        iConfigurationService.deleteConfiguration(id);
        ;
    }
}
