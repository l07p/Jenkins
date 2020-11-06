# Setup Jenkins master on pi
## Instance Configuration
Jenkins URL: | http://192.168.178.54:8080/
------------ | ---------------------------

## Install Jenkins
Refer to https://www.digitalocean.com/community/tutorials/how-to-install-jenkins-on-ubuntu-20-04-de
**Steps**
- [ ] install jenkins to pi by referring to last link


```properties
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
``` 
OK as result

```properties
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
```
then
```properties
sudo apt update
```
then
```properties
sudo apt install jenkins
```
then
```properties
sudo systemctl start jenkins
sudo systemctl status jenkins
sudo ufw allow 8080
sudo ufw status
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
6ff9e649de834a73bc9dc0da91318a3b
```
## Create first Admin User
Column | input
------ | -----
Username | pi
Password | über500
Email | net.support@xiang-liang.de

## add python plugins
Configuration Jenkins > Global Tool Configuration
plugins | usage
------- | -----
Python | ability to execute python
ShiningPanda | ?
Pyenv Pipeline | ?
