package com.example.pfecompagnemailling.Services.ConfigurationService;

import com.example.pfecompagnemailling.Entities.Configuration;
import com.example.pfecompagnemailling.Repository.ConfigurationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConfigurationService implements IConfigurationService {
    public ConfigurationRepository configurationRepository;

    @Override
    public Configuration addConfiguration(Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    @Override
    public Configuration updateConfiguration(Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    @Override
    public List<Configuration> getAllConfigurations() {
        return configurationRepository.findAll();
    }

    @Override
    public Configuration getConfigurationById(int id) {
        return configurationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteConfiguration(int id) {
        configurationRepository.deleteById(id);
    }
}
