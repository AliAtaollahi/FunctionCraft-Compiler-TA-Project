import subprocess
import xlsxwriter
from difflib import SequenceMatcher
import sys
sample_num = sys.argv[1]
TEST_NUMBER = 60
RATIO = 0.7
GROUP_FOLDER = ".\\groups\\group_" + str(sample_num)
SAMPLES_FOLDER_ADDRESS = "Samples"
PROJECT_START_COMMAND = "\"C:\\Users\\98936\\.jdks\\openjdk-15\\bin\\java.exe\" "
PROJECT_START_COMMAND += "\"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2020.2.3\\lib\\idea_rt.jar=50346:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2020.2.3\\bin\" "
PROJECT_START_COMMAND += "-Dfile.encoding=UTF-8 "
PROJECT_START_COMMAND += "-classpath "
PROJECT_START_COMMAND += "\"" + GROUP_FOLDER + "\\out\\production\\Jepeto_Phase3;"
PROJECT_START_COMMAND += ".\\antlr-4.9.2-complete.jar\" main.Jepeto "

def listDiff(li1, li2):
    ans = list()
    for i in li1:
        if i not in li2:
            ans.append(i)
    return ans

def similar(a, b):
    return round(SequenceMatcher(None, "".join(a), "".join(b)).ratio(), 2)

def similar2(source, test):
    type_source = list()
    error_source = list()
    type_test = list()
    error_test = list()

    if("Compilation successful" in test):
        test.remove("Compilation successful")

    for i in source:
        if (i.strip().split()[0] == "Line"):
            error_source.append(i.strip())
    type_source = listDiff(source, error_source)

    for i in test:
        if (i.strip().split()[0] == "Line"):
            error_test.append(i.strip())
    type_test = listDiff(test, error_test)

    percent_error = 1 / len(error_source)
    score_error = 0

    for i in error_source:
        if (i in error_test):
            score_error += percent_error
    if (len(error_test) > len(error_source)):
        score_error -= (len(error_test) - len(error_source)) * percent_error
    if(score_error < 0 ):
        score_error = 0
    
    score_type = 1

    if(len(type_source) != len(type_test)):
        score_type = 0
    else:
        for i in range(len(type_source)):
            if(type_source[i] != type_test[i]):
                score_type = 0
                break

    return round(0.3 * score_type + 0.7 * score_error, 2)

def run(i):
    with open(SAMPLES_FOLDER_ADDRESS + "\\ans" + str(i) + ".txt") as temp_file:
        answerLines = [line.rstrip('\n') for line in temp_file if line.rstrip('\n') != '']
    if(len(answerLines) == 0):
        answerLines.append("")
    result = subprocess.run(PROJECT_START_COMMAND + " \"" + SAMPLES_FOLDER_ADDRESS + "\\" + str(i) + ".jp\"", stdout=subprocess.PIPE, stderr=subprocess.STDOUT, text=True).stdout
    result = result.strip().split('\n')

    similarity = similar2(answerLines, result)
    # similarity = similar(answerLines, result)
    if(similarity < 1):
        print("Test " + str(i) + " : Failed    Score: " + str(similarity))
        # return similarity * RATIO
        return similarity
    else:
        print("Test " + str(i) + " : Passed    Score: 1")
        return 1


testResults = []
passedCount = 0
Sum1 = 0
print("Tests\n------------------------------")
for i in range(1, 51):
    result = run(i)
    Sum1 += result
    testResults.append(result)
    if(result == 1):
        passedCount += 1



testResults2 = []
passedCount2 = 0
Sum2 = 0
print("EXTRA Tests\n------------------------------")
for i in range(51, 61):
    result = run(i)
    Sum2 += result
    testResults2.append(result)
    if(result == 1):
        passedCount2 += 1
print("\nPassed " + str(passedCount) + " out of " + str(50) + "  Sum = " + str(Sum1))
print("\nExtra Passed " + str(passedCount2) + " out of " + str(10) + "  Sum = " + str(Sum2))


headers = [('Test ' + str(i+1)) for i in range(50)] + ['Passed', ""] + [('Extra Test ' + str(i+1)) for i in range(10)] + ['Passed']
testResults = testResults + [passedCount]
testResults2 = testResults2 + [passedCount2]
result = [headers, testResults + [''] + testResults2]

with xlsxwriter.Workbook(GROUP_FOLDER + '\\judge-result.xlsx') as workbook:
    worksheet = workbook.add_worksheet()
    for row_num, data in enumerate(result):
        worksheet.write_row(row_num, 0, data)