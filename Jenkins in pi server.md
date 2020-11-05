# Setup Jenkins master on pi
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
```
