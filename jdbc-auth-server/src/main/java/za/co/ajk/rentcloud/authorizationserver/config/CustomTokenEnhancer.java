package za.co.ajk.rentcloud.authorizationserver.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import za.co.ajk.rentcloud.authorizationserver.model.AuthUserDetail;
import za.co.ajk.rentcloud.authorizationserver.model.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        AuthUserDetail authUserDetail = (AuthUserDetail) authentication.getUserAuthentication().getPrincipal();

        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("organization", authentication.getName() + "AAAA");
        additionalInfo.put("grantAuthorities", authentication.getAuthorities());
        additionalInfo.put("resourceIds", authentication.getOAuth2Request().getResourceIds());
        additionalInfo.put("grantedRoles", authUserDetail.getRoles());
        additionalInfo.put("userName", authUserDetail.getUsername());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
