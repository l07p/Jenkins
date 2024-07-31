// Define the arithmetic function outside of stages
def arithmeticPipeline = { operation, num1, num2 ->
    num1 = num1.toInteger()
    num2 = num2.toInteger()
    switch(operation) {
        case 'add':
            return num1 + num2
        case 'subtract':
            return num1 - num2
        case 'multiply':
            return num1 * num2
        case 'divide':
            if (num2 == 0) {
                error("Division by zero is not allowed.")
            }
            return num1 / num2
        default:
            error("Unsupported operation: ${operation}")
    }
}

pipeline {
    agent any
    
    parameters {
        choice(name: 'OPERATION', choices: ['add', 'subtract', 'multiply', 'divide'], description: 'Operation to perform')
        string(name: 'NUM1', defaultValue: '0', description: 'First number')
        string(name: 'NUM2', defaultValue: '0', description: 'Second number')
    }
    
    stages {
        stage('Calculate') {
            steps {
                script {
                    // Call the arithmetic function defined outside
                    def result = arithmeticPipeline(params.OPERATION, params.NUM1, params.NUM2)
                    echo "Result: ${result}"

                    // Create a JUnit report file
                    def junitReport = "<testsuite name='ArithmeticTests'><testcase name='Calculation'><failure message='Result: ${result}'/></testcase></testsuite>"
                    writeFile file: 'test-results.xml', text: junitReport

                    // Publish JUnit test results
                    junit 'test-results.xml'
                }
            }
        }
    }
}
