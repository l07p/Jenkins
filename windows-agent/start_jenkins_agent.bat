@echo off
docker run -d --name jenkins-agent ^
  -v /var/run/docker.sock:/var/run/docker.sock ^
  -v jenkins-agent-workdir:/home/jenkins/agent ^
  -e JENKINS_AGENT_NAME="windows-agent" ^
  -e JENKINS_URL="http://192.168.178.79:8080" ^
  -e JENKINS_SECRET="20de77a801176bd8c1099eb05c197889f5a98a02daa6903fa6d5042dfeeb6972" ^
  jenkins/inbound-agent
