import subprocess
import os
import xlsxwriter
import sys
from shutil import copyfile

sample_num = sys.argv[1]

GROUP_FOLDER = ".\\groups_edited\\group_" + str(sample_num)

AST_TEST_NUMBER = 20
NAME_TEST_NUMBER = 30

AST_FOLDER_ADDRESS = ".\\Samples\\AST"
NAME_FOLDER_ADDRESS = ".\\Samples\\Name_Analyser"

PROJECT_START_COMMAND = "\"C:\\Users\\98936\\.jdks\\openjdk-15\\bin\\java.exe\" "
PROJECT_START_COMMAND += "\"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2020.2.3\\lib\\idea_rt.jar=50346:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2020.2.3\\bin\" "
PROJECT_START_COMMAND += "-Dfile.encoding=UTF-8 "
PROJECT_START_COMMAND += "-classpath "
PROJECT_START_COMMAND += "\"" + GROUP_FOLDER + "\\out\\production\\Jepeto-Phase2;"
PROJECT_START_COMMAND +=   ".\\antlr-4.9.2-complete.jar\" main.Jepeto "


def run(samplesFolderAddress, shouldSort, i):
    with open(samplesFolderAddress + "\\ans-" + str(i) + ".txt") as temp_file:
        answerLines = [line.rstrip('\n') for line in temp_file if line.rstrip('\n') != '']

    if(len(answerLines) == 0):
        answerLines.append("")
    result = subprocess.run(PROJECT_START_COMMAND + samplesFolderAddress + "\\" + str(i) + ".jp", stdout=subprocess.PIPE, stderr=subprocess.STDOUT, text=True).stdout
    result = result.strip().split('\n')

    # for i in result:
    #     print(i)
    
    if(shouldSort):
        answerLines.sort()
        result.sort()
    
    flag = True
    for j in range(min(len(result), len(answerLines))):
        if(result[j].strip() != answerLines[j].strip()):
            flag = False
            print("first diffrence : ")
            print("source : ", answerLines[j].strip())
            print("test : ", result[j].strip())
            break

    if (flag and len(result) != len(answerLines)):
        if (len(result) < len(answerLines)):
            print("first diffrence : ")
            print("source : ", answerLines[len(result)])
            print("test : ")
        else:
            print("first diffrence : ")
            print("source : ")
            print("test : ", result[len(answerLines)])
        flag = False

    if(flag):
        print("Test " + str(i) + " : Passed")
        print("************************")
        return 1
    else:
        print("Test " + str(i) + " : Failed")
        print("************************")
        return 0
    

AstTestResults = []
ErrorTestResults = []

print("AST Tests\n------------------------------")
for i in range(1, AST_TEST_NUMBER+1):
    AstTestResults.append(run(AST_FOLDER_ADDRESS, False, i))

print("\nError Tests\n------------------------------")
for i in range(1, NAME_TEST_NUMBER+1):
    ErrorTestResults.append(run(NAME_FOLDER_ADDRESS, True, i))

print("\nAST: Passed " + str(sum(AstTestResults)) + " out of " + str(AST_TEST_NUMBER))
print("Error: Passed " + str(sum(ErrorTestResults)) + " out of " + str(NAME_TEST_NUMBER))

headers = [('AST Test ' + str(i+1)) for i in range(AST_TEST_NUMBER)] + ['AST Passed', ""] + [('Error Test ' + str(i+1)) for i in range(NAME_TEST_NUMBER)] + ['Error Passed']
AstTestResults = AstTestResults + [sum(AstTestResults)]
ErrorTestResults = ErrorTestResults + [sum(ErrorTestResults)]
result = [headers, AstTestResults + [''] + ErrorTestResults]
with xlsxwriter.Workbook(GROUP_FOLDER + '\\judge-result.xlsx') as workbook:
    worksheet = workbook.add_worksheet()
    for row_num, data in enumerate(result):
        worksheet.write_row(row_num, 0, data)
