//from chapter 5 of Hands-On: Full Stack Development with Spring Boot 2 and React 2nd Edition by Juha Hinkula (Pakt Publishing)

//imports not included in this transcription.

public class AuthenticationService{
  static final long EXPIRATIONTIME=864_000_00;
  //1 day

  static final String SIGNINGKEY = "SecretKey";
  static final String PREFIX = "Bearer";

  //Add token to Auth header
  static public void addToken(HttpServletResponse res, String username) {
    String jwtToken = Jwts.builder().setSubject(username)
                        .setExpiration(newDate(System.currentTimeMillis()+EXPIRATIONTIME))
                        .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
                        .compact();
    res.addHeader("Authorization", PREFIX + " " + JwtTowken);
    res.addHeader("Access-Control-Expose-Headers", "Authorization");
    //javascript won't have access unless we expose headers!
  }

  //Get token from Auth header
  static public Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    if (token != null) {
      String user = Jwts.parser()
                      .setSigningKey(SIGNINGKEY)
                      .parseClaimsJws(token.replace(PREFIX, ""))
                      .getBody()
                      .getSubject();
      if (user != null){
        return new UsernamePasswordAuthenticationToken(user, null, emptyList());
      }
      return null;

    }
  } //end getAuthentication()

} //end AuthenticationService

public class AccountCredentials {
  private String username;
  private String password;

  public String getUsername(){
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword(){
    return password;
  }

  public void setPassword(String password){
    this.password = password;
  }
} //end AccountCredentials

public class LoginFilter extends AbstractAuthenticationProcessingFilter {
  public LoginFilter(String url, AuthenticationManager authManager) {
    super(new AntPathRequestMatcher(url));
    setAuthenticationManger(authManager);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
    AccountCredentials creds = new ObjectMapper()
       .readValue(req.getInputStream(), AccountCredentials.class);
    return getAuthenticationManager().authenticate(
      new UsernamePasswordAuthenticationToken(
        creds.getUsername(),
        creds.getPassword(),
        Collection.emptyList()
      )
    );
  } //end attemptAuthentication()

  @Override
  protected void successfulAuthentication(
    HttpServletRequest req,
    HttpServeletResponse res,
    FilterChain chain,
    Authentication auth) throws
      IOException, ServletException
  {
    AuthenticatonService.addToken(res, auth.getName());
  }

} //end LoginFilter class

public class AuthenticationFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
    throws IOException, ServletException
  {
    Authentication authentication = AuthenticationService.getAuthentication((HttpServeletRequest) request);

    SecurityContextHolder.getContext()
      .setAuthentication(authentication);

    filterChain.doFilter(request, response);
  }


} //end AuthenticationFilter class


//Security Config class configure()
@Override
protected void configure(HttpSecurity http)
  throws Exception
{
  http.csrf().disable().cors().and().authorizeRequests()
    .antMatchers(HttpMethod.POST, "/login")
    .permitAll()
    .anyRequest().authenticated()
    .and()
    //Filter for api/login reqs
    .addFilterBefore(new LoginFilter("/login",       authenticationManager()),
      UsernamePasswordAuthenticationFilter.class)
    //Filter for other requests to check JWT in header
    .addFilterBefore(new AuthenticationFilter(),
      UsernamePasswordAuthenticationFilter.class);
}

@Bean
  CorsConfigurationSource corsConfigurationSource() {
    UrlBasedCorsConfigurationSource source =
      new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.SetAllowedOrigins(Arrays.asList("*"));
    config.SetAllowedMethods(Arrays.asList("*"));
    config.SetAllowedHeaders(Arrays.asList("*"));
    config.setAllowCredentials(true);
    config.applyPermitDefaultValues();
    source.registerCorsConfiguration("/**"), config);
    return source;

  }
