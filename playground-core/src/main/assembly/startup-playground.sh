#!/usr/bin/env bash
# ----------------------------------------------------------------------------------------------------------------------
# 启动脚本
# ----------------------------------------------------------------------------------------------------------------------

set -e

BIN_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
JAR_DIR="$BIN_DIR"/../jar

if [[ "x$JAVA_HOME" == "x" ]]; then
  echo "环境变量'JAVA_HOME'没有正确配置"
  exit 1
fi

cd "${JAR_DIR}" || exit 1

nohup \
  "$JAVA_HOME"/bin/java \
  -Djava.security.egd=file:/dev/./urandom \
  -Duser.timezone="Asia/Shanghai" \
  -Duser.language="zh" \
  -Duser.country="CN" \
  -jar playground-core-*.jar \
  &> /dev/null &

exit 0