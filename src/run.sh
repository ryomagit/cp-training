#!/bin/bash

if [ -z "$1" ]; then
  echo "❗ 実行には問題名を指定してください（例: ./run.sh test）"
  exit 1
fi

PROBLEM=$1
PROB_DIR="./problems/$PROBLEM"

if [ ! -d "$PROB_DIR" ]; then
  echo "❗ 指定された問題 '$PROBLEM' が見つかりません"
  exit 1
fi

echo "▶️ 実行中: $PROBLEM"

# 相対パスでプロジェクトルートを維持したままコンパイル・実行
SRC_DIR=$(pwd)
JAVAFILE="$PROB_DIR/Main.java"
CLASSNAME="problems.$PROBLEM.Main"

javac "$JAVAFILE"
if [ $? -ne 0 ]; then
  echo "❌ コンパイルエラー"
  exit 1
fi

java -cp "$SRC_DIR" "$CLASSNAME" < "$PROB_DIR/input.txt"