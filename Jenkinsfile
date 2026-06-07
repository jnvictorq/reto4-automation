pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/jnvictorq/reto4-automation.git'
            }
        }

        stage('Selenium Tests') {
            steps {
                dir('reto4-selenium') {
                    bat 'mvn -f pom.xml clean test'
                }
            }
            post {
                always {
                    // Publicar resultados de Allure
                    allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'reto4-selenium/target/allure-results']]
                    ])

                    // Archivar evidencias adicionales
                    archiveArtifacts artifacts: 'reto4-selenium/screenshots/**/*.*', allowEmptyArchive: true
                    archiveArtifacts artifacts: 'reto4-selenium/reports/**/*.*', allowEmptyArchive: true
                }
            }
        }

        stage('Cypress Tests') {
            steps {
                dir('reto4-cypress') {
                    bat 'npm install'
                    bat 'npx cypress run'
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'reto4-cypress/cypress/screenshots/**/*.*', allowEmptyArchive: true
                    archiveArtifacts artifacts: 'reto4-cypress/cypress/videos/**/*.*', allowEmptyArchive: true
                    archiveArtifacts artifacts: 'reto4-cypress/cypress/reports/**/*.*', allowEmptyArchive: true
                }
            }
        }
    }
}
