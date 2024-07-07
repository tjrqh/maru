# setup-hooks.sh
#!/bin/bash

# .githooks 디렉터리의 모든 파일에 실행 권한 부여
chmod +x .githooks/*

# core.hooksPath 설정
git config core.hooksPath .githooks

echo "Hooks have been set up."
