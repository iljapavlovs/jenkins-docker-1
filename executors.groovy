//https://github.com/jenkinsci/docker/blob/master/README.md#setting-the-number-of-executors
// number of executors on a node or master
import jenkins.model.*
Jenkins.instance.setNumExecutors(5)