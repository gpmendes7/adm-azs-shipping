package com.azship.gerenciadordefrete.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Transporta Aí",
                description = "Implementar operações CRUD",
                summary = "API para listar, buscar, remover, editar e deletar dados sobre fretes e transportes",
                termsOfService = "T&C",
                contact = @Contact(
                        name = "Gabriel Mendes",
                        email = "andrewsseven@gmail.com"
                ),
                license = @License(
                        name = "Número da Lincença"
                ),
                version = "v1"
        ),
        servers = {
                @Server(
                        description = "Desenvolvimento",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Teste",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
