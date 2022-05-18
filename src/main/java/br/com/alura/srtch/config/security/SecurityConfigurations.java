//package br.com.alura.srtch.config.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
//
//    //configuracoes de autenticacao
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    }
//
//    //Configuracoes de autorizacao
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/api/clientes").permitAll()
//                .antMatchers("/api/clientes/*").permitAll()
//                .antMatchers("/api/dividas").permitAll()
//                .anyRequest().authenticated();
//    }
//
//    //Configuracoes de recursos estaticos
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//    }
//}
