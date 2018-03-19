@echo off
  cd%~dp1
  echo Compiling %~nx1......
  if exist %~n1.class (
  del %~n1.class
  )
 javac %~nx1
 if exist %~n1.class (
 echo ------Output------
 java %~n1
 )