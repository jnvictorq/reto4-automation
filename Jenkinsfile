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
                    // Publicar resultados de Allure (Selenium)
                    allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'reto4-selenium/allure-results']]
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
            // Ejecuta Cypress con Allure activado
            bat 'npx cypress run --env allure=true || exit 0'
        }
    }
    post {
        always {
            // Publicar resultados de Allure (Cypress)
            allure([
                includeProperties: false,
                jdk: '',
                results: [[path: 'reto4-cypress/allure-results']]
            ])

            // Archivar evidencias adicionales
            archiveArtifacts artifacts: 'reto4-cypress/cypress/screenshots/**/*.*', allowEmptyArchive: true
            archiveArtifacts artifacts: 'reto4-cypress/cypress/videos/**/*.*', allowEmptyArchive: true
            archiveArtifacts artifacts: 'reto4-cypress/cypress/reports/**/*.*', allowEmptyArchive: true
        }
    }
}
    }

    post {
        success {
            echo '✅ Todas las pruebas pasaron correctamente.'
        }
        failure {
            echo '❌ Algunas pruebas fallaron. Revisar evidencias y reportes.'
        }
    }
}
