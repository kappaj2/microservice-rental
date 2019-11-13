package za.co.ajk.rentcloud.authorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class AuthorizationServerConfiguration implements AuthorizationServerConfigurer {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    TokenStore jdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()").tokenKeyAccess("permitAll()");
    }

    /**
     * Extract all the configuration from the database for the clients configured.
     * The clientId, clientSecret as well as the login redirect is configured here.
     * The table for the client information is oauth_client_details.
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
    }

//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoint) throws Exception {
//        endpoint.authenticationManager(authenticationManager);
//        endpoint.tokenStore(jdbcTokenStore());
//    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));
        endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain).authenticationManager(authenticationManager);
    }


    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
        // final KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("mytest.jks"), "mypass".toCharArray());
        // converter.setKeyPair(keyStoreKeyFactory.getKeyPair("mytest"));
        return converter;
    }
}
