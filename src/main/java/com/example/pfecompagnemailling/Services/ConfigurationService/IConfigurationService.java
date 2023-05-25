package com.example.pfecompagnemailling.Services.ConfigurationService;

import com.example.pfecompagnemailling.Entities.Configuration;

import java.util.List;

public interface IConfigurationService {
    Configuration addConfiguration(Configuration Configuration);

    Configuration updateConfiguration(Configuration Configuration);

    public List<Configuration> getAllConfigurations();

    public Configuration getConfigurationById(int id);

    public void deleteConfiguration(int id);
}
