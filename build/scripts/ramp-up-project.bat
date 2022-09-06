@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  ramp-up-project startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and RAMP_UP_PROJECT_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\ramp-up-project.jar;%APP_HOME%\lib\dropwizard-migrations-2.1.0.jar;%APP_HOME%\lib\dropwizard-hibernate-2.1.0.jar;%APP_HOME%\lib\dropwizard-testing-2.1.0.jar;%APP_HOME%\lib\dropwizard-core-2.1.0.jar;%APP_HOME%\lib\mysql-connector-java-8.0.30.jar;%APP_HOME%\lib\dropwizard-db-2.1.0.jar;%APP_HOME%\lib\lombok-1.18.24.jar;%APP_HOME%\lib\assertj-core-3.23.1.jar;%APP_HOME%\lib\mockito-core-4.6.1.jar;%APP_HOME%\lib\dropwizard-configuration-2.1.0.jar;%APP_HOME%\lib\dropwizard-health-2.1.0.jar;%APP_HOME%\lib\dropwizard-jersey-2.1.0.jar;%APP_HOME%\lib\dropwizard-jetty-2.1.0.jar;%APP_HOME%\lib\dropwizard-request-logging-2.1.0.jar;%APP_HOME%\lib\dropwizard-logging-2.1.0.jar;%APP_HOME%\lib\dropwizard-metrics-2.1.0.jar;%APP_HOME%\lib\dropwizard-jackson-2.1.0.jar;%APP_HOME%\lib\dropwizard-validation-2.1.0.jar;%APP_HOME%\lib\dropwizard-servlets-2.1.0.jar;%APP_HOME%\lib\dropwizard-lifecycle-2.1.0.jar;%APP_HOME%\lib\dropwizard-util-2.1.0.jar;%APP_HOME%\lib\metrics-jetty9-4.2.9.jar;%APP_HOME%\lib\metrics-servlets-4.2.9.jar;%APP_HOME%\lib\metrics-jvm-4.2.9.jar;%APP_HOME%\lib\metrics-jmx-4.2.9.jar;%APP_HOME%\lib\metrics-healthchecks-4.2.9.jar;%APP_HOME%\lib\metrics-logback-4.2.9.jar;%APP_HOME%\lib\metrics-jersey2-4.2.9.jar;%APP_HOME%\lib\metrics-json-4.2.9.jar;%APP_HOME%\lib\metrics-core-4.2.9.jar;%APP_HOME%\lib\logback-classic-1.2.11.jar;%APP_HOME%\lib\jackson-datatype-guava-2.13.2.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.13.2.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.13.2.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.13.2.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.13.2.jar;%APP_HOME%\lib\jackson-module-blackbird-2.13.2.jar;%APP_HOME%\lib\jackson-datatype-joda-2.13.2.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.13.2.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.13.2.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.13.2.jar;%APP_HOME%\lib\jackson-core-2.13.2.jar;%APP_HOME%\lib\jackson-datatype-hibernate5-2.13.2.jar;%APP_HOME%\lib\jackson-databind-2.13.2.2.jar;%APP_HOME%\lib\jackson-annotations-2.13.2.jar;%APP_HOME%\lib\guava-31.1-jre.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\jersey-test-framework-provider-inmemory-2.35.jar;%APP_HOME%\lib\jersey-test-framework-core-2.35.jar;%APP_HOME%\lib\jakarta.servlet-api-4.0.4.jar;%APP_HOME%\lib\jersey-bean-validation-2.35.jar;%APP_HOME%\lib\hibernate-validator-6.2.3.Final.jar;%APP_HOME%\lib\jersey-container-servlet-2.35.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.35.jar;%APP_HOME%\lib\jersey-server-2.35.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\jersey-client-2.35.jar;%APP_HOME%\lib\jersey-metainf-services-2.35.jar;%APP_HOME%\lib\jersey-hk2-2.35.jar;%APP_HOME%\lib\jersey-media-jaxb-2.35.jar;%APP_HOME%\lib\jersey-common-2.35.jar;%APP_HOME%\lib\jakarta.ws.rs-api-2.1.6.jar;%APP_HOME%\lib\argparse4j-0.9.0.jar;%APP_HOME%\lib\jetty-servlet-9.4.46.v20220331.jar;%APP_HOME%\lib\jetty-security-9.4.46.v20220331.jar;%APP_HOME%\lib\jetty-server-9.4.46.v20220331.jar;%APP_HOME%\lib\jetty-servlets-9.4.46.v20220331.jar;%APP_HOME%\lib\jetty-http-9.4.46.v20220331.jar;%APP_HOME%\lib\jetty-io-9.4.46.v20220331.jar;%APP_HOME%\lib\jetty-util-ajax-9.4.46.v20220331.jar;%APP_HOME%\lib\jetty-util-9.4.46.v20220331.jar;%APP_HOME%\lib\jetty-setuid-java-1.0.4.jar;%APP_HOME%\lib\jakarta.inject-api-1.0.5.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.36.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.36.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.36.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\protobuf-java-3.19.4.jar;%APP_HOME%\lib\liquibase-core-4.9.1.jar;%APP_HOME%\lib\liquibase-slf4j-4.1.0.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.3.jar;%APP_HOME%\lib\tomcat-jdbc-9.0.62.jar;%APP_HOME%\lib\hibernate-core-5.6.8.Final.jar;%APP_HOME%\lib\javax.persistence-api-2.2.jar;%APP_HOME%\lib\javassist-3.28.0-GA.jar;%APP_HOME%\lib\usertype.core-7.0.0.CR1.jar;%APP_HOME%\lib\jakarta.activation-api-1.2.2.jar;%APP_HOME%\lib\metrics-annotation-4.2.9.jar;%APP_HOME%\lib\byte-buddy-1.12.10.jar;%APP_HOME%\lib\byte-buddy-agent-1.12.10.jar;%APP_HOME%\lib\objenesis-3.2.jar;%APP_HOME%\lib\caffeine-2.9.3.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\jakarta.el-3.0.4.jar;%APP_HOME%\lib\commons-text-1.9.jar;%APP_HOME%\lib\logback-access-1.2.11.jar;%APP_HOME%\lib\logback-core-1.2.11.jar;%APP_HOME%\lib\logback-throttling-appender-1.1.9.jar;%APP_HOME%\lib\hk2-locator-2.6.1.jar;%APP_HOME%\lib\hk2-api-2.6.1.jar;%APP_HOME%\lib\hk2-utils-2.6.1.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\joda-time-2.10.14.jar;%APP_HOME%\lib\profiler-1.1.1.jar;%APP_HOME%\lib\jakarta.inject-2.6.1.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.3.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.1.2.Final.jar;%APP_HOME%\lib\jboss-logging-3.4.3.Final.jar;%APP_HOME%\lib\tomcat-juli-9.0.62.jar;%APP_HOME%\lib\javax.transaction-api-1.3.jar;%APP_HOME%\lib\usertype.spi-7.0.0.CR1.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jboss-transaction-api_1.2_spec-1.1.1.Final.jar;%APP_HOME%\lib\jandex-2.4.2.Final.jar;%APP_HOME%\lib\jaxb-runtime-2.3.1.jar;%APP_HOME%\lib\junit-4.13.1.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\checker-qual-3.19.0.jar;%APP_HOME%\lib\error_prone_annotations-2.11.0.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\snakeyaml-1.30.jar;%APP_HOME%\lib\commons-lang3-3.11.jar;%APP_HOME%\lib\aopalliance-repackaged-2.6.1.jar;%APP_HOME%\lib\jetty-continuation-9.4.46.v20220331.jar;%APP_HOME%\lib\txw2-2.3.1.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.7.jar;%APP_HOME%\lib\stax-ex-1.8.jar;%APP_HOME%\lib\FastInfoset-1.2.15.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar


@rem Execute ramp-up-project
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %RAMP_UP_PROJECT_OPTS%  -classpath "%CLASSPATH%" App %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable RAMP_UP_PROJECT_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%RAMP_UP_PROJECT_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
