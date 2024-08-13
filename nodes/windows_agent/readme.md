## Jenkins agent on windows pc
Created and executed from Jenkins master on Ubuntu (docker) server.
### File start-jenkins-agent.bat
This file start jenkins agent. It can be called in a schedule tast to make automatic start at boot. It is update version by version as the Jenkins master is always created from docker image newly that makes AGENT_SECRET change. 
