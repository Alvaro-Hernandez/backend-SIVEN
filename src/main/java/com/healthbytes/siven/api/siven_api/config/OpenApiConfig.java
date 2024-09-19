package com.healthbytes.siven.api.siven_api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@ConfigurationProperties
@OpenAPIDefinition(info = @Info(title = "SIVEN API", version = "1.0", description = "Servicios para el manejo de SIVEN APP"))
public class OpenApiConfig {

}
