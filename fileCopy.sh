#!/bin/bash

# 리눅스 연습 기말고사 실습 1번문제
# 파일 경로를 입력받아 복사해주는 프로그램
# Bash script 사용
# 작성자 : 박세훈 (2013. 8. 29)

# 복사하고 싶은 원본 파일의 경로를 입력받는다.
# 예) /home/sehun/sehun/fileCopy.sh
echo "input src filepath~"
read filePath1

# 복사된 파일을 넣고 싶은 경로를 입력받는다.
# 예) /home/sehun/linux132/week1
echo "input dst filepath~"
read filePath2

echo FILE COPY START~!

#입력받은 파일이 디렉토리인지 검사한다.
if [ -d $filePath1 ]
then
	#원본 파일이디렉토리인 경우 에러메세지 출력
	echo "Directory can not copy!"
else
	#디렉토리가 아니면 파일 복사를 수행
	cp $filePath1 $filePath2
	echo "Copy Finish!"
fi
