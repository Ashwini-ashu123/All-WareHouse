pipeline {
    agent any

    triggers {
        githubPush()
    }

    stages {

        stage('Build & Run Tests') {
            steps {
                bat 'mvn clean test -Dmaven.test.failure.ignore=true'
            }
        }

        stage('Publish Test Reports') {
            steps {
                junit 'target/cucumber.xml'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**', fingerprint: true
            }
        }

    }
}