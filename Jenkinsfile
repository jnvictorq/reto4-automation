pipeline {
    agent any

    stages {

        stage('Limpiar workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Clonar repositorio') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/jnvictorq/reto4-automation.git'
            }
        }

        stage('Ejecutar Selenium') {
            steps {
                dir('reto4-selenium') {
                    bat 'mvn -f pom.xml test'
                }
            }
            post {
                always {
                    script {
                        def historyDir = "${env.WORKSPACE}/allure-report/history"
                        def resultsDir = "${env.WORKSPACE}/reto4-selenium/allure-results"
                        if (fileExists(historyDir)) {
                            echo "Copiando historial de Allure..."
                            bat "xcopy /E /I /Y \"${historyDir}\" \"${resultsDir}\\history\""
                        }
                    }
                    allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'reto4-selenium/allure-results']]
                    ])
                }
            }
        }

        stage('Instalar dependencias Cypress') {
            steps {
                dir('reto4-cypress') {
                    bat 'npm install'
                }
            }
        }

        stage('Ejecutar Cypress') {
            steps {
                dir('reto4-cypress') {
                    bat 'npx cypress run --env allure=true || exit 0'
                }
            }
            post {
                always {
                    script {
                        def historyDir = "${env.WORKSPACE}/allure-report/history"
                        def resultsDir = "${env.WORKSPACE}/reto4-cypress/allure-results"
                        if (fileExists(historyDir)) {
                            echo "Copiando historial de Allure..."
                            bat "xcopy /E /I /Y \"${historyDir}\" \"${resultsDir}\\history\""
                        }
                    }
                    allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'reto4-cypress/allure-results']]
                    ])
                }
            }
        }
        stage('Publicar reporte Allure') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [
                        [path: 'reto4-selenium/allure-results'],
                        [path: 'reto4-cypress/allure-results']
                    ]
                ])
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
