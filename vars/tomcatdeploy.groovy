def call(ip,creds,user) {
  sshagent(["${creds}"]) {
    sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/tomcat009/webapps"
    sh "ssh ${user}@${ip} /opt/tomcat009/bin/shutdown.sh"
    sh "ssh ${user}@${ip} /opt/tomcat009/bin/startup.sh"
  }
}
