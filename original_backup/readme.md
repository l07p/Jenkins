# Original Backup
configuation files and jobs are saved here

## plugins for backup
setup plugin thinbackup

## backup

## restore
must be restarted after restore

mkdir /var/lib/jenkins/backups

sudo cp -R /media/lnmycloud/backups/jenkins/FULL** /var/lib/jenkins/backups/

## restart

To restart Jenkins manually, you can use either of the following commands (by entering their URL in a browser):

(jenkins_url)/safeRestart - Allows all running jobs to complete. New jobs will remain in the queue to run after the restart is complete.

(jenkins_url)/restart - Forces a restart without waiting for builds to complete.
