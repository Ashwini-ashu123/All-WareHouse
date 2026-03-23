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
                junit allowEmptyResults: true, testResults: 'target/cucumber.xml'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**', fingerprint: true
            }
        }

        stage('AI Analysis') {
            steps {
                script {
                    // Save Jenkins log
                    def log = currentBuild.rawBuild.getLog(1000).join("\n")
                    writeFile file: 'log.txt', text: log
                }

                // Run Python script with API key
                withCredentials([string(credentialsId: 'openai-key', variable: 'OPENAI_API_KEY')]) {
                    bat 'python ai_summary.py || echo AI step failed'
                }
            }
        }
    }

    post {
        always {
            script {
                def summary = fileExists('summary.txt') ? readFile('summary.txt') : "No summary generated"

                emailext (
                    subject: "Build: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """
Build Status: ${currentBuild.currentResult}

🤖 AI Summary:
${summary}

🔗 Build URL:
${env.BUILD_URL}
""",
                    to: "ashwinigmeet@gmail.com"
                )
            }
        }
    }
}
