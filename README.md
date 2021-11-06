#The project overview

##Simple properties
We use @Configuration so that Spring creates a Spring bean in the application context.
@ConfigurationProperties works best with hierarchical properties that all have the same prefix;
therefore, we add a prefix of mail.
Note: If we don't use @Configuration in the POJO,
then we need to add @EnableConfigurationProperties(ConfigProperties.class) in the main Spring application class to bind the properties into the POJO:
