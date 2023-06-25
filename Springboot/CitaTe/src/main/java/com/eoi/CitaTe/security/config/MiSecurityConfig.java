package com.eoi.CitaTe.security.config;

import com.eoi.CitaTe.security.service.MiUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableMethodSecurity        //habilitamos la security también en los metodos para desde el propio metodo configurar el rol de quien lo puede usar
@EnableWebSecurity
public class MiSecurityConfig {

///nos saltamos la restricion para entrar a h2-console///
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }

///////////////////////////////

    // Creamos nuestro propio bean de la SecurityFilterChain para configurar
    // el comportamiento de spring Security
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //Configuramos el Metodo HTTPSecurity para indicar la cadena de filtros de Autotización que vamos a seguir;
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/","" ).permitAll()
                .requestMatchers("/webjars/**").permitAll()
                .requestMatchers("/error/**").permitAll()
                .requestMatchers("/registroEmpresa*").permitAll()
                .requestMatchers("/citaTeP1").permitAll()
                .requestMatchers("/CitaTe.css").permitAll()
                .requestMatchers("/img/**").permitAll()
                .requestMatchers("/usuarios/**").permitAll()
                .requestMatchers("/empresas/**").permitAll()
                .requestMatchers("/catalogoDeServicios/**").hasAuthority("rolJefe")


                .anyRequest().authenticated()


        );

        // Configuramos la página personalizada de inicio de sesión.
        // También la url donde se hará el Post recibido de manera automática por Springboot
        // Después, indicamos cuál es la url por defecto al hacer login
        // Además, permitimos el acceso a todo el mundo.
        http.formLogin((form) -> form.loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/perfil")
                .permitAll());

        // Configuramos el sistema de cierre de sesión de la aplicación como el cierre de sesión predeterminado de Spring Security.
        http.logout((logout) -> logout.permitAll()
                .logoutSuccessUrl("/"));

        // Devolvemos el objeto HttpSecurity configurado para que Spring Boot y Spring Security realicen su magia.
        return http.build();

    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




    @Bean
    MiUserDetailService miUserDetailService() {return  new MiUserDetailService();}

    }
