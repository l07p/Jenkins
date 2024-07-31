def runTests() {
    def result = add(2, 3)
    if (result == 5) {
        println "Test Passed: 2 + 3 = 5"
    } else {
        println "Test Failed: 2 + 3 != ${result}"
    }
}

def add(num1, num2) {
    return num1 + num2
}

return this
