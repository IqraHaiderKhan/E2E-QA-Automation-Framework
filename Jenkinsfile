
pipeline {
  agent any
  tools { maven 'M3' }
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build & Test (web)') {
      steps { 
        sh 'mvn -B -q -e clean test -P web' 
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }
  }
}
