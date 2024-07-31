pipeline {
    agent any

    parameters {
        choice(name: 'OPERATION', choices: ['add', 'subtract', 'multiply', 'divide'], description: 'Operation to perform')
        string(name: 'NUM1', defaultValue: '2', description: 'First number')
        string(name: 'NUM2', defaultValue: '3', description: 'Second number')
    }

    stages {
        stage('Load ArithmeticPipeline') {
            steps {
                script {
                    // Load the external Groovy script
                    def arithmeticScript = load 'https://github.com/l07p/Jenkins/blob/master/jobs/pipelines/arithmetic/ArithmeticPipeline.groovy'
                }
            }
        }

        stage('Test Addition') {
            steps {
                script {
                    def num1 = 2
                    def num2 = 3
                    def expectedResult = 5
                    def result = arithmeticScript.arithmeticPipeline('add', num1, num2)
                    assert result == expectedResult : "Expected ${expectedResult} but got ${result}"
                    echo "Addition Test Passed: ${num1} + ${num2} = ${result}"
                    
                    // Create a JUnit report file
                    def junitReport = """
                    <testsuite name='ArithmeticTests'>
                        <testcase name='Addition Test'>
                            ${result == expectedResult ? "" : "<failure message='Expected ${expectedResult} but got ${result}'/>"}
                            <system-out>
                                <![CDATA[ ${num1} + ${num2} = ${result} ]]>
                            </system-out>
                        </testcase>
                    </testsuite>
                    """
                    writeFile file: 'addition-test.xml', text: junitReport
                }
            }
        }

        stage('Test Subtraction') {
            steps {
                script {
                    def num1 = 10
                    def num2 = 5
                    def expectedResult = 5
                    def result = arithmeticScript.arithmeticPipeline('subtract', num1, num2)
                    assert result == expectedResult : "Expected ${expectedResult} but got ${result}"
                    echo "Subtraction Test Passed: ${num1} - ${num2} = ${result}"
                    
                    // Create a JUnit report file
                    def junitReport = """
                    <testsuite name='ArithmeticTests'>
                        <testcase name='Subtraction Test'>
                            ${result == expectedResult ? "" : "<failure message='Expected ${expectedResult} but got ${result}'/>"}
                            <system-out>
                                <![CDATA[ ${num1} - ${num2} = ${result} ]]>
                            </system-out>
                        </testcase>
                    </testsuite>
                    """
                    writeFile file: 'subtraction-test.xml', text: junitReport
                }
            }
        }

        stage('Test Multiplication') {
            steps {
                script {
                    def num1 = 2
                    def num2 = 3
                    def expectedResult = 6
                    def result = arithmeticScript.arithmeticPipeline('multiply', num1, num2)
                    assert result == expectedResult : "Expected ${expectedResult} but got ${result}"
                    echo "Multiplication Test Passed: ${num1} * ${num2} = ${result}"
                    
                    // Create a JUnit report file
                    def junitReport = """
                    <testsuite name='ArithmeticTests'>
                        <testcase name='Multiplication Test'>
                            ${result == expectedResult ? "" : "<failure message='Expected ${expectedResult} but got ${result}'/>"}
                            <system-out>
                                <![CDATA[ ${num1} * ${num2} = ${result} ]]>
                            </system-out>
                        </testcase>
                    </testsuite>
                    """
                    writeFile file: 'multiplication-test.xml', text: junitReport
                }
            }
        }

        stage('Test Division') {
            steps {
                script {
                    def num1 = 10
                    def num2 = 2
                    def expectedResult = 5
                    def result = arithmeticScript.arithmeticPipeline('divide', num1, num2)
                    assert result == expectedResult : "Expected ${expectedResult} but got ${result}"
                    echo "Division Test Passed: ${num1} / ${num2} = ${result}"
                    
                    // Create a JUnit report file
                    def junitReport = """
                    <testsuite name='ArithmeticTests'>
                        <testcase name='Division Test'>
                            ${result == expectedResult ? "" : "<failure message='Expected ${expectedResult} but got ${result}'/>"}
                            <system-out>
                                <![CDATA[ ${num1} / ${num2} = ${result} ]]>
                            </system-out>
                        </testcase>
                    </testsuite>
                    """
                    writeFile file: 'division-test.xml', text: junitReport
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/*.xml'
            }
        }
    }
}
