@echo off

:: Set the JENKINS_URL and AGENT_SECRET from the Jenkins server
set JENKINS_URL=http://<your_jenkins_server>:8080/
set AGENT_NAME=<your_agent_name>
set AGENT_SECRET=<your_agent_secret>

:: Path to the Jenkins agent JAR file
set AGENT_JAR_PATH=C:\path\to\agent.jar

:: Directory where the agent will run
set WORK_DIR=C:\Jenkins\agent

:: Start the Jenkins agent
java -jar %AGENT_JAR_PATH% -jnlpUrl %JENKINS_URL%computer/%AGENT_NAME%/jenkins-agent.jnlp -secret %AGENT_SECRET% -workDir %WORK_DIR%
