#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
BUILD_DIR="$ROOT_DIR/out/classes"
SOURCES_FILE="$ROOT_DIR/out/sources.txt"
MAIN_CLASS="${1:-AllPathsFromSourceToTarget}"

if [ "$#" -gt 0 ]; then
  shift
fi

mkdir -p "$BUILD_DIR"
find "$ROOT_DIR" -maxdepth 1 -name '*.java' -print > "$SOURCES_FILE"

javac -d "$BUILD_DIR" @"$SOURCES_FILE"
java -cp "$BUILD_DIR" "$MAIN_CLASS" "$@"
