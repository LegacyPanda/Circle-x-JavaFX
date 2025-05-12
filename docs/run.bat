@echo off
cls

cd ..

set "JAVA_HOME=D:\Program Files\Java\jdk-21"
set "PATH=%JAVA_HOME%\bin;%PATH%"

echo Setting directory variables
set "docs=.\docs"
set "lib=.\lib"
set "data=.\data"
set "src=.\src"
set "bin=.\bin"
set "javaDocs=%docs%\javaDocs"
set "javafxlib=D:\Program Files\JavaFX\javafx-sdk-21\lib"

echo Deleting all class files in the bin directory
del /q "%bin%\*.class" 2>null

echo Deleting all txt files in the docs directory
del /q "%docs%\*.txt" 2>null

echo Deleting all the file
del /q "%javaDocs%\*" 2>null

echo Compiling the Application
javac --module-path "%javafxlib%" --add-modules javafx.controls,javafx.fxml -d "%bin%" "%src%\Main.java"


echo Running the Application
java --module-path "%javafxlib%" --add-modules javafx.controls,javafx.fxml -cp "%bin%" Main


echo Decompiling code
javap -c -cp "%bin%" Main > "%docs%\ByteCode.txt"

echo Changing directory into docs
cd "%docs%"

echo I did it 

pause