package org.growersnation.site;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.client.JerseyClientConfiguration;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>DropWizard Configuration to provide the following to application:</p>
 * <ul>
 * <li>Initialisation code</li>
 * </ul>
 *
 * @since 0.0.1
 *         
 */
public class SiteConfiguration extends Configuration {

  /**
   * The cookie name for the session token
   */
  public static final String SESSION_TOKEN_NAME ="GN-Session";

  /**
   * The cookie name for the "remember me" token
   */
  private static final String rememberMeName ="GN-RememberMe";

  @NotEmpty
  @JsonProperty
  private String assetCachePolicy="maximumSize=10000, expireAfterAccess=5s";

  /**
   * How long a session cookie authentication can remain inactive before the user must signin in
   * TODO Implement this
   */
  @NotEmpty
  @JsonProperty
  private String cookieAuthenticationCachePolicy ="maximumSize=10000, expireAfterAccess=600s";

  @Valid
  @NotNull
  @JsonProperty
  private JerseyClientConfiguration httpClient = new JerseyClientConfiguration();

  @NotEmpty
  @JsonProperty
  private String mongoUri;

  public String getAssetCachePolicy() {
    return assetCachePolicy;
  }

  public JerseyClientConfiguration getJerseyClientConfiguration() {
    return httpClient;
  }

  public String getCookieAuthenticationCachePolicy() {
    return cookieAuthenticationCachePolicy;
  }

  public String getSessionTokenName() {
    return SESSION_TOKEN_NAME;
  }

  public String getRememberMeName() {
    return rememberMeName;
  }

  public String getMongoUri() {
    return mongoUri;
  }

}
