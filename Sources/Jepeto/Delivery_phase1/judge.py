import subprocess
import os
import xlsxwriter
import sys
from shutil import copyfile

group_num = sys.argv[1]
group_dir = ".\\Uploads\\group_" + group_num

TEST_NUMBER = 50

copyfile(group_dir + "\\Jepeto.g4", ".\\Jepeto.g4")

subprocess.run(["java", "-jar", "antlr-4.8-complete.jar", "Jepeto.g4"]) 
subprocess.run(["javac", "-cp", "antlr-4.8-complete.jar", "Jepeto*.java"])

testResults = []

for i in range(1, TEST_NUMBER+1):
# for i in [3, 4, 5, 6,7,8]:
    result = subprocess.run(["java", "-cp", "antlr-4.8-complete.jar;.", "org.antlr.v4.gui.TestRig", "Jepeto", "jepeto", "Samples/" + str(i) + ".jp"],
                             stdout=subprocess.PIPE, stderr=subprocess.STDOUT, text=True).stdout
                    
    result = result.strip().split('\n')

    with open("Samples/ans-" +str(i) + ".txt") as temp_file:
        answerLines = [line.rstrip('\n') for line in temp_file if line.rstrip('\n') != '']
    
    if(len(answerLines) == 0):
        answerLines.append("")

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
        testResults.append(1)
        print("Test " + str(i) + " : Passed")
    else:
        testResults.append(0)
        print("Test " + str(i) + " : Failed")
    print("************************")

print("\nPassed " + str(sum(testResults)) + " out of " + str(TEST_NUMBER) + "\n")

headers = [('Test ' + str(i+1)) for i in range(TEST_NUMBER)] + ['Passed']
testResults = testResults + [sum(testResults)]
result = [headers, testResults]
with xlsxwriter.Workbook(group_dir + "\\judge-result.xlsx") as workbook:
    worksheet = workbook.add_worksheet()
    for row_num, data in enumerate(result):
        worksheet.write_row(row_num, 0, data)

for filename in os.listdir('.'):
    if(not os.path.isdir(filename)):
        if(filename != 'antlr-4.8-complete.jar' and filename != 'judge.py' and filename != 'statistics.xlsx'):
            os.remove(filename)