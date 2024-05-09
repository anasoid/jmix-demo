package com.company.autoconfigure.core;

import com.company.core.CoreConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({CoreConfiguration.class})
public class CoreAutoConfiguration {
}

