package org.anasoid.jmix.demo.autoconfigure.core;

import org.anasoid.jmix.demo.core.CoreConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({CoreConfiguration.class})
public class CoreAutoConfiguration {
}

