#!/usr/bin/env bash
# ----------------------------------------------------------------------------------------------------------------------
# 启动脚本
# ----------------------------------------------------------------------------------------------------------------------

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

if [[ "x$JAVA_HOME" == "x" ]]; then
  echo "环境变量JAVA_HOME没有正确配置"
  exit 1
else
  echo "环境变量JAVA_HOME:"
  echo "$JAVA_HOME"
fi

cd "${DIR}"/../jar

nohup \
  "$JAVA_HOME"/bin/java \
  -Djava.security.egd=file:/dev/./urandom \
  -Duser.timezone="Asia/Shanghai" \
  -Duser.language="zh" \
  -Duser.country="CN" \
  -jar playground-core-*.jar \
  &> /dev/null &

exit 0