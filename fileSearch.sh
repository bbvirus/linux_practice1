#!/bin/bash

# 리눅스 연습 기말고사 실습 2번문제
# 파일을 찾아서 경로를 출력해주는 프로그램
# Bash script 사용
# 작성자 : 박세훈

# 검색을 원하는 경로(디렉터리)를 입력받는다.
# 예) /home/sehun
echo "input path for searching~"
read path

# 검색하고 싶은 파일 이름을 입력받는다.
# 예) fileSearch.sh
echo "input file name for searching~"
read fileName

# 해당 이름을 가진 파일이
# (하위 디렉터리를 포함해)디렉터리에 있는지 검사한다.
if [ $(find $path -name $fileName) ]
then
	# 있으면 경로를 출력해준다.
	find $path -name $fileName
	echo "here~"
else
	echo "I can't find it.. maybe file does not exist."
fi
